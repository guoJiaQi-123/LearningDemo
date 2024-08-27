package com.itbaizhan.paymentdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.generator.config.querys.OscarQuery;
import com.itbaizhan.paymentdemo.config.WxPayConfig;
import com.itbaizhan.paymentdemo.entity.OrderInfo;
import com.itbaizhan.paymentdemo.entity.RefundInfo;
import com.itbaizhan.paymentdemo.enums.OrderStatus;
import com.itbaizhan.paymentdemo.enums.wx.WxApiType;
import com.itbaizhan.paymentdemo.enums.wx.WxNotifyType;
import com.itbaizhan.paymentdemo.enums.wx.WxTradeState;
import com.itbaizhan.paymentdemo.ov.BaseResult;
import com.itbaizhan.paymentdemo.ov.CodeEnum;
import com.itbaizhan.paymentdemo.ov.PayInfoVO;
import com.itbaizhan.paymentdemo.service.IPaymentInfoService;
import com.itbaizhan.paymentdemo.service.IRefundInfoService;
import com.itbaizhan.paymentdemo.service.IWxPaymentService;
import com.itbaizhan.paymentdemo.utils.WxVerifierUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 微信支付业务层实现类
 */
@Service
@Slf4j
public class WxPaymentServiceImpl implements IWxPaymentService {

    private final OrderInfoServiceImpl orderInfoService; // 订单接口

    private final WxPayConfig wxPayConfig;// 微信支付配置参数

    private final CloseableHttpClient wxPayClient;// 微信http请求对象

    private final IPaymentInfoService paymentInfoService; // 交易记录接口

    private final IRefundInfoService refundInfoService; // 退款接口


    // 独享锁
    private final ReentrantLock lock = new ReentrantLock();

    @Autowired
    public WxPaymentServiceImpl(OrderInfoServiceImpl orderInfoService, WxPayConfig wxPayConfig, CloseableHttpClient wxPayClient, IPaymentInfoService paymentInfoService, IRefundInfoService refundInfoService) {
        this.orderInfoService = orderInfoService;
        this.wxPayConfig = wxPayConfig;
        this.wxPayClient = wxPayClient;
        this.paymentInfoService = paymentInfoService;
        this.refundInfoService = refundInfoService;
    }


    @Override
    public BaseResult<PayInfoVO> nativePay(String orderNo) throws IOException {
        // 1.根据商户订单编号查询订单
        OrderInfo orderInfo = orderInfoService.findByOrderNo(orderNo);
        if (orderInfo == null) {
            return BaseResult.error(CodeEnum.ORDER_ERROR);
        }
        // 防止重复支付，保证接口幂等
        // 如果在查询到的订单中发现已经存在codeUrl说明已经不是第一次请求该接口，直接封装数据返回即可
        if (!StringUtils.isEmpty(orderInfo.getCodeUrl())) {
            PayInfoVO payInfoVO = new PayInfoVO(orderInfo.getCodeUrl(), orderNo);
            return BaseResult.ok(payInfoVO);
        }

        // 2.调用统一的下单api https://api.mch.weixin.qq.com/v3/pay/transactions/native
        HttpPost httpPost = new HttpPost(wxPayConfig.getDomain().concat(WxApiType.NATIVE_PAY.getType()));

        // 3.定义参数
        Map<String, Object> paramsMap = getParamsMap(orderInfo);

        // 4.将参数转为JSON字符串
        String jsonString = JSON.toJSONString(paramsMap);
        log.info("Native下单参数 ======> " + jsonString);

        // 5. 准备请求体 entity
        StringEntity entity = new StringEntity(jsonString, "utf-8");
        entity.setContentType("application/json");
        // 向 post 请求中设置请求头
        httpPost.setEntity(entity);
        // 6. 准备请求头
        httpPost.setHeader("Accept", "application/json");
        // 7. 使用微信 http请求对象向微信服务端发送post请求获取响应
        // try - with - resource 写法
        try (CloseableHttpResponse response = wxPayClient.execute(httpPost)) {
            // 8. 拿出 body 响应体
            String bodyString = EntityUtils.toString(response.getEntity());
            // 9. 获取响应状态码
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) { // 响应成功
                // 将响应体数据的JSON格式转换为  HashMap 格式
                HashMap<String, String> responseMap = JSON.parseObject(bodyString, HashMap.class);
                // 获取响应体中的 code_url
                String codeUrl = responseMap.get("code_url");

                // 获取到 codeUrl 以后，调用saveCodeUrl方法将codeUrl保存到数据库
                orderInfoService.saveCodeUrl(orderInfo.getId(), codeUrl);

                // 封装结果到一个VO层数据传输对象中 [ 属性一：codeUrl二维码连接   属性二：订单唯一编号 ]
                PayInfoVO payInfoVO = new PayInfoVO(codeUrl, orderInfo.getOrderNo());
                return BaseResult.ok(payInfoVO);
            } else { // 响应失败
                log.error("Native支付失败 响应码状态为 + " + statusCode + " 提示信息：" + bodyString);
                return BaseResult.error(CodeEnum.PAYMENT_ERROR);
            }
        }
    }


    /**
     *
     * 根据支付成功订单通知修改支付状态
     * @param bodyMap  请求体中的数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateOrderStatus(Map<String, Object> bodyMap) {
        log.info("******************* 处理订单 *******************");
        // 获取明文
        String plainText = WxVerifierUtils.decrypt(bodyMap, wxPayConfig.getApiV3Key());
        // 将字符串转换为HashMap对象
        HashMap<String, Object> plainTextMap = JSON.parseObject(plainText, HashMap.class);
        // 获取订单编号
        String orderNo = (String) plainTextMap.get("out_trade_no");

        // 尝试获取锁
        if (lock.tryLock()) {
            try {
                // 查询订单
                OrderInfo orderInfo = orderInfoService.findByOrderNo(orderNo);
                // 如果订单状态为未支付，则更新为已支付
                if (!orderInfo.getOrderStatus().equals(OrderStatus.NOTPAY.getType())) {
                    return;
                }
                // 更新订单状态
                orderInfoService.updateOrderStatus(orderInfo.getId(), OrderStatus.SUCCESS);
                // 记录交易日志
                paymentInfoService.insertPaymentInfo(plainTextMap);
            } finally {
                // finally块中释放锁
                lock.unlock();
            }
        }

    }

    /**
     * 商户订单号查询订单
     *
     * @param orderNo 订单编号
     * @return 订单信息
     * https://api.mch.weixin.qq.com/v3/pay/transactions/out-trade-no/1217752501201407033233368018?mchid=1230000109
     */
    @Override
    public String queryOrder(String orderNo) throws IOException {
        log.info("查单接口调用 ===> {}", orderNo);
        // 构造请求url
        String url = String.format(WxApiType.ORDER_QUERY_BY_NO.getType(), orderNo);
        url = wxPayConfig.getDomain().concat(url).concat("?mchid=").concat(wxPayConfig.getMchId());
        // 构造httpGet对象
        HttpGet httpGet = new HttpGet(url);
        // 设置请求头参数
        httpGet.setHeader("Accept", "application/json");
        // 完成签名并执行请求
        try (CloseableHttpResponse response = wxPayClient.execute(httpGet)) {
            String bodyAsString = EntityUtils.toString(response.getEntity());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                log.info("******************* 请求成功 *******************");
                log.info("响应体 ===> {}", bodyAsString);
            } else if (statusCode == 204) {
                log.info("******************* 请求成功 *******************");
            } else {
                log.error("******************* 请求失败 *******************");
                log.error("响应码：" + statusCode + "———提示信息：" + bodyAsString);
            }
            return bodyAsString;
        }
    }


    /**
     * 根据订单ID核实订单状态
     * @param orderNo 订单编号
     */
    @Override
    public void orderStatusConfirm(String orderNo) throws IOException {
        // 查询微信服务端的订单状态
        String WXClientOrder = queryOrder(orderNo);
        // json转map
        HashMap<String, Object> WXClientOrderMap = JSON.parseObject(WXClientOrder, HashMap.class);
        // 获取支付状态
        String tradeState = (String) WXClientOrderMap.get("trade_state");
        if (tradeState.equals(WxTradeState.SUCCESS.getType())) {
            // 核实订单状态为 ==> 已支付
            log.warn("核实订单状态为 ==> 已支付  订单编号：{}", orderNo);
            // 如果确认订单已支付则更新本地订单状态
            orderInfoService.updateOrderStatus(orderNo, OrderStatus.SUCCESS);
            // 写入交易日志
            paymentInfoService.insertPaymentInfo(WXClientOrderMap);
        }
        if (tradeState.equals(WxTradeState.NOTPAY.getType())) {
            log.info("订单状态核实正常");
            closeOrder(orderNo);
            // 关闭订单 - 超过5分钟没有支付
            orderInfoService.updateOrderStatus(orderNo, OrderStatus.CLOSED);
        }

    }

    /**
     * 取消订单
     * @param orderNo 订单编号
     */
    @Override
    public void cancelOrder(String orderNo) throws IOException {
        closeOrder(orderNo);
        orderInfoService.updateOrderStatus(orderNo, OrderStatus.CANCEL);
    }

    /**
     * 根据订单编号退款
     * @param orderNo 订单编号
     * @param reason 退款原因
     */
    @Override
    public void refund(String orderNo, String reason) throws IOException {
        // 修改订单状态未退款中
        orderInfoService.updateOrderStatus(orderNo, OrderStatus.REFUND_PROCESSING);
        // 1. 创建退款单
        RefundInfo refundInfo = refundInfoService.createRefundInfoByOrderNo(orderNo, reason);
        // 2. 调用微信后台的退款接口实现退款
        // 3. 定义url
        String url = wxPayConfig.getDomain().concat(WxApiType.DOMESTIC_REFUNDS.getType());
        // 4. 定义post请求
        HttpPost httpPost = new HttpPost(url);
        // 5. 设置请求参数
        Map<String, Object> params = new HashMap<>();
        // 商户退款单号
        params.put("out_refund_no", refundInfo.getRefundNo());
        // 商户订单号
        params.put("out_trade_no", refundInfo.getOrderNo());
        // 退款原因
        params.put("reason", refundInfo.getReason());
        // 退款的通知接口
        params.put("notify_url", wxPayConfig.getNotifyDomain().concat(WxNotifyType.REFUND_NOTIFY.getType()));
        // 订单金额信息
        Map<String, Object> amount = new HashMap<>();
        params.put("amount", amount);
        // 退款金额
        amount.put("refund", refundInfo.getRefund());
        // 原订单金额
        amount.put("total", refundInfo.getTotalFee());
        // 退款币种
        amount.put("currency", "CNY");
        // 6. 将参数转换为JSON字符串
        String paramsJSON = JSON.toJSONString(params);
        StringEntity paramsEntity = new StringEntity(paramsJSON, StandardCharsets.UTF_8);
        paramsEntity.setContentType("application/json");
        // 设置请求体
        httpPost.setEntity(paramsEntity);
        // 设置请求头
        httpPost.setHeader("Accept", "application/json");
        // 发送请求
        try (CloseableHttpResponse response = wxPayClient.execute(httpPost)) {
            String bodyString = EntityUtils.toString(response.getEntity());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                log.info("******************* 微信后台退款成功 *******************");
            } else {
                log.error("******************* 微信后台退款失败 *******************");
                log.error("失败状态码为：" + statusCode);
                orderInfoService.updateOrderStatus(orderNo, OrderStatus.REFUND_ABNORMAL);
                throw new IOException("request fail");
            }
            // 更新退款单数据
            refundInfoService.updateRefund(bodyString);
        }
    }

    /**
     * 修改退款单数据
     * @param bodyMap 退款通知参数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRefundStatus(HashMap<String, Object> bodyMap) {
        log.info("******************* 处理退款订单 *******************");
        // 获取明文
        String plainText = WxVerifierUtils.decrypt(bodyMap, wxPayConfig.getApiV3Key());
        // 将字符串转换为HashMap对象
        HashMap<String, Object> plainTextMap = JSON.parseObject(plainText, HashMap.class);
        // 获取商户订单号
        String orderNo = (String) plainTextMap.get("out_trade_no");

        // 尝试获取锁
        if (lock.tryLock()) {
            try {
                // 查询订单
                OrderInfo orderInfo = orderInfoService.findByOrderNo(orderNo);
                // 如果订单状态为退款中，则更新为退款成功
                if (!orderInfo.getOrderStatus().equals(OrderStatus.REFUND_PROCESSING.getType())) {
                    return;
                }
                // 更新订单状态
                orderInfoService.updateOrderStatus(orderInfo.getId(), OrderStatus.REFUND_SUCCESS);
                // 修改退款单状态
                refundInfoService.updateRefundStatus(plainText);
            } finally {
                // finally块中释放锁
                lock.unlock();
            }
        }
    }

    /**
     * 根据订单编号关闭微信后台的订单
     * @param orderNo 订单编号
     */
    private void closeOrder(String orderNo) throws IOException {
        // 拼接URL
        String url = String.format(WxApiType.CLOSE_ORDER_BY_NO.getType(), orderNo);
        url = wxPayConfig.getDomain().concat(url);
        // 定义post请求
        HttpPost httpPost = new HttpPost(url);
        // 组装参数
        Map<String, String> params = new HashMap<>();
        params.put("mchid", wxPayConfig.getMchId());
        // 参数转位json字符串
        String paramsJSON = JSON.toJSONString(params);
        // 设置请求体
        StringEntity stringEntity = new StringEntity(paramsJSON, StandardCharsets.UTF_8);
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        // 设置请求头
        httpPost.setHeader("Accept", "application/json");
        try (CloseableHttpResponse response = wxPayClient.execute(httpPost)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                log.info("******************* 关单成功 *******************");
            } else if (statusCode == 204) {
                log.info("******************* 关单成功 *******************");
            } else {
                log.error("******************* 关单失败 *******************");
                log.error("状态码：" + statusCode);
                throw new IOException("request fail");
            }
        }
    }

    /**
     * 定义参数
     * @param orderInfo 订单信息
     * @return 参数map
     */
    private Map<String, Object> getParamsMap(OrderInfo orderInfo) {
        Map<String, Object> paramsMap = new HashMap<>();
        // 公众号ID
        paramsMap.put("appid", wxPayConfig.getAppid());
        // 直连商户号
        paramsMap.put("mchid", wxPayConfig.getMchId());
        // 商品描述
        paramsMap.put("description", "test");
        // 商户订单号
        paramsMap.put("out_trade_no", orderInfo.getOrderNo());
        // 通知地址  http://decho.natapp1.cc /api/wx-pay/native/notify
        paramsMap.put("notify_url", wxPayConfig.getNotifyDomain().concat(WxNotifyType.NATIVE_NOTIFY.getType()));
        Map<String, Integer> amountMap = new HashMap<>();
        // 总金额
        amountMap.put("total", orderInfo.getTotalFee());
        // 订单金额
        paramsMap.put("amount", amountMap);
        return paramsMap;
    }
}

package com.itbaizhan.paymentdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.itbaizhan.paymentdemo.config.ZfbPayConfig;
import com.itbaizhan.paymentdemo.entity.OrderInfo;
import com.itbaizhan.paymentdemo.entity.PaymentInfo;
import com.itbaizhan.paymentdemo.entity.RefundInfo;
import com.itbaizhan.paymentdemo.enums.OrderStatus;
import com.itbaizhan.paymentdemo.enums.PayType;
import com.itbaizhan.paymentdemo.enums.zfb.ZfbNotifyType;
import com.itbaizhan.paymentdemo.ov.BaseResult;
import com.itbaizhan.paymentdemo.ov.PayInfoVO;
import com.itbaizhan.paymentdemo.service.IOrderInfoService;
import com.itbaizhan.paymentdemo.service.IPaymentInfoService;
import com.itbaizhan.paymentdemo.service.IRefundInfoService;
import com.itbaizhan.paymentdemo.service.IZfbPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/04/20
 * @apiNote 支付宝支付业务层
 */
@Slf4j
@Service
public class ZfbPaymentServiceImpl implements IZfbPaymentService {

    private final IOrderInfoService orderInfoService; // 订单接口

    private final AlipayClient alipayClient; // 支付宝客户端

    private final ZfbPayConfig zfbPayConfig; // 支付宝配置文件

    private final IPaymentInfoService paymentInfoService; // 交易接口

    private final IRefundInfoService refundInfoService; // 退款接口

    @Autowired
    public ZfbPaymentServiceImpl(IOrderInfoService orderInfoService, AlipayClient alipayClient, ZfbPayConfig zfbPayConfig, IPaymentInfoService paymentInfoService, IRefundInfoService refundInfoService) {
        this.orderInfoService = orderInfoService;
        this.alipayClient = alipayClient;
        this.zfbPayConfig = zfbPayConfig;
        this.paymentInfoService = paymentInfoService;
        this.refundInfoService = refundInfoService;
    }

    /**
     * 支付宝下单接口
     * @param orderNo 订单编号
     * @return 支付返回信息 [<br></br>
     *                      qr_code：当前预下单请求生成的二维码码串<br></br>
     *                      out_trade_no：商户的订单号<br></br>
     *                     ]
     */
    @Override
    public BaseResult<PayInfoVO> pcPay(String orderNo) {
        // 1. 根据订单编号查询订单信息
        OrderInfo orderInfo = orderInfoService.findByOrderNo(orderNo);
        // 2. 构造参数
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        // 通知地址  http://decho.natapp1.cc/api/zfb-pay/pcPay/notify

        request.setNotifyUrl(zfbPayConfig.getNotifyUrl().concat(ZfbNotifyType.PC_NOTIFY.getType()));
        JSONObject bizContent = new JSONObject();
        // 订单编号
        bizContent.put("out_trade_no", orderNo);
        // 订单金额
        bizContent.put("total_amount", orderInfo.getTotalFee());
        // 订单标题
        bizContent.put("subject", orderInfo.getTitle());
        request.setBizContent(bizContent.toString());
        try {
            // 向微信后台发送下单请求
            AlipayTradePrecreateResponse response = alipayClient.execute(request);
            if (!response.isSuccess()) {
                log.error("******************* 支付宝下单失败 *******************");
            }
            log.info("******************* 支付宝下单成功 *******************");
            String qrCode = response.getQrCode();
            orderInfoService.saveCodeUrl(orderInfo.getId(), qrCode);
            PayInfoVO payInfoVO = new PayInfoVO(qrCode, orderNo);
            return BaseResult.ok(payInfoVO);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 支付成功后修改支付订单状态
     * @param request 回调请求
     */
    @Override
    public void updateOrderStatus(HttpServletRequest request) {
        String tradeStatus = request.getParameter("trade_status");
        if (tradeStatus.equals("TRADE_SUCCESS")) {
            String orderNo = request.getParameter("out_trade_no");
            OrderInfo orderInfo = orderInfoService.findByOrderNo(orderNo);
            if (!orderInfo.getOrderStatus().equals(OrderStatus.NOTPAY.getType())) {
                return;
            }
            log.info("******************* 交易支付成功 *******************");
            // 修改订单状态未支付成功
            orderInfoService.updateOrderStatus(orderInfo.getOrderNo(), OrderStatus.SUCCESS);
            // 添加交易记录
            PaymentInfo paymentInfo = new PaymentInfo();
            // 订单编号
            paymentInfo.setOrderNo(orderNo);
            // 交易编号
            String tradeNo = request.getParameter("trade_no");
            paymentInfo.setTransactionId(tradeNo);
            // 通知参数
            paymentInfo.setContent(JSON.toJSONString(request.getParameterMap()));
            // 交易状态
            paymentInfo.setTradeState(tradeStatus);
            // 交易类型
            paymentInfo.setTradeType("当面付");
            // 交易金额
            paymentInfo.setPayerTotal(orderInfo.getTotalFee());
            // 支付类型
            paymentInfo.setPaymentType(PayType.ALIPAY.getType());
            paymentInfoService.save(paymentInfo);
        } else {
            log.error("******************* 交易支付失败 *******************");
            throw new RuntimeException("交易支付失败");
        }
    }

    /**
     * 支付宝退款
     * @param orderNo 订单编号
     * @param reason 退款原因
     */
    @Override
    public void refund(String orderNo, String reason) throws AlipayApiException {
        log.info("************* 创建退款单 ******");
        // 1.根据订单编号创建退款单
        RefundInfo refundInfo = refundInfoService.createRefundInfoByOrderNo(orderNo, reason);
        // 2. 向支付宝后台发送退款请求
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        JSONObject bizContent = new JSONObject();
        // 订单号
        bizContent.put("out_trade_no", orderNo);
        // 退款金额
        bizContent.put("refund_amount", refundInfo.getTotalFee());
        // 退款原因
        bizContent.put("refund_reason", reason);
        request.setBizContent(bizContent.toString());
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            log.info("******************* 退款成功 *******************");
            // 修改订单状态
            orderInfoService.updateOrderStatus(orderNo, OrderStatus.REFUND_SUCCESS);
            // 修改退款单状态
            refundInfoService.updateRefundAliStatus(orderNo);
        } else {
            log.error("******************* 退款失败 *******************");
        }
    }

    /**
     * 查询交易状态
     * @param orderNo 订单编号
     * @return 交易状态
     */
    @Override
    public String queryOrder(String orderNo) throws Exception {

        // 构造请求参数以调用接口
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();

        // 设置订单支付时传入的商户订单号
        model.setOutTradeNo("1713613263948");

        // 设置查询选项
        List<String> queryOptions = new ArrayList<String>();
        queryOptions.add("trade_settle_info");
        model.setQueryOptions(queryOptions);

        // 设置支付宝交易号
        model.setTradeNo("2024042022001447320502859108");

        request.setBizModel(model);
        AlipayTradeQueryResponse response = alipayClient.execute(request);

        if (response.isSuccess()) {
            return response.getBody();
        } else {
            throw new RuntimeException("查询交易状态失败");
        }


    }
}

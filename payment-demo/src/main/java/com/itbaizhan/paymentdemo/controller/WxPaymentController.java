package com.itbaizhan.paymentdemo.controller;

import com.alibaba.fastjson.JSON;
import com.itbaizhan.paymentdemo.ov.BaseResult;
import com.itbaizhan.paymentdemo.ov.PayInfoVO;
import com.itbaizhan.paymentdemo.service.IWxPaymentService;
import com.itbaizhan.paymentdemo.utils.HttpUtils;
import com.itbaizhan.paymentdemo.utils.WxVerifierUtils;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote Native下单支付控制层
 * weixin://wxpay/bizpayurl?pr=tJ5FdRkz1
 */
@RestController
@Slf4j
@RequestMapping("/api/wx-pay")
public class WxPaymentController {

    private final IWxPaymentService wxPaymentService; // 微信支付接口
    private final Verifier verifier; // 签名验证对象

    public WxPaymentController(IWxPaymentService wxPaymentService, Verifier verifier) {
        this.wxPaymentService = wxPaymentService;
        this.verifier = verifier;
    }

    /**
     * Native 支付下单
     * @param orderNo 订单编号 - 根据这条订单创建一个Native支付codeUrl
     * @return VO层数据传输对象  [ 属性一：codeUrl 二维码链接  属性二：订单的唯一编号 ]
     */
    @RequestMapping("/native/{orderNo}")
    public BaseResult<PayInfoVO> nativePay(@PathVariable String orderNo) throws IOException {
        return wxPaymentService.nativePay(orderNo);
    }

    /**
     * 微信支付完成后回调通知接口
     * @param request 请求
     * @param response 响应
     */
    @PostMapping("/native/notify")
    public String notify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Map<String, String> responseMap = new HashMap<>();
        // 将请求体中的数据使用工具类转换为字符串格式
        String body = HttpUtils.readData(request);
        HashMap<String, Object> bodyMap = JSON.parseObject(body, HashMap.class);
        log.info("通知的唯一ID =====> " + bodyMap.get("id"));
        log.info("通知的全部数据 ====> " + body);

        //  : 签名的验证 确保调用该接口的是微信服务端
        boolean verified = WxVerifierUtils.verifier(request, this.verifier, body);
        if (!verified) {
            response.setStatus(500);
            responseMap.put("code", "FAIL");
            responseMap.put("message", "失败");
            return JSON.toJSONString(responseMap);
        }
        //  : 处理订单
        wxPaymentService.updateOrderStatus(bodyMap);

        //成功应答：成功应答必须为200或204，否则就是失败应答
        response.setStatus(200);
        responseMap.put("code", "SUCCESS");
        responseMap.put("message", "成功");
        return JSON.toJSONString(responseMap);
    }

    /**
     * 根据订单编号查询订单
     * @param orderNo 订单编号
     * @return 查询到的订单
     */
    @GetMapping("/queryOrderStatus/{orderNo}")
    public BaseResult<String> queryOrderStatus(@PathVariable String orderNo) throws IOException {
        return BaseResult.ok(wxPaymentService.queryOrder(orderNo));
    }


    /**
     * 根据订单编号取消订单
     * @param orderNo 订单编号
     */
    @PostMapping("/cancel/{orderNo}")
    public BaseResult<String> cancelOrder(@PathVariable String orderNo) throws IOException {
        wxPaymentService.cancelOrder(orderNo);
        return BaseResult.ok("订单已取消");
    }


    /**
     * 根据订单编号退款接口
     * @param orderNo 订单编号
     * @param reason 退款原因
     */
    @PostMapping("/refunds/{orderNo}/{reason}")
    public BaseResult<String> refund(@PathVariable String orderNo,
                                     @PathVariable String reason) throws IOException {
        wxPaymentService.refund(orderNo, reason);
        return BaseResult.ok("退款成功");
    }

    /**
     * 微信退款完成后回调通知接口
     * @param request 请求
     * @param response 响应
     */
    @PostMapping("/refunds/notify")
    public String refundsNotify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Map<String, String> responseMap = new HashMap<>();
        // 将请求体中的数据使用工具类转换为字符串格式
        String body = HttpUtils.readData(request);
        HashMap<String, Object> bodyMap = JSON.parseObject(body, HashMap.class);
        log.info("退款通知的唯一ID =====> " + bodyMap.get("id"));
        log.info("退款通知的全部数据 ====> " + body);

        //  : 签名的验证 确保调用该接口的是微信服务端
        boolean verified = WxVerifierUtils.verifier(request, this.verifier, body);
        if (!verified) {
            response.setStatus(500);
            responseMap.put("code", "FAIL");
            responseMap.put("message", "失败");
            return JSON.toJSONString(responseMap);
        }
        //  : 处理退款订单
        wxPaymentService.updateRefundStatus(bodyMap);

        //成功应答：成功应答必须为200或204，否则就是失败应答
        response.setStatus(200);
        responseMap.put("code", "SUCCESS");
        responseMap.put("message", "成功");
        return JSON.toJSONString(responseMap);
    }
}

package com.itbaizhan.paymentdemo.controller;

import com.alipay.api.AlipayApiException;
import com.itbaizhan.paymentdemo.config.ZfbPayConfig;
import com.itbaizhan.paymentdemo.ov.BaseResult;
import com.itbaizhan.paymentdemo.ov.PayInfoVO;
import com.itbaizhan.paymentdemo.service.IZfbPaymentService;
import com.itbaizhan.paymentdemo.utils.ZfbVerifierUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version v1.0
 * @author OldGj 2024/04/20
 * @apiNote 支付宝支付控制层
 */
@RestController
@Slf4j
@RequestMapping("/api/zfb-pay")
public class ZfbPaymentController {

    private final IZfbPaymentService zfbPaymentService; // 支付宝业务层接口

    private final ZfbPayConfig zfbPayConfig;

    @Autowired
    public ZfbPaymentController(IZfbPaymentService zfbPaymentService, ZfbPayConfig zfbPayConfig) {
        this.zfbPaymentService = zfbPaymentService;
        this.zfbPayConfig = zfbPayConfig;
    }

    /**
     * 根据订单编号发起支付宝支付
     * @param orderNo 订单编号
     * @return 二维码连接
     */
    @PostMapping("/pcPay/{orderNo}")
    public BaseResult<PayInfoVO> pcPay(@PathVariable String orderNo) {
        log.info("******************* 发起支付宝支付请求 *******************");
        return zfbPaymentService.pcPay(orderNo);
    }

    /**
     * 支付成功后支付宝后台进行回调的接口
     * @param request 支付宝发来的请求
     * @return
     */
    @PostMapping("/pcPay/notify")
    public String notify(HttpServletRequest request, HttpServletResponse response) {
        // 1. 验签
        boolean verifier = ZfbVerifierUtils.isVerifier(request, zfbPayConfig.getPublicKey());

        if (verifier) {
            log.info("验签成功");
            // 保存订单信息和交易信息
            zfbPaymentService.updateOrderStatus(request);
        } else {
            log.info("验签失败");
        }
        return "SUCCESS";
    }

    /**
     * 退款
     * @param orderNo 订单编号
     * @param reason 退款原因
     */
    @PostMapping("/refunds/{orderNo}/{reason}")
    public BaseResult<String> refund(@PathVariable String orderNo, @PathVariable String reason) throws AlipayApiException {
        zfbPaymentService.refund(orderNo, reason);
        return BaseResult.ok("退款成功");
    }


    /**
     * 根据订单编号查询订单
     * @param orderNo 订单编号
     * @return 查询到的订单
     */
    @GetMapping("/queryOrderStatus/{orderNo}")
    public BaseResult<String> queryOrderStatus(@PathVariable String orderNo) throws Exception {
        return BaseResult.ok(zfbPaymentService.queryOrder(orderNo));
    }
}

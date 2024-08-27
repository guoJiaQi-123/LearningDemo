package com.tyut.payment.controller;

import com.tyut.domain.R;
import com.tyut.payment.domain.TPaymentInfo;
import com.tyut.payment.service.TPaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/8/20
 * @apiNote 支付控制层
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private TPaymentInfoService paymentInfoService;

    /**
     * 查询所有交易记录
     * @return 交易记录集合
     */
    @GetMapping("/findAllPaymentInfo")
    public R findAllPaymentInfo() {
        List<TPaymentInfo> list = paymentInfoService.list();
        return R.ok(list);
    }

    /**
     * 根据交易id查询交易记录
     * @param id 交易id
     * @return 交易记录
     */
    @GetMapping("/findPaymentInfoById")
    public R findPaymentInfoById(@RequestParam("id") Long id) {
        TPaymentInfo paymentInfo = paymentInfoService.getById(id);
        return R.ok(paymentInfo);
    }


    @GetMapping("/info")
    public R info() {
        return R.ok("8001 success");
    }
}

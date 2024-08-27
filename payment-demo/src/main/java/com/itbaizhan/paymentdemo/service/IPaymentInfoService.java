package com.itbaizhan.paymentdemo.service;

import com.itbaizhan.paymentdemo.entity.PaymentInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;


/**
 * 交易记录业务层
 */
public interface IPaymentInfoService extends IService<PaymentInfo> {

    /**
     * 添加交易记录
     * @param plainTextMap 微信服务端返回的请求体中的数据
     */
    void insertPaymentInfo(Map<String, Object> plainTextMap);


}

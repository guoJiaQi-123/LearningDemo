package com.itbaizhan.paymentdemo.service.impl;




import com.alibaba.fastjson.JSON;
import com.itbaizhan.paymentdemo.entity.PaymentInfo;
import com.itbaizhan.paymentdemo.enums.PayType;
import com.itbaizhan.paymentdemo.mapper.PaymentInfoMapper;
import com.itbaizhan.paymentdemo.service.IPaymentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote
 */
@Service
@Slf4j
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements IPaymentInfoService {

    /**
     * 添加交易记录
     * @param plainTextMap 微信服务端返回的请求体中的数据
     */
    @Override
    public void insertPaymentInfo(Map<String, Object> plainTextMap) {
        log.info("******************** 添加交易记录 ********************");
        // 1. 获取商户系统内部订单号
        String orderNo = (String) plainTextMap.get("out_trade_no");
        // 2. 获取微信支付系统生成的订单号。[ 交易号 ]
        String transactionId = (String) plainTextMap.get("transaction_id");
        // 3. 获取交易类型
        String tradeType = (String) plainTextMap.get("trade_type");
        // 4. 交易状态
        String tradeState = (String) plainTextMap.get("trade_state");
        // 5.订单金额信
        Map<String, Object> amount = (Map<String, Object>)plainTextMap.get("amount");
        // 用户支付金额，单位为分。
        Integer payerTotal = (Integer) amount.get("payer_total");
        PaymentInfo paymentInfo = new PaymentInfo();
        // 订单编号
        paymentInfo.setOrderNo(orderNo);
        // 交易类型
        paymentInfo.setPaymentType(PayType.WXPAY.getType());
        // 微信支付订单号
        paymentInfo.setTransactionId(transactionId);
        // 交易类型
        paymentInfo.setTradeType(tradeType);
        // tradeState
        paymentInfo.setTradeState(tradeState);
        // 用户支付金额
        paymentInfo.setPayerTotal(payerTotal);
        // 通知参数
        paymentInfo.setContent(JSON.toJSONString(plainTextMap));
        int insert = baseMapper.insert(paymentInfo);
        if (insert > 0) {
            log.info("交易记录创建成功");
        } else {
            log.info("交易记录创建失败");
        }
    }
}

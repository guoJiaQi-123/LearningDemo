package com.itbaizhan.paymentdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.itbaizhan.paymentdemo.entity.OrderInfo;
import com.itbaizhan.paymentdemo.entity.RefundInfo;
import com.itbaizhan.paymentdemo.enums.OrderStatus;
import com.itbaizhan.paymentdemo.mapper.RefundInfoMapper;
import com.itbaizhan.paymentdemo.service.IOrderInfoService;
import com.itbaizhan.paymentdemo.service.IRefundInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 支付记录实体类
 */
@Service
@Slf4j
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfo> implements IRefundInfoService {

    private final IOrderInfoService orderInfoService;

    public RefundInfoServiceImpl(IOrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
    }

    @Override
    public RefundInfo createRefundInfoByOrderNo(String orderNo, String reason) {
        // 根据订单编号查询订单
        OrderInfo orderInfo = orderInfoService.findByOrderNo(orderNo);
        // 创建退款单实体类
        RefundInfo refundInfo = new RefundInfo();
        // 退款单编号
        refundInfo.setRefundNo(String.valueOf(System.currentTimeMillis()));
        // 订单编号
        refundInfo.setOrderNo(orderNo);
        // 退款金额
        refundInfo.setRefund(orderInfo.getTotalFee());
        // 原订单金额
        refundInfo.setTotalFee(orderInfo.getTotalFee());
        // 退款原因
        refundInfo.setReason(reason);
        int inserted = baseMapper.insert(refundInfo);
        if (inserted > 0) {
            log.info("******************* 数据库退款成功 *******************");
        } else {
            log.error("******************* 数据库退款失败 *******************");
        }
        return refundInfo;
    }

    /**
     * 更新退款单数据
     * @param bodyString 微信后台的响应数据
     */
    @Override
    public void updateRefund(String bodyString) {
        // 微信后台的响应数据JSON转map
        HashMap<String, Object> responseMap = JSON.parseObject(bodyString, HashMap.class);
        // 获取微信支付退款号
        String refundId = (String) responseMap.get("refund_id");
        // 获取商户订单号
        String outTradeNo = (String) responseMap.get("out_refund_no");
        // 获取退款状态
        String status = (String) responseMap.get("status");
        LambdaUpdateWrapper<RefundInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(RefundInfo::getRefundStatus, status);
        lambdaUpdateWrapper.set(RefundInfo::getRefundId, refundId);
        lambdaUpdateWrapper.set(RefundInfo::getContentReturn, bodyString);
        lambdaUpdateWrapper.eq(RefundInfo::getRefundNo, outTradeNo);
        baseMapper.update(null, lambdaUpdateWrapper);
    }

    /**
     * 修改退款单状态
     * @param bodyString 微信后台的通知回调参数
     */
    @Override
    public void updateRefundStatus(String bodyString) {
        HashMap<String, Object> bodyMap = JSON.parseObject(bodyString, HashMap.class);
        String refundStatus = (String) bodyMap.get("refund_status");
        String outRefundNo = (String) bodyMap.get("out_refund_no");
        LambdaUpdateWrapper<RefundInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(RefundInfo::getRefundStatus, refundStatus);
        lambdaUpdateWrapper.set(RefundInfo::getContentNotify, bodyString);
        lambdaUpdateWrapper.eq(RefundInfo::getRefundNo, outRefundNo);
        baseMapper.update(null, lambdaUpdateWrapper);
    }

    /**
     * 修改退款单状态
     * @param orderNo 订单编号
     */
    @Override
    public void updateRefundAliStatus(String orderNo) {
        LambdaUpdateWrapper<RefundInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(RefundInfo::getRefundStatus, OrderStatus.REFUND_SUCCESS.getType());
        lambdaUpdateWrapper.eq(RefundInfo::getOrderNo, orderNo);
        baseMapper.update(null, lambdaUpdateWrapper);
    }
}

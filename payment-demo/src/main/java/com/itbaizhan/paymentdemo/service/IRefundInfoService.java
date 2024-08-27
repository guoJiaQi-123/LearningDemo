package com.itbaizhan.paymentdemo.service;

import com.itbaizhan.paymentdemo.entity.RefundInfo;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 退款业务层
 */
public interface IRefundInfoService extends IService<RefundInfo> {

    /**
     * 根据订单编号创建退款单
     * @param orderNo 订单编号
     * @param reason 退款原因
     * @return 创建的退款单
     */
    RefundInfo createRefundInfoByOrderNo(String orderNo, String reason);

    /**
     * 更新退款单数据
     * @param bodyString 微信后台的响应数据
     */
    void updateRefund(String bodyString);


    /**
     * 修改退款单状态
     * @param bodyString 微信后台的通知回调参数
     */
    void updateRefundStatus(String bodyString);


    /**
     * 修改退款单状态
     * @param orderNo 订单编号
     */
    void updateRefundAliStatus(String orderNo);
}

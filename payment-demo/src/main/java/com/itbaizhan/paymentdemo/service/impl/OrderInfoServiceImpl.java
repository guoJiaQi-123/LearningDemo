package com.itbaizhan.paymentdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.itbaizhan.paymentdemo.controller.dto.OrderInfoDTO;
import com.itbaizhan.paymentdemo.entity.OrderInfo;
import com.itbaizhan.paymentdemo.enums.OrderStatus;
import com.itbaizhan.paymentdemo.mapper.OrderInfoMapper;
import com.itbaizhan.paymentdemo.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.stereotype.Service;
import sun.security.jca.GetInstance;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 订单业务层
 */
@Service
@Slf4j
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    /**
     * 创建订单
     * @param orderInfoDTO 订单传输对象 [ 属性一：订单标题  属性二：订单金额 ]
     * @return 订单
     */
    @Override
    public OrderInfo createOrder(OrderInfoDTO orderInfoDTO) {
        log.info("log:****************** 创建订单 ******************");
        OrderInfo orderInfo = new OrderInfo();
        // 订单标题
        orderInfo.setTitle(orderInfoDTO.getTitle());
        // 订单编号 时间戳
        orderInfo.setOrderNo(String.valueOf(new Date().getTime()));
        // 用户ID
        orderInfo.setUserId(123456L);
        // 订单金额
        orderInfo.setTotalFee(orderInfoDTO.getTotalFee());
        // 订单状态
        orderInfo.setOrderStatus(OrderStatus.NOTPAY.getType());
        // 订单创建时间
        orderInfo.setCreateTime(LocalDateTime.now());
        //  使用 mybatis 的方式向数据库插入订单数据
        int insert = baseMapper.insert(orderInfo);
        if (insert > 0) {
            log.info("log:订单创建成功");
        } else {
            log.error("log:订单创建失败");
        }
        return orderInfo;
    }

    /**
     * 根据商户的订单编号查询订单
     * @param orderNo 商户订单编号
     * @return 订单
     */
    @Override
    public OrderInfo findByOrderNo(String orderNo) {
        // 构建查询条件
        LambdaQueryWrapper<OrderInfo> lambdaQueryWrapper = new LambdaQueryWrapper<OrderInfo>().eq(OrderInfo::getOrderNo, orderNo);
        List<OrderInfo> orderInfos = baseMapper.selectList(lambdaQueryWrapper);
        if (orderInfos != null && !orderInfos.isEmpty()) {
            return orderInfos.get(0);
        }
        return null;
    }

    /**
     * 更新订单的 CodeUrl 字段
     * @param id 订单ID
     * @param codeUrl 二维码链接
     */
    @Override
    public void saveCodeUrl(Long id, String codeUrl) {
        UpdateWrapper<OrderInfo> updateWrapper = new UpdateWrapper<>();
        // 要更新的字段
        updateWrapper.set("code_url", codeUrl);
        // 更新的记录条件
        updateWrapper.eq("id", id);
        baseMapper.update(null, updateWrapper);
    }


    /**
     * 更新订单状态
     * @param id 订单ID
     * @param orderStatus 订单状态
     */
    @Override
    public void updateOrderStatus(Long id, OrderStatus orderStatus) {
        LambdaUpdateWrapper<OrderInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        // 要更新的字段
        lambdaUpdateWrapper.set(OrderInfo::getOrderStatus, orderStatus.getType());
        // 更新的记录条件
        lambdaUpdateWrapper.eq(OrderInfo::getId, id);
        baseMapper.update(null, lambdaUpdateWrapper);
    }

    @Override
    public void updateOrderStatus(String orderNo, OrderStatus orderStatus) {
        LambdaUpdateWrapper<OrderInfo> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        // 要更新的字段
        lambdaUpdateWrapper.set(OrderInfo::getOrderStatus, orderStatus.getType());
        // 更新的记录条件
        lambdaUpdateWrapper.eq(OrderInfo::getOrderNo, orderNo);
        baseMapper.update(null, lambdaUpdateWrapper);
    }

    /**
     * 查询超时订单
     * @param minutes 分钟
     * @return 超时的订单集合
     */
    @Override
    public List<OrderInfo> findTimeOutOrders(int minutes) {
        // 构造超时时间
        Instant instant = Instant.now().minus(Duration.ofMinutes(minutes));
        // 构造查询条件
        LambdaQueryWrapper<OrderInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OrderInfo::getOrderStatus, OrderStatus.NOTPAY.getType());
        lambdaQueryWrapper.le(OrderInfo::getCreateTime, instant);
        return baseMapper.selectList(lambdaQueryWrapper);
    }
}

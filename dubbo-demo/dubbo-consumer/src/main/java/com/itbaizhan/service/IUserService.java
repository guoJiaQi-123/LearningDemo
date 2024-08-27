package com.itbaizhan.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itbaizhan.pojo.CommonResult;
import com.itbaizhan.pojo.Orders;

/**
 * 用户接口
 */
public interface IUserService {


    //根据用户id查询订单详情
    CommonResult<Orders> findByUserId(long userId);
}

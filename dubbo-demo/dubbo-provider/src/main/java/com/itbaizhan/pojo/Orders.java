package com.itbaizhan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {


    // 订单id
    private Long id;
    // 用户id
    private Long userId;
    // 订单总价格
    private Double price;
    // 收货人手机号
    private String mobile;
    // 收货人地址
    private String address;
    // 支付类型 1:微信 2:支付宝
    private Integer pay_method;


}
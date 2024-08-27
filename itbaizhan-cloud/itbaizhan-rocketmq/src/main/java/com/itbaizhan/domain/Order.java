package com.itbaizhan.domain;

import java.io.Serializable;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote 订单实体类
 */
public class Order implements Serializable {

    // 订单id
    private Long orderId;

    // 订单状态
    private String orderStatus;

    public Order() {
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        final Order other = (Order) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$orderId = this.getOrderId();
        final Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
        final Object this$orderStatus = this.getOrderStatus();
        final Object other$orderStatus = other.getOrderStatus();
        if (this$orderStatus == null ? other$orderStatus != null : !this$orderStatus.equals(other$orderStatus))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        final Object $orderStatus = this.getOrderStatus();
        result = result * PRIME + ($orderStatus == null ? 43 : $orderStatus.hashCode());
        return result;
    }

    public String toString() {
        return "Order(orderId=" + this.getOrderId() + ", orderStatus=" + this.getOrderStatus() + ")";
    }
}

package com.tyut.pattern._03_behavior_model.e03order;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 测试类 - 客户端
 */
public class Client {
    public static void main(String[] args) {
        // 创建订单
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("爆炒河粉",2);
        order1.setFood("可乐",2);
        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("肉丝",2);
        order2.setFood("雪碧",2);

        //创建厨师
        SeniorChef seniorChef = new SeniorChef();

        // 创建命令
        Commend commend = new OrderCommend(seniorChef,order1);
        Commend commend2 = new OrderCommend(seniorChef,order2);

        // 创建服务员
        Waiter waiter = new Waiter();
        waiter.setCommends(commend);
        waiter.setCommends(commend2);
        waiter.orderUp();
    }
}

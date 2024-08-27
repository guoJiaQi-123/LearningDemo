package com.tyut.pattern._03_behavior_model.e03order;

import java.util.Map;
import java.util.Set;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 订单命令
 */
public class OrderCommend implements Commend {

    // 持有接受者对象
    private final SeniorChef seniorChef;
    // 订单
    private final Order order;

    public OrderCommend(SeniorChef seniorChef, Order order) {
        this.seniorChef = seniorChef;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单");
        Map<String, Integer> foodDic = order.getFoodDic();
        Set<String> foodNames = foodDic.keySet();
        for (String foodName : foodNames) {
            seniorChef.createFood(foodDic.get(foodName), foodName);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(order.getDiningTable() + "桌的饭弄好了");
    }

}

package com.tyut.pattern._03_behavior_model.e03order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 订单类
 */
public class Order {

    // 餐桌号
    private int diningTable;

    // 用来存储餐名并记录份数
    private final Map<String, Integer> foodDic = new HashMap<String, Integer>();


    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFoodDic() {
        return foodDic;
    }

    public void setFood(String food, int num) {
        foodDic.put(food, num);
    }
}

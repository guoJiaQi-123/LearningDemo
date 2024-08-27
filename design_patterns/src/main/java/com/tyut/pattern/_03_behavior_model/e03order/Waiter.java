package com.tyut.pattern._03_behavior_model.e03order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 服务员对象 - 命令的请求者
 */
public class Waiter {

    private final List<Commend> commends = new ArrayList<>();

    public void setCommends(Commend commend) {
        commends.add(commend);
    }

    public void orderUp() {
        System.out.println("订单来了！");
        for (Commend commend : commends) {
            commend.execute();
        }
    }

}

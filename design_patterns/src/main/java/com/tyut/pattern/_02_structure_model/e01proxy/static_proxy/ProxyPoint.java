package com.tyut.pattern._02_structure_model.e01proxy.static_proxy;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 代理类 - 代理卖票点
 */
public class ProxyPoint implements SellTicket{

    private final TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("收取一点代理服务费");
        trainStation.sell();
    }
}

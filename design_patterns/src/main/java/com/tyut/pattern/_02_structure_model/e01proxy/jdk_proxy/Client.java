package com.tyut.pattern._02_structure_model.e01proxy.jdk_proxy;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 客户端 - 测试类
 */
public class Client {
    public static void main(String[] args) {
        TrainStation station = new TrainStation();
        ProxyFactory proxyFactory = new ProxyFactory(station);
        SellTicket proxy = proxyFactory.getProxy();
        proxy.sell();
    }
}

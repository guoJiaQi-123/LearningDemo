package com.tyut.pattern._02_structure_model.e01proxy.cglib_proxy;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 客户端  - 测试类
 */
public class Client {
    public static void main(String[] args) {
        TrainStation station = new TrainStation();
        //创建代理工厂对象
        ProxyFactory factory = new ProxyFactory(station);
        //获取代理对象
        TrainStation proxyObject = (TrainStation) factory.getProxy();

        proxyObject.sell();
    }
}
package com.itbiazhan.zk.ZKClient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * ZKClient库操作zookeeper
 */
public class ZKClientMain {
    public static void main(String[] args) throws InterruptedException {
        //建立会话，连接zookeeper服务
        ZkClient zk = new ZkClient("192.168.66.150:2181");

        //创建节点
//        zk.create("/node1","郭家旗", CreateMode.PERSISTENT);

        //修改节点
//        zk.writeData("/node1","2");

        //查询节点数据
//        String node1 = zk.readData("/node1");
//        System.out.println(node1);

        //查询节点结构
//        List<String> children = zk.getChildren("/node1");
//        children.forEach(System.out::println);

        //删除节点
//        zk.delete("/node1");

        //使用ZKClient实现监听机制
        //  1. 监听节点结构
//        zk.subscribeChildChanges("/node1", new IZkChildListener() {
//            @Override
//            public void handleChildChange(String s, List<String> list) throws Exception {
//                System.out.println("节点结构被修改了");
//                System.out.println("修改后的结构为：");
//                list.forEach(System.out::println);
//            }
//        });

        //  2.监听节点数据变化
        zk.subscribeDataChanges("/node2", new IZkDataListener() {
            //节点数据发送变化回调函数
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("数据发送变化"+s +"变为"+o.toString());
            }
            //节点数据被删除回调函数
            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("数据被删除"+s);
            }
        });

        Thread.sleep(Long.MAX_VALUE);
    }
}

package com.itbiazhan.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * 使用curator作为zookeeper的客户端
 */
public class CuratorMain {
    public static void main(String[] args) throws Exception {

        // 建立会话
        CuratorFramework cur = CuratorFrameworkFactory
                .builder()
                .connectString("192.168.66.150:2181")//连接地址
                .connectionTimeoutMs(5000)//连接超时时间
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        //连接
        cur.start();

        //创建节点
//        cur.create()
//                .withMode(CreateMode.PERSISTENT)
//                .forPath("/node3","guojiaqi".getBytes());

        //修改节点
//        cur.setData()
//                .forPath("/node3","suhongrun".getBytes());

        //获取节点数据
//        byte[] bytes = cur.getData()
//                .forPath("/node3");
//        System.out.println(new String(bytes));

        //获取某个节点的所有子节点路径
//        List<String> list = cur.getChildren().forPath("/node1");
//        list.forEach(System.out::println);

        cur.delete()
                .deletingChildrenIfNeeded()
                .forPath("/node1");
    }
}

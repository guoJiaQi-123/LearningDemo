package com.itbiazhan.zk.OldAPI;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * 原生api 实现zookeeper监听机制
 */
@SuppressWarnings("all")
public class ZKWatcher {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.66.150:2181", 5000, new Watcher() {
            /**
             * 监听机制的回调函数
             * @param watchedEvent
             */
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("正在监听........");
            }
        });

       /*
        //监听节点结构的变化getChildren
        List<String> children = zooKeeper.getChildren("/node1", new Watcher() {
            //回调函数
            @Override
            public void process(WatchedEvent event) {
                System.out.println("监听路径为：" + event.getPath());
                System.out.println("监听的类型为：" + event.getType());
                System.out.println("数据被2货修改了！！！");

            }
        });
        Thread.sleep(Long.MAX_VALUE);
        */

        //监听节点数据的变化getData
        byte[] data = zooKeeper.getData("/node1", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("监听路径为：" + event.getPath());
                System.out.println("监听的类型为：" + event.getType());
                System.out.println("数据被2货修改了！！！");
            }
        }, null);
        System.out.println(new String(data));
        Thread.sleep(Long.MAX_VALUE);
    }
}

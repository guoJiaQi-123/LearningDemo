package com.itbiazhan.zk.OldAPI;

import org.apache.log4j.chainsaw.Main;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("all")
public class ZKMain {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        //与zookeeper服务端建立连接
        /**
         * 创建一个 Zookeeper 的实例
         * 此处为一个集群，Zookeeper 的 ip 之间用逗号隔开
         *
         * 参数解释：
         * param 1 - Zookeeper 的实例 ip ，此处是一个集群，所以配置了多个 ip，用逗号隔开
         * param 2 - session 过期时间，单位秒 (1000)
         * param 3 - 监视者，用于获取监听事件 (MyWatch)
         */
        ZooKeeper zooKeeper = new ZooKeeper("192.168.66.150:2181", 5000, null);

        /**
         * 创建节点
         * 参数一：节点路径名称
         * 参数二：节点中存放的数据
         * 参数三：节点的ACL权限策略
         * 参数四：节点的类型：  持久节点（PERSISTENT）   临时节点（EPHEMERAL）   持久顺序（SEQUENTIAL）节点      临时顺序节点
         */
        //zooKeeper.create("/node1", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


        /**
         * 删除节点
         * 参数一：节点路径名称
         * 参数二：节点版本，-1代表全部版本
         */
        //zooKeeper.delete("/node1",-1);

        /**
         * 修改节点
         * 参数一：节点路径名称
         * 参数二：要修改的节点数据
         * 参数三：修改的节点版本，-1代表全部版本
         */
        //zooKeeper.setData("/node1", "2".getBytes(), -1);

        /**
         * 查询节点中的数据
         * 参数一：节点路径名称
         * 参数二：监听机制
         * 参数三：Zookeeper 实例信息和数据信息 (stat)
         */
        // getData的返回值是该节点的数据值，节点的状态信息会赋值给stat对象
//        Stat stat = new Stat();
//        byte[] data = zooKeeper.getData("/node1", false, stat);
//        System.out.println(new String(data));
//        System.out.println(stat);

        /**
         * 查询节点的子节点
         */
        List<String> children = zooKeeper.getChildren("/node1", false);
        for (String child : children) {
            System.out.println(child);
        }

        /**
         * 检查节点是否存在
         */
        Stat stat = zooKeeper.exists("/node1", false);
        System.out.println(stat);
    }
}

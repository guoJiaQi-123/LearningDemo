package com.tyut.pattern._03_behavior_model.e04responsibility;

/**
 * @author OldGj 2024/03/11
 * @version v1.0
 * @apiNote 客户端 - 测试类
 */
public class Client {
    public static void main(String[] args) {
        leaveRequest request = new leaveRequest("张三", 3, "生病");

        Manager manager = new Manager();
        GroupLeader groupLeader = new GroupLeader();
        GeneralManager generalManager = new GeneralManager();
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        groupLeader.submit(request);
    }
}

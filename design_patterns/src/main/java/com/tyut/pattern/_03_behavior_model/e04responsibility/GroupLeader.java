package com.tyut.pattern._03_behavior_model.e04responsibility;

/**
 * @author OldGj 2024/03/11
 * @version v1.0
 * @apiNote 小组长类 - 可处理0-1天的请假请求
 */
public class GroupLeader extends Handler {

    public GroupLeader() {
        super(0, Handler.NUM_ONE);
    }

    @Override
    protected void process(leaveRequest leave) {
        if (leave.getNum() >= this.start && leave.getNum() <= this.end) {
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天，原因是：" + leave.getReason());
            System.out.println("小组长审批同意");
        }
    }

}

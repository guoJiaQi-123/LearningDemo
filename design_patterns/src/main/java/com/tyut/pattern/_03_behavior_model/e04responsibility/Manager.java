package com.tyut.pattern._03_behavior_model.e04responsibility;

/**
 * @author OldGj 2024/03/11
 * @version v1.0
 * @apiNote 部门经理类 - 可处理1-3天的请假请求
 */
public class Manager extends Handler {

    public Manager() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void process(leaveRequest leave) {
        if (leave.getNum() > this.start && leave.getNum() <= this.end) {
            System.out.println(leave.getName() + "请假" + leave.getNum() + "天，原因是：" + leave.getReason());
            System.out.println("部门经理审批同意");
        }
    }
}

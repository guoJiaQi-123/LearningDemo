package com.tyut.pattern._03_behavior_model.e04responsibility;

/**
 * @author OldGj 2024/03/11
 * @version v1.0
 * @apiNote 总经理类 - 可处理3-7天的请假请求
 */
public class GeneralManager extends Handler {


    public GeneralManager(){
        super(Handler.NUM_THREE,Handler.NUM_SEVEN);
    }

    @Override
    protected void process(leaveRequest leave) {
        if (leave.getNum() > this.start && leave.getNum() <= this.end) {
        System.out.println(leave.getName()+"请假"+leave.getNum()+"天，原因是："+leave.getReason());
        System.out.println("总经理审批同意");}
    }
}

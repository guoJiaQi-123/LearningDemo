package com.tyut.pattern._03_behavior_model.e04responsibility;

/**
 * @author OldGj 2024/03/11
 * @version v1.0
 * @apiNote 抽象处理者
 */
public abstract class Handler {

    protected static final int NUM_ONE = 1;
    protected static final int NUM_THREE = 3;
    protected static final int NUM_SEVEN = 7;
    protected Handler nextHandler;
    protected int start;
    protected int end;

    public Handler(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 处理请求
    protected abstract void process(leaveRequest leave);

    // 向上提交请求
    public void submit(leaveRequest leave) {

            this.process(leave);

            //如果还有上级 并且请假天数超过了当前领导的处理范围
            if (null != this.nextHandler && leave.getNum() > end) {
                this.nextHandler.submit(leave);//继续提交
            } else {
                System.out.println("流程结束");
            }

    }
}

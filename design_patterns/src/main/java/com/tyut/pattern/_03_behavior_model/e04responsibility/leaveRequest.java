package com.tyut.pattern._03_behavior_model.e04responsibility;

/**
 * @author OldGj 2024/03/11
 * @version v1.0
 * @apiNote 请假条
 */
public class leaveRequest {
    // 请假人
    private String name;
    // 请假天数
    private int num;
    // 请假理由
    private String reason;

    public leaveRequest(String name, int num, String reason) {
        this.name = name;
        this.num = num;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getReason() {
        return reason;
    }
}

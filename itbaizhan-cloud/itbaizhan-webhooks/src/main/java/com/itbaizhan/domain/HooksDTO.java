package com.itbaizhan.domain;

import lombok.Data;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/6
 * @apiNote 网络钩子数据传输对象
 */
@Data
public class HooksDTO {

    private int scopeId;
    private String scope;
    private String name;
    private String id0;
    private String id1;
    private String ruleName;
    private String alarmMessage;
    private List<Tag> tags;
    private long startTime;
    private transient int period;
    private transient boolean onlyAsCondition;

    @Data
    public static class Tag{
        private String key;
        private String value;
    }
}

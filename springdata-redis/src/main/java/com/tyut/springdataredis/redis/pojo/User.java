package com.tyut.springdataredis.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 * @author OldGj 2025/3/14
 * @apiNote TODO(一句话给出该类描述)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private int age;
}

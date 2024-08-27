package com.itbaizhan.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @version v1.0
 * @author OldGj 2024/5/5
 * @apiNote 实体类
 */
@Data
@TableName("user")
public class User {

    private Long id;
    private String name;
    private Integer age;

}

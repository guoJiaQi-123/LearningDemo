package com.itbaizhan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @version v1.0
 * @author OldGj 2024/04/24
 * @apiNote user实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "user")
public class User implements Serializable {
    // ID
    @TableId(type = IdType.AUTO)
    private Long id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;

}

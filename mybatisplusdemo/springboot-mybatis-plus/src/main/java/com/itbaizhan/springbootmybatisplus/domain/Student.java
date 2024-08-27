package com.itbaizhan.springbootmybatisplus.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName(value = "tb_student")
public class Student extends Model<Student> {
    @TableId(value = "sid")
    private Integer id;
    @TableField(value = "sname")
    private String name;
    private String email;
    private String gender;
    private Integer age;
    @Version
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)//插入操作时自动填充该字段
    private Integer deleted;

    public Student(Integer id, String name, String email, String gender, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }
}

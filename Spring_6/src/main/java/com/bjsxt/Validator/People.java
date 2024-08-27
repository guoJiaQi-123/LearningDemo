package com.bjsxt.Validator;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class People {

    @NotBlank(message = "名字不能为空")
    private String name;

    @Range(min = 1,max = 150)
    private int age;
}

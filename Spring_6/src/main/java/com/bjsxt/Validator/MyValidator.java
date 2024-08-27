package com.bjsxt.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        if(clazz.equals(People.class)){
            return true;
        }

        return false;
    }
    // 具体校验规则

    @Override
    public void validate(Object target, Errors errors) {
        //name名字：不能为空
        //age年龄： age>1  且  age<150

        // 简单判断是否为空可以使用工具类。其他的校验规则需要自己定义
        // rejectIfEmpty(Errors对象,“校验的属性”,"错误码，可以设置为null"，“校验不通过时日志打印的消息”):为空校验不通过
        ValidationUtils.rejectIfEmpty(errors,"name",null,"名字不能为空");

        Object ageValue = errors.getFieldValue("age");// 获取age属性的值
        if(ageValue!=null){

            Integer age = Integer.parseInt(ageValue.toString());
            if(age<1||age>150){
                // rejectValue("校验的属性"，“错误码”,"校验不通过时日志打印的消息")：表示属性校验不通过
                errors.reject("age",null,"年龄必须在1-150之间");
            }


        }

    }
}

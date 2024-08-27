package com.bjsxt;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import com.bjsxt.Validator.*;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class testValidator {

    @Test
    void test(){

        //1.数据绑定，给某个对象进行绑定
        Map<String,Object> map = new HashMap<>();
        map.put("name","");
        map.put("age",20);
        PropertyValues propertyValues = new MutablePropertyValues(map);



        People people = new People();
        DataBinder dataBinder = new DataBinder(people);
        dataBinder.bind(propertyValues);
        //2.设置校验器
        dataBinder.setValidator(new MyValidator());
        //3.开始校验
        dataBinder.validate();
        //4.获取校验结果
        BindingResult bindingResult = dataBinder.getBindingResult();
        //5.查看绑定结果中是否有错误信息
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        allErrors.forEach(System.out::println);
    }

    @Test
    void testHibernateValidator(){
        //1.创建校验工厂
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        //2.获取校验器
        Validator validator = validatorFactory.getValidator();
        //3.开始校验并获取校验结果
        People people=new People();
        Set<ConstraintViolation<People>> validate = validator.validate(people);
        for (ConstraintViolation<People> vc :validate){
            System.out.println(vc.getMessage());
        }
    }
}

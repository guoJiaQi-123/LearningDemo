package com.bjsxt;

import com.bjsxt.Validator.People;
import com.bjsxt.Validator.ValidatorConfig;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import java.util.Set;

@SpringJUnitConfig
@ContextConfiguration(classes = ValidatorConfig.class)
public class SpringValidatorTest {

    @Autowired
    Validator validator;

    @Test
    void test(){
        People people = new People();
        Set<ConstraintViolation<People>> validate = validator.validate(people);
        validate.forEach(a->{
            System.out.println(a.getMessage());
        });
    }

}

package com.itbaizhan.util;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 测试类中的方法是可以独立运行的
     * 1.测试类中的方法名一般命名为 test+被测试方法名
     * 2.测试类方法名上方加 @Test 注解
     * 3.测试类方法无参数，无返回值
     */
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int add = calculator.add(1, 2);
        Assert.assertEquals(3,add);
    }

    @Test
    public void testDiv(){
        Calculator calculator=new Calculator();
        int div = calculator.div(2, 1);
        System.out.println(div);
    }


}

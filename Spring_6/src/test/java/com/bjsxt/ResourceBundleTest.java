package com.bjsxt;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {


    @Test
    void test(){
        ResourceBundle rb = ResourceBundle.getBundle("rb", Locale.CHINA);
        System.out.println(rb.getString("name"));
        System.out.println(rb.getString("age"));
        System.out.println(rb.getString("address"));

        String format = MessageFormat.format(rb.getString("address"), "晋中");
        System.out.println(format);
    }
}

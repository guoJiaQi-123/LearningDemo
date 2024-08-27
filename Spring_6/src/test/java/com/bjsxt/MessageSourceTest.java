package com.bjsxt;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Locale;

@SpringJUnitConfig
@ContextConfiguration("classpath:applicationContext-i18n.xml")
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    @Test
    void test(){
        String address = messageSource.getMessage("address", new String[]{"晋中"}, Locale.CHINA);
        System.out.println(address);
    }
}

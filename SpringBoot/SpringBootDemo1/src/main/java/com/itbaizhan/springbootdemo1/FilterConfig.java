package com.itbaizhan.springbootdemo1;

import com.itbaizhan.springbootdemo1.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        //注册Filter组件
        FilterRegistrationBean<SecondFilter> filterRegistrationBean = new FilterRegistrationBean<>(new SecondFilter());
        //添加过滤路径
        filterRegistrationBean.addUrlPatterns("/second");
        return filterRegistrationBean;
    }
}

package com.itbaizhan.springbootdemo1;

import com.itbaizhan.springbootdemo1.servlet.SecondServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    //ServletRegistrationBean可以注册Servlet组件，将其放入Spring容器中即可注册Servlet
    public ServletRegistrationBean getServletRegistrationBean(){
        // 注册Servlet组件
        ServletRegistrationBean<SecondServlet> servletBean = new ServletRegistrationBean<>(new SecondServlet());
        // 添加Servlet组件访问路径
        servletBean.addUrlMappings("/second");
        return servletBean;
    }
}

package com.itbaizhan.mysecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class RemanberMeConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository getPersistentTokenRepository(){
        //为spring security 自带的令牌设置数据源
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);

        //配置第一次启动项目自动建立表（用于存放令牌数据，下次登录时与客户端cookie比对），第二次启动需要注释掉
//        jdbcTokenRepository.setCreateTableOnStartup(true);

        return jdbcTokenRepository;

    }
}

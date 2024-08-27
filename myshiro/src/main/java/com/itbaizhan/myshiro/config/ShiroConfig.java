package com.itbaizhan.myshiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.itbaizhan.myshiro.listener.MySessionListener;
import com.itbaizhan.myshiro.realm.MyRealm;
import com.itbaizhan.myshiro.realm.MyRealm2;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //realm管理器
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator() {
        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        //设置认证策略
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }


    @Bean
    public DefaultWebSecurityManager securityManager(MyRealm myRealm,
                                                     MyRealm2 myRealm2,
                                                     SessionManager sessionManager,
                                                     CookieRememberMeManager rememberMeManager,
                                                     EhCacheManager ehCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注册Realm管理器（需要在设置Realm之前）
        securityManager.setAuthenticator(modularRealmAuthenticator());

        //securityManager.setRealm(myRealm);
        List<Realm> realms = new ArrayList<>();
        realms.add(myRealm);
        realms.add(myRealm2);
        securityManager.setRealms(realms);//配置多realm

        securityManager.setSessionManager(sessionManager);//注册会话管理器对象

        securityManager.setRememberMeManager(rememberMeManager);//注册记住我管理器

        securityManager.setCacheManager(ehCacheManager);//配置缓存管理器
        return securityManager;
    }

    //配置加密算法
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置采用哪种加密方式
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //设置加密次数
        hashedCredentialsMatcher.setHashIterations(5);
        return hashedCredentialsMatcher;
    }


    // 自定义Realm
    @Bean
    public MyRealm myRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        MyRealm myRealm = new MyRealm();
        //设置加密算法
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return myRealm;
    }

    // 自定义Realm2（admin）
    @Bean
    public MyRealm2 myRealm2() {
        return new MyRealm2();
    }


    // 配置过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        // 1.创建过滤器工厂
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
        // 2.过滤器工厂设置SecurityManager
        filterFactory.setSecurityManager(securityManager);
        // 3.设置shiro的拦截规则
        Map<String, String> filterMap = new HashMap<>();
        // 不拦截的资源
        filterMap.put("/login.html", "anon");
        filterMap.put("/fail.html", "anon");
        filterMap.put("/user/login2", "anon");
        filterMap.put("/css/**", "anon");

        //配置鉴权过滤器（在/**之前配置）       key:访问的资源           value:需要拥有的权限
        filterMap.put("/reportform/find","perms[/reportform/find]");
        filterMap.put("/salary/find","perms[/salary/find]");
        filterMap.put("/stuff/find","perms[/stuff/find]");


        // 其余资源都需要用户认证   user 认证和记住我可以访问
        filterMap.put("/**", "user");
        // authc   必须认证才能访问
        filterMap.put("/user/pay","authc");
        // 4.将拦截规则设置给过滤器工厂
        filterFactory.setFilterChainDefinitionMap(filterMap);
        // 5.登录页面
        filterFactory.setLoginUrl("/login.html");
        //6.配置权限不足的页面
        filterFactory.setUnauthorizedUrl("/noPermission.html");
        return filterFactory;
    }

    //配置会话管理器
    @Bean
//    @SuppressWarnings("all")
    public SessionManager sessionManager(MySessionListener sessionListener) {
        //创建一个会话管理器
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //创建监听器集合
        List<SessionListener> sessionListeners = new ArrayList<>();
        sessionListeners.add(sessionListener);
        //将监听器集合添加到会话管理器中
        sessionManager.setSessionListeners(sessionListeners);

        // 全局会话超时时间（单位毫秒），默认30分钟,设置为5秒
//        sessionManager.setGlobalSessionTimeout(5*1000);
        // 是否开启删除无效的session对象，默认为true
        sessionManager.setDeleteInvalidSessions(true);
        // 是否开启定时调度器进行检测过期session，默认为true
        sessionManager.setSessionValidationSchedulerEnabled(true);
        return sessionManager;
    }


    //cookie管理器
    @Bean
    public SimpleCookie simpleCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // Cookie有效时间，单位：秒
        simpleCookie.setMaxAge(20);
        return simpleCookie;
    }

    //记住我管理器
    @Bean
    public CookieRememberMeManager cookieRememberMeManager(SimpleCookie simpleCookie){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        //设置cookie管理器
        rememberMeManager.setCookie(simpleCookie);
        //设置cookie秘钥
        rememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j3Y+R1aSn5BOlAA=="));
        return rememberMeManager;
    }


    // 开启shiro注解的支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    // 开启aop注解支持
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    // 创建CacheManager
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
        return ehCacheManager;
    }

//    @Bean
//    public JdbcRealm jdbcRealm(DataSource dataSource){
//        JdbcRealm jdbcRealm = new JdbcRealm();
//        jdbcRealm.setDataSource(dataSource);
//        return jdbcRealm;
//    }

}
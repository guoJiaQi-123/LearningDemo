package com.itbaizhan.mysecurity.config;

import com.itbaizhan.mysecurity.handler.MyAccessDeniedHandler;
import com.itbaizhan.mysecurity.handler.MyLoginFailHandler;
import com.itbaizhan.mysecurity.handler.MyLoginSuccessHandler;
import com.itbaizhan.mysecurity.handler.MyLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@SuppressWarnings("all")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PersistentTokenRepository repository;
//    // 定义认证逻辑
//    @Bean
//    public UserDetailsService userDetailsService(){
//        // 1.使用内存数据进行认证
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        // 2.创建两个用户
//        UserDetails user1 = User.withUsername("guojiaqi").password("5946").authorities("admin").build();
//        UserDetails user2 = User.withUsername("suhongrun").password("6541").authorities("admin").build();
//
//        // 3.将这两个用户添加到内存中
//        manager.createUser(user1);
//        manager.createUser(user2);
//
//        return manager;
//    }

    /*//密码编码器，不解析密码
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    */

    //Spring Security配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义表单登录
        //配置自定义登录页面
        http.formLogin()
                .loginProcessingUrl("/login")   //登录路径，表单向该路径提交，提交后自动执行
                .loginPage("/login.html")       //配置自定义的登录页面
                .usernameParameter("username")  //配置自定义表单中用户名属性
                .passwordParameter("password")  //配置自定义表单中的密码属性
//                .successForwardUrl("/main")     //配置认证成功后的跳转页面
                .successHandler(new MyLoginSuccessHandler())  //配置认证成功后的处理器（自定义的认证成功处理器）
//                .failureForwardUrl("/fail");    //配置认证失败后的跳转页面
                .failureHandler(new MyLoginFailHandler()); //配置认证失败后的处理器
//                                               （该处理器中需要重定向跳转到失败页面，因此需要将失败页面配置为不需要认证资源）

        //配置退出登录
        http.logout()
                .logoutUrl("/logout")           // 前端表单请求的退出登录路径
//                .logoutSuccessUrl("/login.html")//退出登录成功后跳转的页面
                .logoutSuccessHandler(new MyLogoutHandler()) //配置退出登录成功处理器
                .clearAuthentication(true)      //退出登录是否消除认证，默认为true
                .invalidateHttpSession(true);   //退出登录是否消除会话状态，默认为true


        // 配置需要认证的资源（权限拦截器）
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll() //登录页不需要认证
                .antMatchers("/fail").permitAll()       //登录失败页面不需要认证
//                .antMatchers("/reportform/find").hasAnyAuthority("/reportform/find")//当有/reportform/find权限时才能访问该资源
//                .antMatchers("/salary/find").hasAnyAuthority("/salary/find")
//                .antMatchers("/staff/find").hasAnyAuthority("/staff/find")
                .anyRequest().authenticated();            //其余所有请求都需要认证

//        // 配置需要认证的资源（权限拦截器）
//        http.authorizeRequests()
//                .antMatchers("/login.html").permitAll() //登录页不需要认证
//                .anyRequest().access("@myAuthorizationService.hasPermission(request,authentication)");//配置自定义的权限拦截器（只有用户拥有与访问资源同名的权限时，才能够访问该资源）


        //配置异常处理
        http.exceptionHandling()
                        .accessDeniedHandler(new MyAccessDeniedHandler());

        // 记住我配置
        http.rememberMe()
                .userDetailsService(userDetailsService)   //配置登录逻辑交给哪个对象
                .tokenRepository(repository)              //配置持久层对象
                .tokenValiditySeconds(20);                //保存时间，单位：秒


        //关闭csrf防护
        //http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");//忽略静态资源
    }

    /**
     * 配置密码解析器，BCryptPasswordEncoder加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

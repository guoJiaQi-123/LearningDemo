package com.itbaizhan.swaggerdemo.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerDemoApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itbaizhan.swaggerdemo.controller"))//设置扫描包
                .apis(not(withMethodAnnotation(NotIncludeSwagger.class)))//对方法上带有@NotIncludeSwagger注解的方法不生成API文档
                .paths(allowPaths())    // 设置运行生成API文档的接口路径
                .build();
    }

    private Predicate<String> allowPaths() {
        return or(regex("/people/.*"));//只有以people为URL开头的接口才生成API文档
    }

    private ApiInfo swaggerDemoApiInfo(){
        return new ApiInfoBuilder()
                .contact(new Contact("OldGj_","https://blog.csdn.net/guojiaqi_","guojiaqi5946@Outlook.com"))
                //文档标题
                .title("郭家旗的API文档")
                //文档描述
                .description("学习Swagger")
                //文档版本
                .version("1.0.0")
                .build();
    }
}
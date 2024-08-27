package com.itbaizhan.paymentdemo.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Arrays;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote mybatis-plus 代码生成器工具类
 */
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/payment", "root", "root")
                .globalConfig(builder -> {
                    builder.author("itbaizhan") // 设置作者
                            .commentDate("MM-dd") // 注释日期格式 C:\Users\wangc\IdeaProjects\payment-demo2\src\main\java
                            .outputDir(System.getProperty("user.dir")+ "/src/main/java/") // 指定输出目录
                            .fileOverride(); //覆盖文件
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.itbaizhan.paymentdemo") // 包名前缀
                            .entity("entity") //实体类包名
                            .mapper("mapper") //mapper接口包名
                            .service("service"); //service包名
                })

                .strategyConfig(builder -> {
                    List<String> list = Arrays.asList("order_info", "refund_info", "payment_info");
                    // 设置需要生成的表名
                    builder.addInclude(list)
                            // 开始实体类配置
                            .entityBuilder()
                            // 开启lombok模型
                            .enableLombok()
                            //表名下划线转驼峰
                            .naming(NamingStrategy.underline_to_camel)
                            //列名下划线转驼峰
                            .columnNaming(NamingStrategy.underline_to_camel);
                })
                .execute();
    }
}

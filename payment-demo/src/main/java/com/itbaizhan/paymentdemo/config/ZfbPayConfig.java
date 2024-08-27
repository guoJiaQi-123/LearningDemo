package com.itbaizhan.paymentdemo.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @version v1.0
 * @author OldGj 2024/04/20
 * @apiNote 支付宝支付配置文件
 */
@Data
@PropertySource("classpath:zfbpay.properties")
@Configuration
@ConfigurationProperties(prefix = "alipay")
public class ZfbPayConfig {

    /**
     * 应用id
     */
    private String appId;

    /**
     * 应用私钥
     */
    private String privateKey;

    /**
     * 支付宝公钥
     */
    private String publicKey;

    /**
     * 支付宝网关
     */
    private String gateway;

    /**
     * 通知回调地址
     */
    private String notifyUrl;


    // 获取支付宝客户端
    @Bean
    public AlipayClient getAlipayClient() {
        // 网关 应用id 应用私钥 格式 编码方式 公钥 加密算法
        return new DefaultAlipayClient(gateway, appId, privateKey, "json", "UTF-8", publicKey, "RSA2");
    }

}

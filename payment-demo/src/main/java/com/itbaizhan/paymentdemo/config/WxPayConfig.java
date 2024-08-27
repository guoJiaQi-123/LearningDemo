package com.itbaizhan.paymentdemo.config;

import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

/**
 * @version v1.0
 * @author OldGj 2024/04/17
 * @apiNote 读取微信配置文件
 */
@Configuration
@PropertySource("classpath:wxpay.properties") //读取配置文件
@ConfigurationProperties(prefix = "wxpay") //读取 wxpay 节点
@Data //使用set方法将 wxpay节点中的值填充到当前类的属性中
@Slf4j
public class WxPayConfig {
    // 商户号
    private String mchId;

    // 商户API证书序列号
    private String mchSerialNo;

    // 商户私钥文件地址
    private String privateKeyPath;

    // APIv3密钥
    private String apiV3Key;

    // APPID
    private String appid;

    // 微信服务器地址
    private String domain;

    // 接收结果通知地址
    private String notifyDomain;


    /**
     * 获取商户的私钥文件
     */
    @Bean
    public PrivateKey getPrivateKey() {
        try {
            FileInputStream fileInputStream = new FileInputStream(privateKeyPath);
            return PemUtil.loadPrivateKey(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("私钥文件不存在", e);
        }
    }

    /**
     * 获取签名验证器
     */
    @Bean
    public AutoUpdateCertificatesVerifier getVerifier(PrivateKey privateKey) {
        log.info("获取签名验证器");

        //私钥签名对象
        PrivateKeySigner privateKeySigner = new PrivateKeySigner(mchSerialNo, privateKey);

        //身份认证对象
        WechatPay2Credentials wechatPay2Credentials = new WechatPay2Credentials(mchId, privateKeySigner);

        // 使用定时更新的签名验证器，不需要传入证书
        return new AutoUpdateCertificatesVerifier(
                wechatPay2Credentials,
                apiV3Key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 初始化httpClient
     */
    @Bean(name = "wxPayClient")
    public CloseableHttpClient getWxPayClient(PrivateKey privateKey, AutoUpdateCertificatesVerifier verifier) {
        log.info("获取httpClient");


        return WechatPayHttpClientBuilder.create()
                .withMerchant(mchId, mchSerialNo, privateKey)
                .withValidator(new WechatPay2Validator(verifier)).build();
    }
}

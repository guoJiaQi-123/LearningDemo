package com.tyut.springdataelasticsearch.config;

import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.boot.autoconfigure.elasticsearch.RestClientBuilderCustomizer;
import org.springframework.stereotype.Component;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


/**
 * 创建配置类，跳过SSL证书检查。
 */
@Component
public class RestClientBuilderCustomizerImpl implements RestClientBuilderCustomizer {
    @Override
    public void customize(RestClientBuilder builder) {
    }


    /**
   * 跳过SSL的证书检查
   */
    @Override
    public void customize(HttpAsyncClientBuilder builder) {
        SSLContextBuilder sscb = SSLContexts.custom();
        try {
            sscb.loadTrustMaterial((chain, authType) -> {
                return true;
            });
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        }


        try {
            builder.setSSLContext(sscb.build());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
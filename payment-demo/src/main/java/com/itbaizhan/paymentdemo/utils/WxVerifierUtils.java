package com.itbaizhan.paymentdemo.utils;

import com.mysql.jdbc.log.Log;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.util.AesUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @version v1.0
 * @author OldGj 2024/04/18
 * @apiNote 微信验证签名工具类
 */
@Slf4j
public class WxVerifierUtils {

    /**
     * 验签
     * @param request
     * @param verifier
     * @param body
     * @return
     */
    public static boolean verifier(HttpServletRequest request, Verifier verifier, String body) throws UnsupportedEncodingException {
        // 1. 应答随机串
        String nonce = request.getHeader("Wechatpay-Nonce");
        // 2. 获取微信传递过来签名
        String signature = request.getHeader("Wechatpay-Signature");
        // 3. 证书序列号
        String serial = request.getHeader("Wechatpay-Serial");
        // 4. 时间戳
        String timestamp = request.getHeader("Wechatpay-Timestamp");

        // 5. 构造签名串
        /*
         * 应答时间戳\n
         * 应答随机串\n
         * 应答报文主体\n
         */
        String signStr = Stream.of(timestamp, nonce, body).collect(Collectors.joining("\n", "", "\n"));
        return verifier.verify(serial, signStr.getBytes(StandardCharsets.UTF_8), signature);
    }


    /**
     * 对称解密
     * @param bodyMap 响应体数据
     * @return 明文
     */
    public static String decrypt(Map<String, Object> bodyMap, String apiv3) {
        // 通知数据
        Map<String, String> resourceMap = (Map<String, String>) bodyMap.get("resource");
        // 数据密文
        String ciphertext = resourceMap.get("ciphertext");
        log.info("密文 => {}", ciphertext);
        // 随机串
        String nonce = resourceMap.get("nonce");
        // 附加数据
        String associatedData = resourceMap.get("associated_data");
        // 构建 aes对象
        AesUtil aesUtil = new AesUtil(apiv3.getBytes(StandardCharsets.UTF_8));
        String plainText = null;
        try {
            // 解密
            plainText = aesUtil.decryptToString(associatedData.getBytes(StandardCharsets.UTF_8),
                    nonce.getBytes(StandardCharsets.UTF_8),
                    ciphertext);
            log.info("明文==>{}", plainText);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return plainText;


    }
}

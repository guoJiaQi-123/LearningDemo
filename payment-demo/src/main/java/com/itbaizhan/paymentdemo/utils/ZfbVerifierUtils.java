package com.itbaizhan.paymentdemo.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.itbaizhan.paymentdemo.config.ZfbPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/04/20
 * @apiNote 支付宝验签
 */
@Component
public class ZfbVerifierUtils {


    // 验签 - 查看回调方是否为支付宝
    public static boolean isVerifier(HttpServletRequest request, String publicKey) {
        Map<String, String> resultMap = new HashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Object v : parameterMap.entrySet()) {
            Map.Entry<String, String[]> item = (Map.Entry<String, String[]>) v;
            resultMap.put(item.getKey(), item.getValue()[0]);
        }
        try {
            return AlipaySignature.rsaCheckV1(resultMap, publicKey, "utf-8", "RSA2");
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.itbaizhan.util;

import org.jose4j.json.JsonUtil;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.lang.JoseException;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @version v1.0
 * @author OldGj 2024/4/28
 * @apiNote Jwt工具类
 */
public class JWTUtils {

    // 私钥
    private static final String privateJSON = "{\"kty\":\"RSA\",\"n\":\"ocV66NdFjdQfeC3xis4OTsg3t1GWO2iH5zRjPCc9D9jUDDrTjOn9yOrocWmtZ86_9wLrNI4kfi_bn0PRy-BBrmh0i7L75UFhkNk6_fLdv1psIvIDcoNxfjF4K5X2PsAGBA_o_Dc_S_ElrKC52oLA9-2eL2xDqOwJWkNB38s6MgmRGokaLZz25IPgxIkm-w6XirJXJ0qxmaydXilPVSGzUS77nVVC5AzWPNL6N665xTixcApqfFxZSXmV2f4r9K5Vyo0ej7jWLv71spYYPme2XNoFmblfbsptxi-mX4zeZ4-wpT2Ob6YsWu2mG0qE6GopsGiSu5evAKcma4rVKXI81Q\",\"e\":\"AQAB\",\"d\":\"GO1Xn5pQRub5RGj777IJpV0XrME_H39fdaJuah33vEHihtHnuC50IyoDUDqC9Fx42wSRnqMKf4E7W8K1CK_RHyFMWBxn0S8ubAX1H511St-Rix70pggYDGRuCnVMoOWw555V_cs7jyWk8wE_Mir0th9gwRjzIgvg8w4rD-N-X6g3xKLuEkI-DIbVBHTy5phiJbED7PlAJ7tXev9Ts_bq-cUXrPftiPGFEX3Z3zG6KTLjeOcpZUS4YbUy9bVtS8UCAYiTeINh9ywuwINb5esK7fnyotsTFXpAdy9oo39cxnxpLxcdN7DqhohzohY6TbHLzfBwtF4pKj_VIfhVN762_w\",\"p\":\"uliZxb9TMynkz2WWq0cnfHtV-ElhZGzX7CpsCa59N_HBNvb3Q1LRg7fQ5tTIL0CqblYPzsDM7KzTw173Z3m9AJNha-ulukxSkOv4A3Z0zZTcsPA62PPmX-SqxRAcCzJEnovVxnis-44gjuXQBqcuNVDyDp6NK8xOvFNQpshnivc\",\"q\":\"3j1VylsKEGtkWv5Wi2F7UqA_EApVUNnytti8lSEh0Ljznn8CGnedJhsFQroT5X09q08l1fBPsJcuxd8CyZIXrk7fA1dhixVIEl6nMmVWc3whxNeWoo3epLRCYMljaGYGRAOSPCzqWu75Up3JK62d67wzaQGT0lM1nIi4WEf415M\",\"dp\":\"RheLh6kml2kbqrMwkC5MePM_bAvV-VtDgI6YYq_iY8eogI82hHlDW4MprZm9zqBJOwVeHsvAiQmdAbDX6HEPGYdWLqzNgpywtdg8SrkkyCtFM7y4teBP-CPf5A3iLofy7Zv1hhjgICLetkFVFRuPMvjGg585xI6t0wKXpJRe9hM\",\"dq\":\"mmbKn9g4WcgC5SUnQ5bqczFaHu7O72k8s8RI4OMv9y9IMqnS8EiCKeND-GQHRr2IhuhqRQS8mNewa1DRQvH4-eVaE5w17MdQV1LjnqPBOGLZo0SVJ0KhmJSUOWIxamrXl5FTm_Morxywo7Fz_qCUwx7yKNYruUiOSr7CNLNsM3k\",\"qi\":\"B-z7MBGLg6g0ExtYbdC8WMNEk-5geZZS39R7hTO4wY3-wX1jSwQH18vNU0nVuTcAu_GRl5d_Hdom37P6xBhWW00w99RVJp-ZcYL8Oiu3H_ZTznGUvFz_pZFVE5u3e02tKlUTaepy8ffSgH8PQ0Krb4zc8SF_I5-NoKqi-LcKJhE\"}";
    private static final String publicJSON = "{\"kty\":\"RSA\",\"n\":\"ocV66NdFjdQfeC3xis4OTsg3t1GWO2iH5zRjPCc9D9jUDDrTjOn9yOrocWmtZ86_9wLrNI4kfi_bn0PRy-BBrmh0i7L75UFhkNk6_fLdv1psIvIDcoNxfjF4K5X2PsAGBA_o_Dc_S_ElrKC52oLA9-2eL2xDqOwJWkNB38s6MgmRGokaLZz25IPgxIkm-w6XirJXJ0qxmaydXilPVSGzUS77nVVC5AzWPNL6N665xTixcApqfFxZSXmV2f4r9K5Vyo0ej7jWLv71spYYPme2XNoFmblfbsptxi-mX4zeZ4-wpT2Ob6YsWu2mG0qE6GopsGiSu5evAKcma4rVKXI81Q\",\"e\":\"AQAB\"}";
    /**
     * 生成 token 令牌
     * @param userId 用户ID
     * @param userName 用户名
     * @return token 令牌
     */
    public static String sign(Long userId, String userName) throws JoseException {
        //  1.构建载荷 claims
        JwtClaims claims = new JwtClaims();
        // 发行人 谁发现并签署了该 token 令牌
        claims.setIssuer("abcd");
        // 用户 该token令牌给谁使用
        claims.setAudience("audience");
        // 到期时间 10分钟
        claims.setExpirationTimeMinutesInTheFuture(1000);
        // 主题
        claims.setSubject("subject");
        // 在此之前不可用
        claims.setNotBeforeMinutesInThePast(2);
        // 发布时间
        claims.setIssuedAtToNow();
        // 唯一标识ID
        claims.setGeneratedJwtId();
        // 设置自定义数据
        claims.setClaim("userId", userId);
        claims.setClaim("userName", userName);
        // 2. 构建标签 JsonWebSignature
        JsonWebSignature jws = new JsonWebSignature();
        // 2.1 给标签设置载荷
        jws.setPayload(claims.toJson());
        // 2.2 给标签设置私钥
        PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(privateJSON)).getPrivateKey();
        // JWT使用私钥签署
        jws.setKey(privateKey);
        // 2.3 置关键ID（kid）头，因为这是一种礼貌的做法。 在这个例子中，我们只有一个键但是使用键ID可以帮助促进平稳的关键滚动过程
        jws.setKeyIdHeaderValue("keyId");
        // 2.4 给标签设置签名算法 RSA_USING_SHA256
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        // 签署JWS并生成紧凑的序列化或完整的jw/JWS 表示，它是由三个点（'.'）分隔的字符串
        // 在表单头.payload.签名中使用base64url编码的部件 如果你想对它进行加密，你可以简单地将这个jwt设置为有效负载
        // 在JsonWebEncryption对象中，并将cty（内容类型）头设置为“jwt”。
        return jws.getCompactSerialization();
    }

    /**
     * 解密token
     * @param token 令牌
     * @return 解密后的载荷
     */
    public static JwtClaims checkJWT(String token) throws JoseException {
        // 获取公钥
        PublicKey publicKey = new RsaJsonWebKey(JsonUtil.parseJson(publicJSON)).getRsaPublicKey();

        /*
         * 使用JwtConsumer builder构建适当的JwtConsumer，它将 用于验证和处理JWT。 JWT的具体验证需求是上下文相关的， 然而,
         * 通常建议需要一个（合理的）过期时间，一个受信任的时间 发行人, 以及将你的系统定义为预期接收者的受众。
         * 如果JWT也被加密，您只需要提供一个解密密钥对构建器进行解密密钥解析器。
         */
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime()
                // 允许在验证基于时间的令牌时留有一定的余地，以计算时钟偏差。单位/秒
                .setAllowedClockSkewInSeconds(30)
                .setExpectedAudience("audience") // jwt发布给谁，用来验证观众
                .setExpectedIssuer("abcd") // 谁发布的，验证发布人
                .setRequireSubject() // 主题
                .setVerificationKey(publicKey) // 用公钥验证签名，验证秘钥
                // 只允许在给定上下文中预期的签名算法,使用指定的算法验证
                .setJwsAlgorithmConstraints(// 白名单
                        AlgorithmConstraints.ConstraintType.WHITELIST
                        , AlgorithmIdentifiers.RSA_USING_SHA256)
                .build();
        try {
            // 验证JWT并将其处理为jwtClaims
            return jwtConsumer.processToClaims(token);
        } catch (InvalidJwtException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws JoseException {
//        {"kty":"RSA","n":"ocV66NdFjdQfeC3xis4OTsg3t1GWO2iH5zRjPCc9D9jUDDrTjOn9yOrocWmtZ86_9wLrNI4kfi_bn0PRy-BBrmh0i7L75UFhkNk6_fLdv1psIvIDcoNxfjF4K5X2PsAGBA_o_Dc_S_ElrKC52oLA9-2eL2xDqOwJWkNB38s6MgmRGokaLZz25IPgxIkm-w6XirJXJ0qxmaydXilPVSGzUS77nVVC5AzWPNL6N665xTixcApqfFxZSXmV2f4r9K5Vyo0ej7jWLv71spYYPme2XNoFmblfbsptxi-mX4zeZ4-wpT2Ob6YsWu2mG0qE6GopsGiSu5evAKcma4rVKXI81Q","e":"AQAB"}
//        {"kty":"RSA","n":"ocV66NdFjdQfeC3xis4OTsg3t1GWO2iH5zRjPCc9D9jUDDrTjOn9yOrocWmtZ86_9wLrNI4kfi_bn0PRy-BBrmh0i7L75UFhkNk6_fLdv1psIvIDcoNxfjF4K5X2PsAGBA_o_Dc_S_ElrKC52oLA9-2eL2xDqOwJWkNB38s6MgmRGokaLZz25IPgxIkm-w6XirJXJ0qxmaydXilPVSGzUS77nVVC5AzWPNL6N665xTixcApqfFxZSXmV2f4r9K5Vyo0ej7jWLv71spYYPme2XNoFmblfbsptxi-mX4zeZ4-wpT2Ob6YsWu2mG0qE6GopsGiSu5evAKcma4rVKXI81Q","e":"AQAB","d":"GO1Xn5pQRub5RGj777IJpV0XrME_H39fdaJuah33vEHihtHnuC50IyoDUDqC9Fx42wSRnqMKf4E7W8K1CK_RHyFMWBxn0S8ubAX1H511St-Rix70pggYDGRuCnVMoOWw555V_cs7jyWk8wE_Mir0th9gwRjzIgvg8w4rD-N-X6g3xKLuEkI-DIbVBHTy5phiJbED7PlAJ7tXev9Ts_bq-cUXrPftiPGFEX3Z3zG6KTLjeOcpZUS4YbUy9bVtS8UCAYiTeINh9ywuwINb5esK7fnyotsTFXpAdy9oo39cxnxpLxcdN7DqhohzohY6TbHLzfBwtF4pKj_VIfhVN762_w","p":"uliZxb9TMynkz2WWq0cnfHtV-ElhZGzX7CpsCa59N_HBNvb3Q1LRg7fQ5tTIL0CqblYPzsDM7KzTw173Z3m9AJNha-ulukxSkOv4A3Z0zZTcsPA62PPmX-SqxRAcCzJEnovVxnis-44gjuXQBqcuNVDyDp6NK8xOvFNQpshnivc","q":"3j1VylsKEGtkWv5Wi2F7UqA_EApVUNnytti8lSEh0Ljznn8CGnedJhsFQroT5X09q08l1fBPsJcuxd8CyZIXrk7fA1dhixVIEl6nMmVWc3whxNeWoo3epLRCYMljaGYGRAOSPCzqWu75Up3JK62d67wzaQGT0lM1nIi4WEf415M","dp":"RheLh6kml2kbqrMwkC5MePM_bAvV-VtDgI6YYq_iY8eogI82hHlDW4MprZm9zqBJOwVeHsvAiQmdAbDX6HEPGYdWLqzNgpywtdg8SrkkyCtFM7y4teBP-CPf5A3iLofy7Zv1hhjgICLetkFVFRuPMvjGg585xI6t0wKXpJRe9hM","dq":"mmbKn9g4WcgC5SUnQ5bqczFaHu7O72k8s8RI4OMv9y9IMqnS8EiCKeND-GQHRr2IhuhqRQS8mNewa1DRQvH4-eVaE5w17MdQV1LjnqPBOGLZo0SVJ0KhmJSUOWIxamrXl5FTm_Morxywo7Fz_qCUwx7yKNYruUiOSr7CNLNsM3k","qi":"B-z7MBGLg6g0ExtYbdC8WMNEk-5geZZS39R7hTO4wY3-wX1jSwQH18vNU0nVuTcAu_GRl5d_Hdom37P6xBhWW00w99RVJp-ZcYL8Oiu3H_ZTznGUvFz_pZFVE5u3e02tKlUTaepy8ffSgH8PQ0Krb4zc8SF_I5-NoKqi-LcKJhE"}

//        RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
//        // 生成公钥
//        String publicJSON = rsaJsonWebKey.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY);
//        // 生成私钥
//        String privateJSON = rsaJsonWebKey.toJson(JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
//        System.out.println(publicJSON);
//        System.out.println(privateJSON);
        // jwt 加密
        String itbaizhan = sign(1001L, "itbaizhan");
        System.out.println("jwt = "+itbaizhan);
        // jwt 解密
        JwtClaims check = checkJWT(itbaizhan);
        System.out.println(check.getClaimValue("userId"));
        System.out.println(check.getClaimValue("userName"));
        System.out.println(check);
    }

}

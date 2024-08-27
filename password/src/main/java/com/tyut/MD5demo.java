package com.tyut;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @version v1.0
 * @author OldGj 2024/04/16
 * @apiNote MD5算法实现消息摘要
 */
public class MD5demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 原文
        String input = "guojiaqi";

        // 加密算法
        String algorithm = "MD5";

        // 获取消息摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        // 获取消息数字摘要的字节数组
        byte[] digest = messageDigest.digest(input.getBytes());

        //System.out.println(new String(digest));
        // base 64 编码
        Base64.Encoder encoder = Base64.getEncoder();
        System.out.println(encoder.encodeToString(digest));

    }

}

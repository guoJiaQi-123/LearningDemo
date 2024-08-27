package com.tyut;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @version v1.0
 * @author OldGj 2024/04/16
 * @apiNote Des 对称加密
 */
public class DESDemo {

    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        // 原文
        String input = "echo";
        // 秘钥 必须为8个字符
        String key = "123a5678";
        // 加密/解密算法
        String algorithm = "DES";

        String s = encryptDES(input, key, algorithm);
        System.out.println(s);
        String s1 = decryptDES(s, key, algorithm);
        System.out.println(s1);

    }

    /**
     * DES对称加密
     * @param input 原文
     * @param key 秘钥
     * @param algorithm 算法
     * @return 密文
     */
    public static String encryptDES(String input, String key, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 获取对称加密算法对象
        Cipher cipher = Cipher.getInstance(algorithm);

        // 创建加密规则
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);

        // 初始化加密模式  ENCRYPT_MODE 加密   DECRYPT_MODE 解密
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] bytes = cipher.doFinal(input.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        return new String(encoder.encode(bytes));
    }

    /**
     * DES对称解密
     * @param input 密文
     * @param key 秘钥
     * @param algorithm 算法
     * @return 原文
     */
    public static String decryptDES(String input, String key, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 获取对称加密算法对象
        Cipher cipher = Cipher.getInstance(algorithm);

        // 创建加密规则
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);

        // 初始化加密模式  ENCRYPT_MODE 加密   DECRYPT_MODE 解密
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        // 先对密文进行 base64解码
        byte[] decode = Base64.getDecoder().decode(input.getBytes());
        byte[] bytes = cipher.doFinal(decode);
        return new String(bytes);
    }
}

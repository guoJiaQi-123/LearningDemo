package com.tyut;

import org.apache.commons.io.FileUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @version v1.0
 * @author OldGj 2024/04/16
 * @apiNote 非对称加密
 */
public class RSADemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        // 原文
        String input = "echo";
        // 加密算法
        String algorithm = "RSA";
//        generateKey(algorithm, "a.pub", "a.pri");
        // 获取公钥
        PublicKey pubKey = getPubKey("a.pub", algorithm);
        // 使用公钥加密
        String s = encryptRSA(input, pubKey, algorithm);
        System.out.println(s);
        // 获取私钥
        PrivateKey priKey = getPriKey("a.pri", algorithm);
        // 使用私钥解密
        String s1 = decryptRSA(s, priKey, algorithm);
        System.out.println(s1);
    }


    /**
     * 生成公钥和私钥方法
     * @param algorithm 算法
     * @param pubPath 公钥存放路径
     * @param priPath 私钥存放路径
     */
    public static void generateKey(String algorithm, String pubPath, String priPath) throws NoSuchAlgorithmException, IOException {
        /*
            1.获取密钥对生成器 -> 2.生成秘钥对 -> 3.生成公钥和私钥

            -> 4.将公钥和私钥转为 byte 数组后使用 base64 编码

            -> 5.使用io流技术将编码后的秘钥写道文件中
         */
        // 获取密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 生成秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 生成公钥
        PublicKey publicKey = keyPair.getPublic();
        // 生成私钥
        PrivateKey privateKey = keyPair.getPrivate();
        // 获取字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        byte[] privateKeyEncoded = privateKey.getEncoded();
        // 使用 base64编码
        String publicKeyString = new String(Base64.getEncoder().encode(publicKeyEncoded));
        String privetKeyString = new String(Base64.getEncoder().encode(privateKeyEncoded));
        // 将公钥写道公钥路径下
        FileUtils.writeStringToFile(new File(pubPath), publicKeyString, StandardCharsets.UTF_8);
        FileUtils.writeStringToFile(new File(priPath), privetKeyString, StandardCharsets.UTF_8);
    }


    /**
     * 获取公钥
     * @param pubPath 公钥的存放路径
     * @param algorithm 算法
     * @return 公钥
     */
    public static PublicKey getPubKey(String pubPath, String algorithm) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        /*
            1.从文件中读取公钥 -> 2.获取密钥工厂

            -> 3.将读取的公钥转为byte数组后通过base64解编码并构建密钥规范 -> 4.使用密钥工厂生成公钥
         */
        // 将文件内容转为字符串
        String publicKeyString = FileUtils.readFileToString(new File(pubPath), StandardCharsets.UTF_8);
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        // 构建密钥规范 进行 base64 解编码
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyString.getBytes()));
        // 生成公钥
        return keyFactory.generatePublic(spec);
    }

    /**
     * 使用公钥加密
     * @param input 原文
     * @param publicKey 公钥
     * @param algorithm 算法
     * @return 密文
     */
    public static String encryptRSA(String input, PublicKey publicKey, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        /*
            1.获取加密对象Cipher -> 2.初始化加密模式  -> 3.对原文进行加密 -> 4.加密后的数据进行base64编码
         */

        // 获取加密对象
        Cipher cipher = Cipher.getInstance(algorithm);
        // 初始化加密模式
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        // 对原文进行加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        // 对加密后的数据进行base64编码
        byte[] encode = Base64.getEncoder().encode(bytes);
        return new String(encode);
    }

    /**
     * 获取私钥
     * @param priPath 私钥存放路径
     * @param algorithm 算法
     * @return 私钥
     */
    public static PrivateKey getPriKey(String priPath, String algorithm) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        // 将文件中的私钥数据读出
        String priKeyString = FileUtils.readFileToString(new File(priPath), StandardCharsets.UTF_8);
        // 创建秘钥生成对象
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        // 私钥生成策略
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(priKeyString.getBytes()));
        return keyFactory.generatePrivate(spec);
    }

    /**
     * 使用私钥解密
     * @param input 密文
     * @param privateKey 私钥
     * @param algorithm 算法
     * @return 原文
     */
    public static String decryptRSA(String input, PrivateKey privateKey, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 获取加密对象
        Cipher cipher = Cipher.getInstance(algorithm);
        // 构建解密模型
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // 使用base64解编码
        byte[] decode = Base64.getDecoder().decode(input);
        // 解密
        byte[] bytes = cipher.doFinal(decode);
        return new String(bytes);
    }


}

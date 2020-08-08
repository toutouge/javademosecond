package com.toutou.sample.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author toutou
 * @date by 2020/07
 * @des
 */
public class Test {
    public static final String algorithm = "AES";
    // AES/CBC/NOPaddin
    // AES 默认模式
    // 使用CBC模式, 在初始化Cipher对象时, 需要增加参数, 初始化向量IV : IvParameterSpec iv = new
    // IvParameterSpec(key.getBytes());
    // NOPadding: 使用NOPadding模式时, 原文长度必须是8byte的整数倍
    public static final String transformation = "AES/CBC/NOPadding";
    public static final String key = "1234567812345678";

    public static void main( String[] args ) {
        try {
            String value = "https://img2.autoimg.cn/immsgdfs/g29/M08/64/4A/ChcCSF6BnCqAOCTlAABr3AJSGvc918.jpg|https://img2.autoimg.cn/immsgdfs/g24/M08/CF/34/ChsEeV6BnE-AE-ETAAVNxJMog4I883.jpg";
            value = encryptByAES(value);
            String value2 = "141414141414141414";
            value2 = encryptByAES(value2);
            String value3 = "22222222222";
            value3 = encryptByAES(value3);
            System.out.println(value);
            System.out.println(value2);
            System.out.println(value3);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println(decryptByAES(value));
            System.out.println(decryptByAES(value2));
            System.out.println(decryptByAES(value3));
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public static String encryptByAES(String original) throws Exception {
        // 获取Cipher
        Cipher cipher = Cipher.getInstance(transformation);
        // 生成密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 指定模式(加密)和密钥
        // 创建初始化向量
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
        // cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        // 加密
        byte[] bytes = cipher.doFinal(original.getBytes());

        return Base64Util.encryptBASE64(bytes);
    }

    /**
     * 解密
     * @param encrypted 需要解密的参数
     * @return
     * @throws Exception
     */
    public static String decryptByAES(String encrypted) throws Exception {
        // 获取Cipher
        Cipher cipher = Cipher.getInstance(transformation);
        // 生成密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 指定模式(解密)和密钥
        // 创建初始化向量
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        // cipher.init(Cipher.DECRYPT_MODE, keySpec);
        // 解密
        byte[] bytes = cipher.doFinal(Base64Util.decryBASE64(encrypted));

        return new String(bytes);
    }
}

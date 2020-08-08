package com.toutou.hello;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author toutou
 * @date by 2020/08
 * @des
 */
public class LocalMain {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("Bt%XJ^n1j8mz");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("toutou");
        String password = textEncryptor.encrypt("demo123456");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}

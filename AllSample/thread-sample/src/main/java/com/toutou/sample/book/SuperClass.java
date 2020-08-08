package com.toutou.sample.book;

/**
 * @author toutou
 * @date by 2020/06
 * @des /** * 被动使用类字段演示一： 通过子类引用父类的静态字段，不会导致子类初始化
 */
public class SuperClass {
    static{
        System.out.println("Super-Class init.");
    }

    public static int value = 123;
}

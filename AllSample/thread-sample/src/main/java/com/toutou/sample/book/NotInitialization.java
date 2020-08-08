package com.toutou.sample.book;

/**
 * @author toutou
 * @date by 2020/06
 * @des 被动使用类字段演示三： 常量在编译阶段会存入调用类的常量池中，
 * 本质上没有直接引用到定义常量的类，因此不会触发定义常量的 类的初始化
 */
public class NotInitialization {
    public static void main( String[] args ) {
        System.out.println(ConstClass.HELLO);
    }
}

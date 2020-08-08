package com.toutou.sample.book;

/**
 * @author toutou
 * @date by 2020/05
 */
public class FirstBook {

    public Object instance = null; private static final int _1MB = 1024 * 1024;

    /** * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有回收过 */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main( String[] args ) {
        FirstBook objA = new FirstBook();
        FirstBook objB = new FirstBook();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null; // 假设在这行发生GC，objA和objB是否能被回收？ System.gc();
        System.gc();
        System.out.println( "OK." );
    }
}

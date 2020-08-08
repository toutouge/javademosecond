package com.toutou.sample.book;

import java.util.Map;

/**
 * @author toutou
 * @date by 2020/06
 */
public class FirstEden {

    private static final int _1MB = 1024 * 1024;

    public static void main( String[] args ) {
        byte[] b1, b2, b3, b4;
        b1 = new byte[2 * _1MB];
        b2 = new byte[2 * _1MB];
        b3 = new byte[2 * _1MB];
        b4 = new byte[4 * _1MB];
        Map<Thread, StackTraceElement[]> ss = Thread.getAllStackTraces();
        System.out.println( "OK." );
    }
}

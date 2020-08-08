package com.toutou.sample.first;

/**
 * @author toutou
 * @date by 2020/05
 */
public class ShareVariableRunnable implements Runnable {
    private int count = 5;
    public synchronized void run(){
        System.out.println(String.format("%s, count %d", Thread.currentThread().getName(),count--));
    }
}

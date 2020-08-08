package com.toutou.sample.first;

/**
 * @author toutou
 * @date by 2020/05
 */
public class FirstThread extends Thread{
    @Override
    public void run(){
        super.run();
        System.out.println("Hello thread.");
    }
}

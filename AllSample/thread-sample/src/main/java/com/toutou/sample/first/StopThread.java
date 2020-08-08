package com.toutou.sample.first;

/**
 * @author toutou
 * @date by 2020/05
 */
public class StopThread extends Thread {
    public StopThread(String name){
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + ":线程开始运行.");
        int i = 0;
        while(!isInterrupted()){
            System.out.println(""+(i++));
        }

        System.out.println("我停止了. timer:" + System.currentTimeMillis());
    }
}

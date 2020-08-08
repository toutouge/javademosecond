package com.toutou.sample.first;

/**
 * @author toutou
 * @date by 2020/05
 */
public class RandomThread extends Thread{
    public RandomThread(String name){
        super(name);
    }

    public void run(){
        try{
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
package com.toutou.sample.first;

/**
 * @author toutou
 * @date by 2020/05
 */
public class PrintPrivateNum {
    private int num = 0;
    public synchronized void printNum(String name){
        if("thread1".equals(name)){
            num += 300;
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        if("thread2".equals(name)){
            num -= 100;
        }

        System.out.println(Thread.currentThread().getName() + ", Num:" + num);
    }
}

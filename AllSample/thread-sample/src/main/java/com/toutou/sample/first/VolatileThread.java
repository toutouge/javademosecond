package com.toutou.sample.first;

/**
 * @author toutou
 * @date by 2020/05
 */
public class VolatileThread implements Runnable{
    private boolean isPrint = true;
    public void setPrint(boolean flag){
        this.isPrint = flag;
        if(!flag){
            System.out.println("" + Thread.currentThread().getName() + ", 尝试让线程退出。");
        }
    }

    public void run(){
        int num = 0;
        while(isPrint){
            num++;
        }

        System.out.println("" + Thread.currentThread().getName() + ", 停止运行。num:" + num);
    }
}

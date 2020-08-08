package com.toutou.sample.first;

/**
 * @author toutou
 * @date by 2020/05
 */
public class WaitNotify {
    public void testMethodA() throws InterruptedException{
        Thread.sleep(1000);
        synchronized(this){
            System.out.println(Thread.currentThread().getName() + ",进入Wait!" + Thread.currentThread().getState());
            this.wait();
            System.out.println(Thread.currentThread().getName() + ",退出Wait!" + Thread.currentThread().getState());
        }
    }

    public void testMethodB() throws InterruptedException{
        Thread.sleep(1000);
        synchronized(this){
            System.out.println(Thread.currentThread().getName() + ",进入notify!" + Thread.currentThread().getState());
            this.notify();
            System.out.println(Thread.currentThread().getName() + ",退出notify!" + Thread.currentThread().getState());
        }
    }
}

package main.java.sync;

/**
 * @author toutou
 * @date by 2020/01
 */
public class ObejctRun {
    public static void main(String[] args){
        final ObjectSynchronized test = new ObjectSynchronized();
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run(){
                test.minus();
            }
        });

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run(){
                test.minus2();
            }
        });

        thread1.start();
        thread2.start();
    }
}

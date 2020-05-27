package main.java.sync;

/**
 * @author toutou
 * @date by 2020/01
 */
public class ClassRun {
    public static void main(String[] args){
            final ClassSynchronized test = new ClassSynchronized();
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run(){
                ClassSynchronized.minus();
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

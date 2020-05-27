package main.java.sync;

/**
 * @author toutou
 * @date by 2020/01
 */
public class ClassSynchronized {
    public static synchronized void minus(){
        int count = 5;
        for(int i = 0; i < 5; i++){
            count--;
            System.out.println(String.format("%s-%s", Thread.currentThread().getName(), count));
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void minus2(){
        int count = 5;
        for(int i = 0; i < 5; i++){
            count--;
            System.out.println(String.format("%s-%s", Thread.currentThread().getName(), count));
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

package main.java.sync;

/**
 * @author toutou
 * @date by 2019/12
 */
public class ObjectSynchronized {
    public synchronized void minus(){
        int count = 5;
        for(int i = 0; i < 5; i++){
            count--;
            System.out.println(String.format("%s-%s", Thread.currentThread().getName(), count));
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void minus2(){
        synchronized(this) {
            int count = 5;
            for (int i = 0; i < 5; i++) {
                count--;
                System.out.println(String.format("%s-%s", Thread.currentThread().getName(), count));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

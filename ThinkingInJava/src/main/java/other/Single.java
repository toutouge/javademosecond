package main.java.other;

/**
 * @author toutou
 * @date by 2020/05
 */
public class Single {
    private static volatile Single instance;

    private Single(){}

    public static Single getInstance(){
        if(instance == null){
            synchronized(Single.class){
                if(instance == null){
                    instance = new Single();
                }
            }
        }

        return instance;
    }
}

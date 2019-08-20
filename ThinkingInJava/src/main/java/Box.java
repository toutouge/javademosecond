import java.util.HashMap;

/**
 * Created by toutou on 2018/7/18.
 */
public class Box<T> {
    private T t;
    public void add(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

    public static void main(String[] args){
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("打算"));

        System.out.printf("整数值为:%d\n\n", integerBox.get());
        System.out.printf("字符串为:%s\n\n", stringBox.get());
    }
}

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by toutou on 2018/8/13.
 */
class Actor{
    public void act(){}
}

class HappyActor extends Actor{
    public void act(){System.out.println("HappyActor");};
}

class SadActor extends Actor{
    public void act(){System.out.println("SadActor");};
}

class Stage{
    private Actor actor = new HappyActor();
    public void change(){ actor = new SadActor();}
    public void performPlay(){actor.act();}
}

public class Transmogrify {
    public static void main(String[] aegs) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }

    public String addTime(String time, Integer addTime){
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String str = time;
        Date date = null;
        try {
            date = format1.parse(str);
        } catch (ParseException e) {
        }
        GregorianCalendar gc=new GregorianCalendar();
        gc.setTime(date);
        gc.add(5,addTime);
        date = gc.getTime();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
}

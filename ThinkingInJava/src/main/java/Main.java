import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //region Description
        // printArray
        //Integer[] intArray = {1,2,3,4,5};
        //Double[] doubleArray = {1.1,1.2,1.3,1.4};
        //Character[] charArray = {'H', 'E','L','L','O'};
        //System.out.println("整形数组元素为：");
        //printArray(intArray);
        //System.out.println("\n双精数组元素为：");
        //printArray(doubleArray);
        //System.out.println("\n字符型组元素为：");
        //printArray(charArray);

        //System.out.printf("%d, %d, 和 %d, 中最大的数为 %d, \n\n", 3,4,5,maximum(3,4,5));
        //System.out.printf("%.1f, %.1f, 和 %.1f, 中最大的数为 %.1f, \n\n", 3.1,4.1,5.1,maximum(3.1,4.2,5.3));
        //System.out.printf("%s, %s, 和 %s, 中最大的数为 %s, \n\n", "pear","apple","orange",maximum("pear","apple","orange"));
        //long nd = 1000 * 24 * 60 * 60;
        //long nh = 1000 * 60 * 60;
        //long nm = 1000 * 60;
        //Date startTime = StrToDate("2018-10-21 10:41:43");
        //Date endTime = StrToDate("2018-10-21 19:42:44");
        //long diff = endTime.getTime() - startTime.getTime();
        //long day = diff / nd;
        //// 计算差多少小时
        //long hour = diff % nd / nh;
        //// 计算差多少分钟
        //long min = diff % nd % nh / nm;
        //// 计算差多少秒//输出结果
        //// long sec = diff % nd % nh % nm / ns;
        //System.out.printf(day + "天" + hour + "小时" + min + "分钟");
        //List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee","fff","ggg","xxx","yyy","zzz");
        //List<String> temp = list.stream().skip(8).limit(10).collect(Collectors.toList());
        //temp.forEach(item -> {
        //    System.out.println(item);
        //});
        //String str = "12a";
        //String str1 = "12";
        //System.out.println(str.matches("^\\d+$"));
        //System.out.println(str1.matches("^\\d+$"));
        //List<User> list = new ArrayList<>();
        //for (int i = 0; i< 10; i++){
        //    User item = new User();
        //    item.setId(i);
        //    item.setName("name" + i);
        //    list.add(item);
        //}
        //
        //List<User> uList = new ArrayList<>();
        //for (int i = 15; i< 20; i++){
        //    User item = new User();
        //    item.setId(i);
        //    item.setName("name" + i);
        //    uList.add(item);
        //}
        //
        //list.addAll(uList);

        //DesktopThread desktopThread = new DesktopThread("testest");
        //Thread t1 = new Thread(desktopThread);
        //t1.start();
        //System.out.println(1);

        //System.out.println(ByteTest((byte)1));
        //System.out.println(ByteTest((byte)2));

        //// cartlist.stream().filter(item -> item.getProductId().equals(1L)).findFirst();
        //Optional<User> user = list.stream().filter(u -> u.getId() == 3).findFirst();
        //if (user.isPresent()) {
        //    // 存在
        //    User cart =  user.get();
        //    List<User> temp = list.subList(list.indexOf(cart) + 1, list.size());
        //    System.out.println(1);
        //} else {
        //    // 不存在
        //}

        //try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
        //
        //    /* 读入TXT文件 */
        //    String pathname = "E\\uid.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        //    File filename = new File(pathname); // 要读取以上路径的input。txt文件
        //    InputStreamReader reader = new InputStreamReader(
        //            new FileInputStream(filename)); // 建立一个输入流对象reader
        //    BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        //    String line = "";
        //    String sql = "";
        //    while (br.readLine() != null) {
        //        line = "INSERT INTO [dbo].[user_robot] values(" +  br.readLine() + ",GETDATE(),GETDATE());"+"\r\n"; // 一次读入一行数据
        //        Write2(line);
        //        sql += line;
        //    }
        //    Write(sql);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //
        //System.out.println("1");

        //for(Short i = 1; i < 3; i++ ) {
        //    System.out.println(i);
        //}

        // System.out.println(TimeReduceHour());

        //Integer id = 243235100;
        //String idString = String.valueOf(id);
        //Integer count = Integer.parseInt(idString.substring(idString.length() - 2));
        //System.out.println(count);

        //for(int i=0; i<2000; i++){
        //    System.out.println(getRandom(0,2));
        //}

        //double asd=3.15151;
        //int d = (int)asd;
        //System.out.println(d);
        //Date date = new Date();
        //Calendar calendar = Calendar.getInstance();
        //calendar.setTime(date);
        //calendar.add(Calendar.HOUR, 24);
        //Date dateTemp = calendar.getTime();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String dsawq = sdf.format(dateTemp);
        //System.out.println(dsawq);
        //try {
        //    Date dateD = sdf.parse(dsawq);
        //    Date dateB = new Date();
        //    System.out.println(dateD);
        //}
        //catch(ParseException e){
        //
        //}

        //int count = 134;
        //int totalCount = 2323152;
        //String result = "returncode:0, 请求成功。";
        //String result1 = "returncode:0, 请求成功。";
        //User user = new User();
        //user.setId(1);
        //user.setName("das大叔大婶大所");
        //String format = String.format("总共[%d]条数据[%d]条数据,处理结果%s,时间为%tc     %s",count, totalCount, result, new Date(), user.toString());
        //if(count == 134 && result.equals(result1)) {
        //    System.out.println(format);
        //}
        //
        //long startTime = System.currentTimeMillis();
        //try {
        //    Thread.sleep(1000);
        //}catch(InterruptedException e){}
        //long endTime = System.currentTimeMillis();
        //float seconds = (endTime - startTime) / 1000F;
        //System.out.println("Cost seconds" + Float.toString(seconds));

        //Integer dasdas = 10;
        //if(dasdas > 9){
        //    System.out.println("1");
        //}
        //
        //if(dasdas < 12){
        //    System.out.println("2");
        //}

        //int das= 13 / 3;
        //Integer count= null;
        //if(count  == null ){
        //    System.out.println(count);
        //}
        //count = 123;

        //for(int i=0;i<100;i++) {
        //    Integer count = getRandom(0,9);
        //    System.out.println(count);
        //}

        //Integer das = 1;
        //int sdf = 1;
        //if(das.intValue() == sdf){
        //    System.out.println(2);
        //}

        //String asz = "在上一篇博文《centos安装redis》中，已经详细介绍了如何在centos上安装redis，";
        //String asd = "在上一篇博文《centos安装redis》中，已经详细介绍了如何在centos上安装redis，今天主要介绍下Redis五大数据类 Redis支持五种数据类型：String（字符串），Hash（哈希），List（列表），Set（集合）及Zset(sorted set：有序";
        //String asd1 = "在上一篇博文《centos安装redis》中已经详细介绍了如何在centos上安装redis，今天主要介绍下Redis五大数据类 Redis支持五种数据类型：String（字符串），Hash（哈希），List（列表），Set（集合）及Zset(sorted set：有序";
        //
        //System.out.println(asz.hashCode());
        //System.out.println(asz.hashCode());
        //System.out.println(asd.hashCode());
        //System.out.println(asd1.hashCode());

        //User user = new User();
        //user.setId(1);
        //user.setName("das大叔大婶大所");
        //System.out.println(user.toString());
        //List<User> list = new ArrayList<>();
        //for(int i=0;i<5;i++) {
        //    User user = new User();
        //    int temp = i;
        //    user.setId(temp);
        //    user.setName("das大叔大婶大所");
        //    list.add(user);
        //}
        //
        //for(User item : list){
        //    item.setId(item.getId() + 2);
        //}
        //System.out.println(list.size());
        //
        //int pageSize = 6;
        //int pageIndex = 1;
        //List<User> list2 = list.stream().skip((pageIndex - 1)* pageSize).limit(pageSize).collect(Collectors.toList());
        //pageIndex++;
        //List<User> list3 = list.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        //pageIndex++;
        //List<User> list4 = list.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        //pageIndex++;
        //List<User> list5 = list.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        //pageIndex++;
        //List<User> list6 = list.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        //pageIndex++;
        //
        //List<User> list8 = list.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
        //List<User> list9 = list.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());
        //
        //System.out.println(TimeFormat(8));

        //Calendar yesterday = Calendar.getInstance();
        //yesterday.add(Calendar.DATE, -1);
        //yesterday.set(Calendar.HOUR_OF_DAY, 12);
        //yesterday.set(Calendar.MINUTE, 0);
        //yesterday.set(Calendar.SECOND, 0);
        //Calendar today = Calendar.getInstance();
        //int currenHoru = today.get(Calendar.HOUR_OF_DAY);
        //today.set(Calendar.HOUR_OF_DAY, 12);
        //today.set(Calendar.MINUTE, 0);
        //today.set(Calendar.SECOND, 0);
        //Calendar tomorrow = Calendar.getInstance();
        //tomorrow.add(Calendar.DATE, 1);
        //tomorrow.set(Calendar.HOUR_OF_DAY, 12);
        //tomorrow.set(Calendar.MINUTE, 0);
        //tomorrow.set(Calendar.SECOND, 0);
        //Date currentTime = new Date();
        //Date startTime=null;
        //Date endTime=null;
        //if(currentTime.getTime() < today.getTime().getTime()){
        //    startTime = yesterday.getTime();
        //    endTime = today.getTime();
        //}else{
        //    startTime = today.getTime();
        //    endTime = tomorrow.getTime();
        //}
        //
        //String asda = "";
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(df.format(startTime));
        //System.out.println(df.format(endTime));
        //
        //Calendar calendar = Calendar.getInstance();
        //int hour = calendar.get(Calendar.HOUR_OF_DAY);
        //
        //if(hour > 12){
        //    calendar.add(Calendar.DATE, 1);
        //}
        //System.out.println(hour);
        //calendar.add(Calendar.DATE, -1); //得到前一天
        //Date date = calendar.getTime();
        //
        //System.out.println(df.format(date));
        //System.out.println("1111111111111111111111111111");
        //System.out.println(new Date().getTime());
        //Calendar now = Calendar.getInstance();
        //System.out.println(now.get(Calendar.HOUR_OF_DAY));
        //System.out.println(new Date());
        //System.out.println(new Date().toString());

        //String date = "2019-06-4 15:12:48.517";
        //Date lastDate = TimeDateFormat(date);
        //long hour  = getTimeDiffHour(lastDate);
        //System.out.println(hour);

        //List<Integer> list1=Arrays.asList(1,2,3,4,5,6,7,8,9);
        //List<Integer> list2=Arrays.asList(1,3,5,7);
        //List<Integer> list = new ArrayList<>();
        //HashSet h1 = new HashSet(list1);
        //HashSet h2 = new HashSet(list2);
        //h1.removeAll(h2);
        //list.addAll(h1);
        //for (Integer item: list
        //     ) {
        //    System.out.println(item);
        //}

        //Integer count = getRandomScope(0,1);
        //System.out.println(count);

        //Integer a = 3;
        //Integer b = -2;
        //System.out.println(a - b);
        //String str = "123345";
        //String[] strList = str.split(",");
        //if(strList.length < 2){
        //    System.out.println("NO");
        //}
        //List<Integer> list = new ArrayList<>();
        //list.add(12);
        //list.add(13);
        //list.add(15);
        //String str1= Arrays.toString(list.toArray());
        //System.out.println(str1);
        //endregion
        //Map<String, Integer> map = ImmutableMap.of("gq", 7, "aa", 9, "zs", 66, "vv", 3);
        //System.out.println("原始的map：" + map);
        //List<User> list = new ArrayList<>();
        //User user1 = new User();
        //user1.setId(9);
        //user1.setName("das大叔大婶大所");
        //list.add(user1);
        //for(int i=0;i<5;i++) {
        //    User user = new User();
        //    int temp = i;
        //    user.setId(temp);
        //    user.setName("das大叔大婶大所");
        //    list.add(user);
        //}
        ////listSeriesInfos.getResult().stream().sorted(Comparator.comparing(SeriesInfosVo::getConfidence).reversed()).collect(Collectors.toList())
        //System.out.println("没有排序");
        //list = list.stream().sorted(Comparator.comparing(User::getId).reversed()).limit(3).collect(Collectors.toList());
        //Date updateTime = new Date();
        //System.out.println(TimeConvertBatchId(updateTime));
        //voidTest();
        //System.out.println(addDays(new Date(),-1));
//        List<Integer> userIds = Arrays.asList(100,1000);
//        for (Integer userId : userIds){
//            if(userId == 100){
//                System.out.println(1);
//                return;
//            }
//
//            System.out.println(userId);
//        }
//        LocalDate localDate = LocalDate.now().minusDays(90);
//        System.out.println(localDate);
//        List<String> titles = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            titles.add(String.valueOf(i));
//        }
//
//        for (int i = 0; i < 50; i++) {
//            System.out.println(new Random().nextInt(titles.size()));
//        }

        System.out.println("OK");
    }

    //region Description
    /**
     * 增/减天
     * @param date
     * @param amount
     * @return
     */
    public static Date addDays(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date);
            cal.add(Calendar.DATE, amount);
        } catch (Exception e) {
            return null;
        }
        return cal.getTime();
    }

    public static boolean checkLogoWaterMark(Integer topicId){
        List<Integer> topicList = new ArrayList<>();
        // 肖春邮件提供
        topicList.add(504);
        topicList.add(503);
        topicList.add(502);
        topicList.add(501);
        topicList.add(500);
        topicList.add(499);
        topicList.add(498);
        topicList.add(496);
        topicList.add(497);
        topicList.add(495);
        topicList.add(494);
        topicList.add(493);
        topicList.add(492);
        topicList.add(491);
        topicList.add(489);
        topicList.add(490);
        topicList.add(488);
        topicList.add(487);
        topicList.add(486);
        topicList.add(485);
        topicList.add(484);
        topicList.add(483);
        topicList.add(482);
        topicList.add(481);
        topicList.add(478);

        // 郎乙蓬邮件提供
        topicList.add(446);
        topicList.add(447);
        topicList.add(450);
        topicList.add(452);
        topicList.add(454);
        topicList.add(456);
        topicList.add(459);
        topicList.add(462);
        topicList.add(453);
        topicList.add(455);
        topicList.add(466);
        topicList.add(458);
        topicList.add(460);
        topicList.add(461);
        topicList.add(463);
        topicList.add(465);
        List<Integer> topicList1 = topicList.stream().distinct().collect(Collectors.toList());
        return topicList.contains(topicId);
    }

    public static Integer TimeConvertBatchId(Date time){
        String format = "yyyy-MM-dd HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //String tempTime = sdf.format(time).substring(3).replaceAll("-","").replaceAll(":","").replace(" ","");
        String tempTime = sdf.format(time).substring(3).replaceAll("-|:| ","");
        Integer batchId = Integer.valueOf(tempTime);
        return batchId;
    }

    public static void voidTest(){
        System.out.println(1);
        System.out.println(2);
        if(1<2) {
            return;
        }

        System.out.println(3);
    }

    public static <E> void printArray(E[] inputArray){
        for(E element : inputArray){
            System.out.printf("%s", element);
        }

        System.out.println();
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;
        if(y.compareTo(max) > 0){
            max = y;
        }
        if(z.compareTo(max) > 0){
            max = z;
        }

        return max;
    }

    public static Integer getRandomScope(int min, int max){
        Random randomTemp = new Random();
        int scope = randomTemp.nextInt(max) % (max - min + 1) + min;
        return scope;
    }

    /*
       当前时间和指定时间的差值(小时)
    */
    public static long getTimeDiffHour(Date date) {
        long nh = 1000 * 60 * 60;
        long diff = new Date().getTime() - date.getTime();
        long min = diff / nh;
        return min;
    }

    public static Integer getRandom(int min, int max){
        Random random = new Random();
        Integer s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    public static Date TimeDateFormat(String time){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(time);
        }catch (ParseException e){}

        return new Date();
    }

    public static String TimeFormat(int chazhi){
        Date beginTime = new Date(System.currentTimeMillis() - chazhi * 3600 * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(beginTime);
    }

    public static String TimeReduceHour(){
        Date date = new Date();//获取当前时间    
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, -24);
        calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(calendar.getTime());
    }

    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static void Write(String line){
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 写入Txt文件 */
            File writename = new File("E\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(line); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Write2(String line){
        String file = "E\\output2.txt";
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte ByteTest(byte type) {

        if(type == 1) {
            return type;
        }else{
            return 2;
        }
    }
    //endregion
}

class User implements Serializable{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class DesktopThread implements Runnable {
    private String site;

    public DesktopThread(String site) {
        this.site = site;
    }

    public void run() {
        try {
            Thread.sleep(5000);
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isDesktopSupported()
                    && desktop.isSupported(Desktop.Action.BROWSE)) {
                URI uri = new URI(site);
                desktop.browse(uri);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (URISyntaxException ex) {
            System.out.println(ex);
        }
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
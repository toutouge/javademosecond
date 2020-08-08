package com.toutou.sample;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.toutou.sample.first.*;
import com.toutou.sample.other.Employee1;
import com.toutou.sample.other.Employee2;
import com.toutou.sample.other.People;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.Key;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //FirstThread thread = new FirstThread();
        //thread.start();
        //new Thread(new Runnable(){
        //    @Override
        //    public void run(){
        //        System.out.println("Hello run.");
        //    }
        //}).start();

        //Runnable runnable = new FirstThread();
        //Thread thread = new Thread(runnable);
        //thread.start();

        //Thread[] threads = new Thread[10];
        //for(int i = 0; i < 10; i++){
        //    threads[i] = new RandomThread(String.format("RandomThread:%d", i));
        //}
        //for(Thread thread:threads){
        //    thread.start();
        //}

        //Runnable runnable = new ShareVariableRunnable();
        //Thread[] threads = new Thread[5];
        //for(int i = 0; i < 5; i++){
        //    threads[i] = new Thread(runnable, "Thread" + (i + 1));
        //}
        //for(Thread thread : threads){
        //    thread.start();
        //}

        //StopThread thread = new StopThread("thread_1");
        //thread.start();
        //try {
        //    Thread.sleep(2);
        //}catch(InterruptedException e){
        //    e.printStackTrace();
        //}
        //thread.interrupt();

        //Thread thread = new InterruptThread("thread_1");
        //thread.start();
        //try {
        //    Thread.sleep(1);
        //}catch(InterruptedException e){
        //    e.printStackTrace();
        //}
        //System.out.println(thread.getName() + "线程设置:interrupt");
        //thread.interrupt();

        //final PrintPrivateNum num = new PrintPrivateNum();
        //Thread thread1 = new Thread("thread1"){
        //    @Override
        //    public void run(){
        //        num.printNum(Thread.currentThread().getName());
        //    };
        //};
        //Thread thread2 = new Thread("thread2"){
        //    @Override
        //    public void run(){
        //        num.printNum(Thread.currentThread().getName());
        //    }
        //};
        //thread1.start();
        //thread2.start();

        // ----------模拟死锁
        //final DealThread dealThread = new DealThread();
        //Thread thread1 = new Thread("thread1"){
        //    public void run(){
        //        dealThread.methodA();
        //    }
        //};
        //Thread thread2 = new Thread("thread2"){
        //    public void run(){
        //        dealThread.methodB();
        //    }
        //};
        //thread1.start();
        //thread2.start();

        //VolatileThread runnable = new VolatileThread();
        //Thread thread = new Thread(runnable, "thread1");
        //thread.start();
        //try{
        //    Thread.sleep(1000);
        //}catch(InterruptedException e){
        //    e.printStackTrace();
        //}
        //runnable.setPrint(false);

        //final WaitNotify waitNotify = new WaitNotify();
        //Thread thread1 = new Thread("thread1"){
        //    public void run(){
        //        try{
        //            waitNotify.testMethodA();
        //        }catch(InterruptedException e){
        //            e.printStackTrace();
        //        }
        //    }
        //};
        //Thread thread2 = new Thread("thread2"){
        //    public void run(){
        //        try{
        //            waitNotify.testMethodB();
        //        }catch(InterruptedException e){
        //            e.printStackTrace();
        //        }
        //    }
        //};
        //
        //thread1.start();
        //thread2.start();
        //try {
        //    Thread.sleep(1000);
        //    System.out.println(thread1.getName() + ",state:" + thread1.getState());
        //    Thread.sleep(500);
        //    System.out.println(thread1.getName() + ",state:" + thread1.getState());
        //}catch(InterruptedException e){
        //    e.printStackTrace();
        //}

        //String str1 = new StringBuilder("计算机").append("软件").toString();
        //System.out.println(str1.intern() == str1);
        //String str2 = new StringBuilder("j").append("ava").toString();
        //System.out.println(str2.intern() == str2);
        //int[] names = new int[10];
        //for(int name:names){
        //    System.out.println(name);
        //}
        //Arrays.binarySearch(names,1);
        //names.equals(names);
        //System.out.println(Arrays.toString(names));
        //Integer value = new Integer(2);
        //System.out.println( value);
        //System.out.println( value.intValue());
        //value = 9;
        //System.out.println( value);
        //System.out.println( value.intValue());
        //System.out.println( Thread.activeCount());
        //String ss = "";
        //
        //Integer[] intArray = {6,1,7,2,8,5};-
        //People p1 = new Employee2(2);
        //People p2 = new Employee1(1);
        //p1.outPutName();
        //String[] intArray = {"1" , "2"};
        //System.out.println( String.join("", intArray));
        //
        //List<String> stringArrayList = new ArrayList<>();
        //List<Integer> integerArrayList = new ArrayList<>();
        //
        //Class classStringArrayList = stringArrayList.getClass();
        //Class classIntegerArrayList = integerArrayList.getClass();
        //
        //if(classStringArrayList.equals(classIntegerArrayList)){
        //    System.out.println(1);
        //}else{
        //    System.out.println(2);
        //}

        //System.out.println("".length());
        //System.out.println(System.getProperty("user.dir"));
        //System.out.println(File.separator);
        //Instant now = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        //System.out.println("now:"+now);
        //Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        //System.out.println(instant);
        ////Duration duration = Duration.between()
        //Date date = new Date();
        //System.out.println(date);
        //LocalDate localDate = LocalDate.now();
        //System.out.println(localDate);
        //LocalDate localDate1 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
        //System.out.println(localDate1);
        //LocalTime localTime =LocalTime.now().plusHours(2);
        //System.out.println(localTime);
        //Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        //zoneIds.stream().sorted().forEach(e-> {
        //    System.out.println(e);
        //    if(e.contains("Bei")) {
        //        System.out.println(e);
        //    }
        //});
        //Locale locale = new Locale("de","CH");
        //System.out.println(locale.getDisplayName(Locale.GERMAN));
        //NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        //format.setCurrency(Currency.getInstance("EUR"));
        //System.out.println( format.getCurrency().getDisplayName());
        //byte a = 3;
        //int b = 3;
        //System.out.println(a == b);
        //LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);//当天零点
        //System.out.println(today_start);
        //String time = today_start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //System.out.println( time);
        //LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);//当天零点
        //System.out.println(today_end);
        //String time1 = today_end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //System.out.println( time1);
        //List<Employee2> list = new ArrayList<>();
        //list.add(new Employee2(1));
        //list.add(new Employee2(2));
        //list.add(new Employee2(3));
        //list.add(new Employee2(4));
        //list.add(new Employee2(5));
        //String sendIdsLog = String.join(",", list.stream().map(p -> String.valueOf(p.getId())).sorted().collect(Collectors.toList()));
        //String sendLogMessage = String.format("%s|-|%s", "此条数据已经存在对方的数据库中,处理中断！需要重新请求", sendIdsLog);
        //if(sendLogMessage.length() > 4000){
        //    // 4000 is db max length.
        //    sendLogMessage = sendLogMessage.substring(0, 4000);
        //}
        //
        //System.out.println(sendLogMessage);
        //String[] arr = new String[]{"a","b","c"};
        //Stream<String> stream = Arrays.stream(arr);
        //System.out.println( 1);
        //stream = Stream.of("a","b","c");
        List<Employee2> list = new ArrayList<>();
        for(int i = 0; i < 200; i++){
            list.add(new Employee2(i));
        }
        //list.parallelStream().forEach( p -> {
        //    if(p.getId() % 2 != 0){
        //        System.out.println(String.format("id %d", p.getId()));
        //    }
        //});
        //boolean isValid = list.stream().anyMatch(element -> element.getId() == 3);
        //System.out.println(isValid);
        //boolean isValidOne = list.stream().allMatch(p -> p.getId() == 3);
        //System.out.println(isValidOne);
        //boolean isValidTwo = list.stream().noneMatch(p -> p.getId() == 3);
        //System.out.println(isValidTwo);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //executorService.submit(new Runnable() {
        //    @Override
        //    public void run() {
        //        log.info("new runnable");
        //    }
        //});
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //executorService.submit(new Runnable(){
        //    @Override
        //    public void run(){
        //        System.out.println("new runnable");
        //    }
        //});
        //
        //executorService.submit(() -> {
        //    System.out.println("匿名");
        //});
        Class cls = String.class;
        String s = "hello";
        Class cls2 = s.getClass();
        System.out.println(cls == cls2);
        System.out.println( "OK." );
    }
}

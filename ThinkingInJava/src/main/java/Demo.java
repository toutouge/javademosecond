package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author toutou
 * @date by 2019/11
 */
public class Demo {
    static StringBuffer sb1=new StringBuffer(); //声明两个静态StringBuffer对象实例
    static StringBuffer sb2=new StringBuffer();
    public static void main(String[] args) {
        String parm = "0";
        if(args.length > 0){
            parm = args[0];
        }

        System.out.println("参数" + parm);
        if(parm.equals("0")){
            while (true){
                try {
                    Thread.sleep(750);
                    System.out.println("纯输出版while循环.");
                }catch (InterruptedException e){
                    System.out.println(e.toString());
                }
            }
        }else if(parm.equals("1")){
            // 写文件
            writeFile();
        }else if(parm.equals("2")){
            // 读文件
            readFile();
        }else if(parm.equals("3")){
            // 多线程读写
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readFile();
                    writeFile();
                    readFile();
                }
            }).start();
        }
        else if(parm.equals("4")){
            // 死锁
            new Thread(){    //声明两个线程实例，并start()启动线程，线程X
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb1){  //加sb1锁后，向sb1对象加“A”字符串
                        sb1.append("A");
                        synchronized (sb2){  //加sb2锁后，向sb2对象加“B”字符串
                            sb2.append("B");
                            System.out.println(sb1);
                            System.out.println(sb2);
                        }
                    }
                }
            }.start();

            new Thread(){  //线程Y
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb2){ //加sb2锁后，向sb1对象加“C”字符串
                        sb1.append("C");
                        synchronized (sb1){ //加sb1锁后，向sb1对象加“D”字符串
                            sb2.append("D");
                            System.out.println(sb1);
                            System.out.println(sb2);
                        }
                    }
                }
            }.start();
        }else if(parm.equals("5")) {
            // 内存溢出
            List<UserTest> userlist=new ArrayList<>();
            while(true){
                userlist.add(new UserTest());
            }
        }

        System.out.println("End");
    }

    public static void readFile(){
        try {
            String encoding = "UTF-8";
            File file = new File("./test.txt");
            StringBuilder result = new StringBuilder();
            result.append("测试起始行.");
            // 判断文件是否存在
            if (file.isFile() && file.exists() && file.canRead()) {
                FileInputStream fiStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fiStream, encoding);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String text;
                while ((text = bufferedReader.readLine()) != null) {// 使用readLine方法，一次读一行
                    result.append(text + System.lineSeparator());
                }
                bufferedReader.close();
                inputStreamReader.close();
                fiStream.close();
            }

            System.out.println(result.toString());
            System.out.println("读取文件test done!");
        }catch (UnsupportedEncodingException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void writeFile(){
        Integer index = 1;
        while (true){
            try {
                File file = new File("./test.txt");
                //文件不存在时候，主动穿件文件。
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Hello World" + index.toString() + System.lineSeparator());
                bw.close();
                fw.close();
                System.out.println("写入文件test done!");
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            index ++;

            try {
                Thread.sleep(750);
            }catch (InterruptedException e){
                System.out.println(e.toString());
            }
        }
    }
}

class UserTest{
    public Integer id;
    public String name;
}
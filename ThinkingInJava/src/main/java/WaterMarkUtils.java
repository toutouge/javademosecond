/**
 * Created by toutou on 2018/8/28.
 */
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class WaterMarkUtils {
    //定义水印文字样式
    private static final String MARK_TEXT = "请叫我头头哥";
    private static final String FONT_NAME = "微软雅黑";
    private static final int FONT_STYLE = Font.BOLD;
    private static final int FONT_SIZE = 20;
    private static final Color FONT_COLOR = Color.gray;
    private static final String PATH = "D:\\Project\\H5\\Blog\\images";

    private static final float ALPHA = 0.3F;

    //添加多条文字水印
    public static String moreTextWaterMark(String myFile,String imageFileName) {
        InputStream is =null;
        OutputStream os =null;
        int X = 636;
        int Y = 763;

        File logossss = new File(myFile);

        try {
            Image image = ImageIO.read(logossss);
            //计算原始图片宽度长度
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            //创建图片缓存对象
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //创建java绘图工具对象
            Graphics2D graphics2d = bufferedImage.createGraphics();
            //参数主要是，原图，坐标，宽高
            graphics2d.drawImage(image, 0, 0, width, height, null);
            graphics2d.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
            graphics2d.setColor(FONT_COLOR);

            //使用绘图工具将水印绘制到图片上
            //计算文字水印宽高值
            int waterWidth = FONT_SIZE*getTextLength(MARK_TEXT);
            int waterHeight = FONT_SIZE;

            //水印透明设置
            graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));
            graphics2d.rotate(Math.toRadians(30), bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);

            int x = -width/2;
            int y = -height/2;

            while(x < width*1.5){
                y = -height/2;
                while(y < height*1.5){
                    graphics2d.drawString(MARK_TEXT, x, y);
                    y+=waterHeight+100;
                }
                x+=waterWidth+100;
            }
            graphics2d.dispose();

            os = new FileOutputStream(PATH+"/"+imageFileName);
            //创建图像编码工具类
            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
            //使用图像编码工具类，输出缓存图像到目标文件
            en.encode(bufferedImage);
            if(is!=null){
                is.close();
            }
            if(os!=null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    //计算水印文本长度
    //1、中文长度即文本长度 2、英文长度为文本长度二分之一
    public static int getTextLength(String text){
        //水印文字长度
        int length = text.length();

        for (int i = 0; i < text.length(); i++) {
            String s =String.valueOf(text.charAt(i));
            if (s.getBytes().length>1) {
                length++;
            }
        }
        length = length%2==0?length/2:length/2+1;
        return length;
    }

    public static void main(String[] args) {
        File file = new File(PATH);
        File[] tempList = file.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            // 文件
            if (tempList[i].isFile()) {
                String fileFullName = tempList[i].getName();
                // 获取文件名(不包含后缀名)
                String fileName = fileFullName.substring(0,fileFullName.lastIndexOf("."));
                // 获取后缀名
                String prefix = fileFullName.substring(fileFullName.lastIndexOf(".")+1);
                String newFileName = fileName + "." + prefix;
                System.out.println(fileFullName);
                System.out.println(newFileName);
                moreTextWaterMark(tempList[i].toString(),newFileName);
            }
            // 文件夹
            if (tempList[i].isDirectory()) {
            }
        }

        // e.g. moreTextWaterMark("原始文件路径","新生成的水印图片文件名");
        System.out.println("成功");
    }
}
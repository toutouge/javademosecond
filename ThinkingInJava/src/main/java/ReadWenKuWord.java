package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从html中读取需要的内容
 * @author toutou
 * @date by 2019/08
 */
public class ReadWenKuWord {
    public static void main(String[] args) {
        String source = stripHTML(readToString()).replaceAll("\n|&ensp;","");
        System.out.println(source);

    }

    public static String readToString() {
        // 存放爬取后的word文档内容文件的路径
        File directory = new File("");
        // String fileName = "D:\\Project\\H5\\Blog\\wenku.txt";
        String fileName = directory.getAbsolutePath() + "\\src\\main\\resources\\html\\wenku.txt";//绝对路径;
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            try {
                in.read(filecontent);
                return new String(filecontent, encoding);
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
            finally {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String stripHTML(String html) {
        String noHTMLString = "";
        html = html.replaceAll("&amp;", "&");
        Matcher m = Pattern
                .compile("&#(\\d+);", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL | Pattern.CANON_EQ)
                .matcher(html);
        boolean b = false;
        int i = 0;
        while (m.find()) {
            if (i > 500) {
                System.out.println(i);
            }
            i++;
            html = html.replace("&#" + m.group(1) + ";", (char) Integer.parseInt(m.group(1)) + "");
            b = true;
        }
        if (!b) {
            m = Pattern
                    .compile("&#x([\\da-f]+);",
                            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL | Pattern.CANON_EQ)
                    .matcher(html);
            int j = 0;
            while (m.find()) {
                if (j > 500) {
                    System.out.println(j);
                }
                j++;
                html = html.replaceAll("&#[x|X]" + m.group(1) + ";", (char) Integer.parseInt(m.group(1), 16) + "");
            }
        }
        noHTMLString = html.replaceAll("<\\s*(?:br|Br|BR|bR|div|DIV|Div|p|P|td|TD|Td)\\s*(?:[^>])*\\s*>", "\n")
                .replaceAll("　", " ").replaceAll("", " ").replaceAll("&nbsp;", " ").replaceAll("\\<.*?\\>", "")
                .replaceAll("&(?:g|l)t", "");
        return noHTMLString.trim();
    }
}

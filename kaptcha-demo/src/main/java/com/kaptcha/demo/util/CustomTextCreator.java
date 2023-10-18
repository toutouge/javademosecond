package com.kaptcha.demo.util;

import com.google.code.kaptcha.text.impl.DefaultTextCreator;

import java.util.Random;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
public class CustomTextCreator extends DefaultTextCreator {

    private static final String[] Number = "0,1,2,3,4,5,6,7,8,9,10".split(",");
    @Override
    public String getText()
    {
        int result;
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        StringBuilder suChinese = new StringBuilder();
        int randomOperand = (int) Math.round(Math.random() * 2);
        if (randomOperand == 0) {
            result = x * y;
            suChinese.append(Number[x]);
            suChinese.append("*");
            suChinese.append(Number[y]);
        } else if (randomOperand == 1) {
            if (!(x == 0) && y % x == 0) {
                result = y / x;
                suChinese.append(Number[y]);
                suChinese.append("/");
                suChinese.append(Number[x]);
            } else {
                result = x + y;
                suChinese.append(Number[x]);
                suChinese.append("+");
                suChinese.append(Number[y]);
            }
        } else if (randomOperand == 2) {
            if (x >= y) {
                result = x - y;
                suChinese.append(Number[x]);
                suChinese.append("-");
                suChinese.append(Number[y]);
            } else {
                result = y - x;
                suChinese.append(Number[y]);
                suChinese.append("-");
                suChinese.append(Number[x]);
            }
        } else {
            result = x + y;
            suChinese.append(Number[x]);
            suChinese.append("+");
            suChinese.append(Number[y]);
        }
        suChinese.append("=?@").append(result);
        return suChinese.toString();
    }
}

package com.kaptcha.demo.controller;

import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@RestController
@Slf4j
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    private Producer producer;

    public static final String DEFAULT_CODE_KEY = "random_code_";

    /**
     * @MethodName createCaptcha
     * @Description  生成验证码
     * @param httpServletResponse 响应流
     * @Author hl
     * @Date 2022/12/6 10:30
     */
    @GetMapping("/create")
    public void createCaptcha(HttpServletResponse httpServletResponse, HttpSession session) throws IOException {
        // 生成验证码
        String capText = producer.createText();
        String capStr = capText.substring(0, capText.lastIndexOf("@"));
        String result = capText.substring(capText.lastIndexOf("@") + 1);
        BufferedImage image = producer.createImage(capStr);
        // 保存验证码信息
        String randomStr = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("随机数为:" + randomStr);
        //redisTemplate.opsForValue().set(DEFAULT_CODE_KEY + randomStr, result, 3600, TimeUnit.SECONDS);
        session.setAttribute("kaptcha", result);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            log.error("ImageIO write err", e);
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        byte[] bytes = os.toByteArray();
        //设置响应头
        httpServletResponse.setHeader("Cache-Control", "no-store");
        //设置响应头
        httpServletResponse.setHeader("randomstr",randomStr);
        //设置响应头
        httpServletResponse.setHeader("Pragma", "no-cache");
        //在代理服务器端防止缓冲
        httpServletResponse.setDateHeader("Expires", 0);
        //设置响应内容类型
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(bytes);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
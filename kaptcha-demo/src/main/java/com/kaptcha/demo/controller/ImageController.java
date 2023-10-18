package com.kaptcha.demo.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class ImageController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
    public void getKaptcha(HttpServletResponse response, HttpSession session) {
        String text = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(text);
        // 线上环境这个验证码肯定是要存redis里的，redis的key还需要设置一个合理的过期时间
        session.setAttribute("kaptcha", text);
        response.setContentType("image/png");
        try {
            ServletOutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            log.error("响应验证码失败:" + e.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session,  String kaptcha) {
        if(kaptcha.equals(session.getAttribute("kaptcha"))){
            return kaptcha + "验证码正确";
        }else{
            return kaptcha + "验证码错误";
        }
    }
}
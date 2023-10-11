package com.demo.security.model.dto;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@Data
public class ImageCode {
    /**
     * image图片
     */
    private BufferedImage image;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    /**
     * 判断验证码是否已过期
     * @return
     */
    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}

package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

/**
 * 博客类
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
@Data
@Builder
public class Blog {
    private int id;
    private String content;
    private int tagId;
    private String author;
}
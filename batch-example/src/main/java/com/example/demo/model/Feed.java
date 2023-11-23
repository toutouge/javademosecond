package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
@Data
public class Feed {
    private int userId;
    private String userName;
    private String status;
    private List<Blog> blogList;
    private Integer viewCount;
    private Integer likeCount;
}

package com.batch.demo.model;

import lombok.Builder;
import lombok.Data;

/**
 * 用户类
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
@Data
@Builder
public class User {
    private int id;
    private String userName;
    private int sex;
    private String address;
}

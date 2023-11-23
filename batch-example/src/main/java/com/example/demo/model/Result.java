package com.example.demo.model;

import java.io.Serializable;
import java.util.Optional;

/**
 * 返回通用实体类
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
public class Result<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> setSuccessResult(T t){
        Result<T> r = new Result<T>();
        r.setCode(200);
        r.setData(t);
        r.setMessage("success");
        return r;
    }

    public static <T> Result<T> setErrorResult(int tempCode, String messageTemp){
        Result<T> r = new Result<T>();
        r.setCode(tempCode);
        r.setMessage(messageTemp);
        return r;
    }

    public static <T> T getSuccessResult(Result<T> resultValue,T defaultValue) {
        return Optional.ofNullable(resultValue).filter(p -> p.getCode() == 200).map(Result::getData).orElse(defaultValue);
    }
}

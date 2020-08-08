package com.toutou.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * @author toutou
 * @date by 2020/08
 * @des
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"status", "msg", "result"})
public class ResponseResult<T> implements Serializable {


    private int status;
    private String msg;
    private T result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static <T> ResponseResult<T> buildSuccessResult(T obj) {
        ResponseResult<T> rt = new ResponseResult<>();
        rt.setStatus(200);
        rt.setResult(obj);
        rt.setMsg("success");
        return rt;
    }

    public static <T> ResponseResult<T> buildErrorResult(int status, String msg) {
        ResponseResult<T> rt = new ResponseResult<>();
        rt.setStatus(status);
        rt.setMsg(msg);
        return rt;
    }

    public static <T> ResponseResult<T> buildCustomResult(int status, String msg, T obj) {
        ResponseResult<T> rt = new ResponseResult<>();
        rt.setStatus(status);
        rt.setMsg(msg);
        rt.setResult(obj);
        return rt;
    }

    public ResponseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public ResponseResult() {
    }
}
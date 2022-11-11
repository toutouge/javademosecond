package com.test.model;

import lombok.Data;

/**
 * @Author chen bo
 * @Date 2022/11/9
 * @Des
 */
@Data
public class ResResult<T> {
    /**
     * 1.status状态值：代表本次请求response的状态结果。
     */
    private Integer status;
    /**
     * 2.response描述：对本次状态码的描述。
     */
    private String desc;
    /**
     * 3.data数据：本次返回的数据。
     */
    private T data;

    /**
     * 成功，创建ResResult：有data数据
     */
    public static <T> ResResult<T> success(T obj) {
        ResResult<T> r = new ResResult<>();
        r.setStatus(0);
        r.setData(obj);
        r.setDesc("success");
        return r;
    }

    /**
     * 成功，创建ResResult：没data数据
     */
    public static <T> ResResult<T> success() {
        ResResult<T> r = new ResResult<>();
        r.setStatus(0);
        r.setDesc("success");
        return r;
    }

    /**
     * 失败，指定status、desc
     */
    public static <T> ResResult<T> fail(Integer status, String desc) {
        ResResult<T> r = new ResResult<>();
        r.setStatus(status);
        r.setDesc(desc);
        return r;
    }
}
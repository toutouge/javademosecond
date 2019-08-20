package learn.model.vo;

import java.io.Serializable;

/**
 * @author toutou
 * @date by 2019/07
 */
public class Result<T> implements Serializable {

    public int code;
    public String message;
    public T data;

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
}

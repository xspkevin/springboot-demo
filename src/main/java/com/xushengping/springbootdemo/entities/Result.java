package com.xushengping.springbootdemo.entities;

import java.io.Serializable;

public class Result<T> implements Serializable {

    public static final int OK = 200;

    public Result() {

    }

    protected int code;

    protected String message;

    protected Long timestamp;

    protected T data;



    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }


    public Result<T> code(int code) {
        this.code = code;
        return this;
    }

    public Result<T> message(String message) {
        this.message = message;
        return this;
    }

    private Result<T> putTimestamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }



    public static <T> Result<T> OK() {
        return Result.OK(null);
    }

    /**
     * 执行成功，返回对象。
     *
     * @param <T>
     * @param data
     * @return
     */
    public static <T> Result<T> OK(T data) {
        return Result.OK("执行成功！", data);
    }

    /**
     * 执行成功，返回对象。
     *
     * @param <T>
     * @param message
     * @param data
     * @return
     */
    public static<T> Result<T> OK(String message, T data) {
        return new Result<T>().
                code(200).
                message(message).
                putTimestamp().
                data(data);
    }

    /**
     * 执行失败，返回对象。
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> Fail(int code, String message) {
        return new Result<T>()
                .code(code)
                .message(message)
                .putTimestamp()
                .data(null);
    }

    /**
     * 执行失败，返回对象。
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> Fail(int code, String message,T data) {
        return new Result<T>()
                .code(code)
                .message(message)
                .putTimestamp()
                .data(data);
    }



    /**
     * 执行错误，返回对象
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> Error(int code, String message) {
        return new Result<T>()
                .code(code)
                .message(message)
                .putTimestamp()
                .data(null);
    }
}

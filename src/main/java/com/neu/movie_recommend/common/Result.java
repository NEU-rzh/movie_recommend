package com.neu.movie_recommend.common;
/**
 * 返回Result类，可以对返回的code、msg、data进行封装
 */
public class Result<T> {
    /**
     * 返回状态码
     */
    private String code;
    /**
     * 返回提示信息
     */
    private String msg;
    /**
     * 返回封装对象中所存数据
     */
    private T data;
    /**
     * 对一个Result类对象获得状态码
     */
    public String getCode() {
        return code;
    }
    /**
     * 对一个Result类对象设置状态码
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * 对一个Result类对象获得信息
     */
    public String getMsg() {
        return msg;
    }
    /**
     * 对一个Result类对象设置状态码
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    /**
     * 对一个Result类对象获得封装数据
     */
    public T getData() {
        return data;
    }
    /**
     * 对一个Result类对象设置状态码
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * 对一个Result类构造函数
     */
    public Result() {
    }
    /**
     * 对一个Result类构造函数给出初始封装数据
     */
    public Result(T data) {
        this.data = data;
    }
    /**
     * 对一个Result类成功的方法
     */
    public static Result success() {
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }
    /**
     * 对一个Result类成功的方法并初始数据
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }
    /**
     * 返回一个Result类失败方法并初始失败状态码和消息
     */
    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
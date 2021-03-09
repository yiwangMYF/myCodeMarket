package cn.utils;

import cn.common.Constant;
import cn.enums.ResponseCode;

import java.io.Serializable;

/**
 * @Description 返回数据封装工具
 * @Author myf
 * @CreateDate 2020/11/10 10:38
 * @Version 1.0
 **/
public class ResponseUtil<T> implements Serializable{
    /**
     * 响应码，默认0为失败，1为成功
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private  T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    /**
     * 请求失败，自定义失败消息
     * @param message
     */
    public  void resFail(String message){
        this.code= Constant.REQUEST_FAIL;
        this.message=message;
    }

    /**
     * 请求失败，默认失败消息
     */
    public void resFail(){
        this.code= ResponseCode.REQUEST_FAIL.getCode();
        this.message=ResponseCode.REQUEST_FAIL.getMessage();
    }

    /**
     * 请求成功，自定义返回消息
     * @param message
     */
    public void resSuccess(String message){
        this.code=Constant.REQUEST_SUCCESS;
        this.message=message;

    }

    /**
     * 请求成功，默认返回消息
     *
     */
    public void resSuccess(){
        this.code=ResponseCode.REQUEST_SUCCESS.getCode();
        this.message=ResponseCode.REQUEST_SUCCESS.getMessage();
    }


}

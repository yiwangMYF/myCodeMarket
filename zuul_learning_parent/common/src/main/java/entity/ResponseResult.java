package entity;

import lombok.Data;

/**
 * @Description 返回结果封装类
 * @Author myf
 * @CreateDate 2021/1/19 15:54
 * @Version 1.0
 **/
@Data
public class ResponseResult<T> {

    private String code;

    private String message;

    private T data;


    public void setSuccess(T data){
        this.code="01";
        this.message="请求成功";
        this.data=data;
    }

    public void setFail(String message){
        this.code="00";
        this.message=message;
    }
}

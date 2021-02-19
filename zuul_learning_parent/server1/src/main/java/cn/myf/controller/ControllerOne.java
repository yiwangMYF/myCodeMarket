package cn.myf.controller;

import entity.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author myf
 * @CreateDate 2021/1/19 15:30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/")
public class ControllerOne {
    @RequestMapping("/test")
    public ResponseResult test1(){
        ResponseResult<Object> result = new ResponseResult<>();
        result.setSuccess("I am Server1");
        return result;
    }

}

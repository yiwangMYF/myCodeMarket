package cn.myf.controller;

import entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author myf
 * @CreateDate 2021/1/19 15:30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/")
@Slf4j
public class ControllerOne {
    @RequestMapping("/test")
    public ResponseResult test1() throws InterruptedException {
        Thread.sleep(1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("server time:{}",format.format(new Date()));
        ResponseResult<Object> result = new ResponseResult<>();
        result.setSuccess("I am Server2");
        return result;
    }

}

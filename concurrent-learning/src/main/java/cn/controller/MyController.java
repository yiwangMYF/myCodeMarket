package cn.controller;

import cn.domain.User;
import cn.excutors.Result;
import cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/12/8 9:46
 * @Version 1.0
 **/
@RestController
public class MyController extends BaseController{
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/{id}")
    public Result test(@PathVariable("id") String id){
        result.setCode("00");
        result.setMessage("请求成功!");
        User user = userMapper.findById(id);
        result.setData(user);

        return result;

    }
}

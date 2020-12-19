package cn.controller;

import cn.domain.User;
import cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/12/8 9:46
 * @Version 1.0
 **/
@RestController
public class MyController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/{id}")
    public User test(@PathVariable("id") String id){
        return userMapper.findById(id);

    }
}

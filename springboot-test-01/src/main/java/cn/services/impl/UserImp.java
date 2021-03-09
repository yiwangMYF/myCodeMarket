package cn.services.impl;

import cn.entity.User;
import cn.mapper.UserMapper;
import cn.services.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/9 19:57
 * @Version 1.0
 **/
@Service
public class UserImp implements IUser {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}

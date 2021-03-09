package cn.services;

import cn.entity.User;

/**
 * @Description 用户接口
 * @Author myf
 * @CreateDate 2020/11/9 19:56
 * @Version 1.0
 **/
public interface IUser {
    /**
     * 根据用户名查找用户信息
     * @param name
     * @return
     */
    public User getUserByName(String name);
}

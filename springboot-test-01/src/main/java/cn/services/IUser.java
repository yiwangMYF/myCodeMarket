package cn.services;

import cn.entity.User;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description 用户接口
 * @Author myf
 * @CreateDate 2020/11/9 19:56
 * @Version 1.0
 **/
public interface IUser {
    /**
     * 根据用户名查找用户信息
     *
     * @param name
     * @return
     */
    User getUserByName(String name);

    /**
     * 新增用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 导出用户信息
     * @param response
     */
    void export(HttpServletResponse response);
}

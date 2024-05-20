package cn.controller;

import cn.entity.User;
import cn.services.IUser;
import cn.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 用户管理
 *
 * @Description
 * @Author myf
 * @CreateDate 2020/11/10 10:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUser userService;

    /**
     * 根据名称查询用户信息
     *
     * @param name
     * @return
     */
    @RequestMapping("/getUser/{name}")
    public ResponseUtil<User> getUserInfoByName(@PathVariable String name) {
        ResponseUtil<User> responseUtil = new ResponseUtil<>();
        User user = userService.getUserByName(name);
        if (Objects.isNull(user)) {
            responseUtil.resFail("没有指定名称的用户！");
            return responseUtil;
        }
        responseUtil.resSuccess();
        responseUtil.setData(null);
        return responseUtil;
    }
}

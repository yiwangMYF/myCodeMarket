package cn.controller;

import cn.entity.User;
import cn.services.IUser;
import cn.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/10 10:36
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUser userService;

    @ResponseBody
    @RequestMapping("/getUser/{name}")
    public ResponseUtil<User> getUserInfoByName(@PathVariable String name){
        ResponseUtil<User> responseUtil = new ResponseUtil<>();
        User user = userService.getUserByName(name);
        if (user==null) {
            responseUtil.resFail("没有指定名称的用户！");
            return responseUtil;
        }
        int a=2/0;
        responseUtil.resSuccess();
        responseUtil.setData(null);
        return responseUtil;
    }
}

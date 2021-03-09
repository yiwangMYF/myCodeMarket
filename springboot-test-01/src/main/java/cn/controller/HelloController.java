package cn.controller;

import cn.bo.Bean3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/7 10:57
 * @Version 1.0
 **/
@Controller
public class HelloController {
    @Value("${name}")
    private String name;
    @Autowired
    private Bean3 bean3;
    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam(value = "name",defaultValue = "myf") String name, HttpServletRequest request){
        System.out.println("1");
        HttpSession session = request.getSession();
        System.out.println("session id:"+session.getId());
        return bean3.getName()+"已经"+bean3.getAge()+"岁了";

    }
}

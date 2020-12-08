package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/12 10:31
 * @Version 1.0
 **/
@Controller
public class MyController {
    @RequestMapping("/hello")
    @ResponseBody
    public String getInfo(){
        return "hello badwomen";
    }
}

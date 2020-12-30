package cn.myf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/12/29 17:04
 * @Version 1.0
 **/
@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}

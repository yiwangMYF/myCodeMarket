package cn.myf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description 微信公众号
 * @Author myf
 * @CreateDate 2021/1/5 18:38
 * @Version 1.0
 **/
@SpringBootApplication
@EnableAspectJAutoProxy
public class WxPublicApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxPublicApplication.class,args);
    }
}

package cn.myf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description 测试服务2，用于zuul网关转发
 * @Author myf
 * @CreateDate 2021/1/19 15:28
 * @Version 1.0
 **/
@SpringBootApplication
public class ServerTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerTwoApplication.class,args);
    }
}

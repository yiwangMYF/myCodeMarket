package cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/7 10:53
 * @Version 1.0
 **/
@SpringBootApplication
@EnableCaching
@MapperScan("cn.mapper")
// @EnableJms
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);

    }
}

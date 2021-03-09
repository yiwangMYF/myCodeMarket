package cn.bo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/7 13:44
 * @Version 1.0
 **/
@Component
public class Bean2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("================applicationrunner========================");
    }
}

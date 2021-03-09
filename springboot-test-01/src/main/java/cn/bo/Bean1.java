package cn.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/7 13:43
 * @Version 1.0
 **/
@Component
public class Bean1 implements CommandLineRunner,ExitCodeGenerator{

    @Autowired
    private ApplicationArguments applicationArguments;

    /**
     * 应用启动后执行，效果与ApplicationRunner一样，但是ApplicationRunner接口在该接口之前执行，
     * 同一接口多个实现类的执行顺序
     * 使用@Order指定
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("===========commandlinerunner====================");
      /*  OhMyEmail.config(OhMyEmail.SMTP_QQ(true),"1922736567@qq.com","lxmbplmpkargbdcg");
        OhMyEmail.subject("应用启动通知")
                .from("springboot-test-01")
                .to("1922736567@qq.com")
                .text("我启动了-_-!,抱歉，垃圾邮件！")
                .send();*/
    }

    /**
     * SpringApplication.exit()执行时返回一个退出码
     * @return
     */
    @Override
    public int getExitCode() {
        return 99999;
    }
}

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/7 10:53
 * @Version 1.0
 **/
@SpringBootApplication
@ComponentScan("cn.*")
@EnableCaching
@MapperScan("cn.mapper")
@EnableJms
public class MyApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyApplication.class, args);
/*
        Thread.sleep(1000);
        System.exit(SpringApplication.exit(applicationContext));*/

    }
}

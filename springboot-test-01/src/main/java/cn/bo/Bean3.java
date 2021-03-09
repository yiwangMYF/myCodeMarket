package cn.bo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/7 14:40
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "person")
@Component
public class Bean3{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

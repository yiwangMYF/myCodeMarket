package cn.config;

import cn.excutors.RequestListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/12/8 10:08
 * @Version 1.0
 **/
@Configuration
public class MyConfiguration {
    /**
     * 注册监听器，因为使用@WebLister注解没有效果，于是使用springboot的ServletListenerRegistrationBean来注册监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean registeLister(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new RequestListener());
        return servletListenerRegistrationBean;
    }
}

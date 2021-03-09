package cn.config;

import cn.bo.MyHttpSessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSessionListener;

/**
 * @Description 配置cors（跨域资源共享）和httpsession监听器
 * @Author myf
 * @CreateDate 2020/11/9 11:34
 * @Version 1.0
 **/
@Configuration
public class MyConfiguration {
    @Bean
    public WebMvcConfigurer corsConfig(){
        return  new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**");
            }
        };
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> sessionListerRegister(){
        ServletListenerRegistrationBean<HttpSessionListener> httpSessionListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        httpSessionListenerServletListenerRegistrationBean.setListener(new MyHttpSessionListener());
        return httpSessionListenerServletListenerRegistrationBean;
    }

 /*  @Bean
    public MessageConverter jacksonJmsConverter(){
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdPropertyName("_type");
        return mappingJackson2MessageConverter;
    }*/
/*
    @Bean("myFactory")
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory,connectionFactory);
        return factory;
    }*/


}

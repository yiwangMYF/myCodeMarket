package cn.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description aop 实现controller层执行日志
 * @Author myf
 * @CreateDate 2020/11/10 8:40
 * @Version 1.0
 **/
@Aspect
@Component
public class LogAspect {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Autowired
    private JmsTemplate jmsTemplate;



    @Around("execution(* cn.controller..*.*(..))")
    public Object printServiceLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        logger.info("请求方法：{}",className+"."+methodName);
        Object[] args = proceedingJoinPoint.getArgs();
        logger.info("请求参数：");
        Arrays.stream(args).forEach(arg->{
            logger.info(arg+";");
        });

        Object proceed = proceedingJoinPoint.proceed();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(proceed);
        logger.info("结果：{}", s);

        jmsTemplate.convertAndSend("receiver",s);
        return proceed;
    }

    /*    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setId("asda");
        user.setName("sadsad");
        System.out.println(new ObjectMapper().writeValueAsString(user));
    }*/
}

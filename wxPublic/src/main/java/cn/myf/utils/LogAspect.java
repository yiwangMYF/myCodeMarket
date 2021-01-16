package cn.myf.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description 日志切面
 * @Author myf
 * @CreateDate 2021/1/6 9:14
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Around("execution(* cn.myf.controller..*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("---------------------类名为:{},方法名为:{} 开始执行------------",className,methodName);
        log.info("方法参数:{}", Arrays.toString(proceedingJoinPoint.getArgs()));
        Object proceed = proceedingJoinPoint.proceed();
        if (proceed!=null) {
            log.info("返回结果：{}",proceed.toString());
        }
        log.info("---------------------类名为:{},方法名为:{} 执行结束------------",className,methodName);
        return proceed;


    }
}

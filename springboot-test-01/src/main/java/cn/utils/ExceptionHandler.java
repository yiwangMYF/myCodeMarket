package cn.utils;

import io.github.biezhi.ome.OhMyEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 异常处理器,拦截处理器,发现异常返回错误页面
 * @Author myf
 * @CreateDate 2020/11/11 11:06
 * @Version 1.0
 **/
@ControllerAdvice
public class ExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    private ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(()->{
        return new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    });

    static {
        OhMyEmail.config(OhMyEmail.SMTP_QQ(false),"1922736567@qq.com","lxmbplmpkargbdcg");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandle(HttpServletRequest request,Exception e) throws MessagingException {
        logger.error("===================系统发生异常===============:",e);
        String requestURI = request.getRequestURI();
        StringBuilder content = new StringBuilder();
        content.append("请求地址："+requestURI+"\n")
                .append("请求时间："+threadLocal.get().format(new Date())+"\n")
                .append("异常信息："+getStatckTrace(e));


        //发送异常信息到指定邮箱
        OhMyEmail.subject("springboot-test-01 系统发生异常")
                .from("springboot-test-01")
                .to("1922736567@qq.com")
                .text(content.toString())
                .send();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/error.html");
        return modelAndView;
    }

    public static String getStatckTrace(Throwable e){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}

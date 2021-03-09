package cn.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;
import java.util.Iterator;


/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/9 11:42
 * @Version 1.0
 **/
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private static Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    {
        System.out.println("监听器实例化");
    }

    


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        logger.info("==============session 创建================");
        logger.info(attributeNames.toString());
        while (attributeNames.hasMoreElements()) {
                logger.info("session info：{}====",attributeNames.nextElement());
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("session destroyed!");

    }
}

package cn.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description 消息接收者
 * @Author myf
 * @CreateDate 2020/11/11 9:45
 * @Version 1.0
 **/
@Component
public class Receiver {

    private static Logger logger = LoggerFactory.getLogger(Receiver.class);


    @JmsListener(destination = "receiver")
    public void receiveMessage(String s) {
        logger.info("=====================接收到信息===============");
        logger.info("the message:{}",s);


    }
}

package cn.myf.controller;

import cn.myf.entity.TextMessage;
import cn.myf.utils.CheckUtil;
import cn.myf.utils.HttpClientUtil;
import cn.myf.utils.XmlUtils;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * @Description 微信服务器消息转发接口
 * @Author myf
 * @CreateDate 2021/1/5 18:49
 * @Version 1.0
 **/
@Controller
@Slf4j
public class DispatcherController {
    /**
     * 免费机器人接口
     */
    private static final String REQESTURL = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";
    /**
     *  用于微信服务器验证接口的有效性
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/dispatcherGet",method = RequestMethod.GET
    )
    @ResponseBody
    public String disPatcherGet(String signature,String timestamp,String nonce,String echostr){
        if(!CheckUtil.checkSignature(signature,timestamp,nonce)) {
            return null;
        }
        return echostr;
    }

    /**
     * 接收微信推送过来的信息，当前仅支持text类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/dispatcherGet",method = RequestMethod.POST)
    public void disPatcherGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> map = XmlUtils.parseXml(request);
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        if (!"text".equals(map.get("MsgType"))) {
            writer.print("亲,本店不支持当前数据类型哦！");
            return;
        }

        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");

        String content = map.get("Content");
        String returnMsg = HttpClientUtil.doGet(REQESTURL + content);
        log.info("---------智能机器人返回数据：{}",returnMsg);

        JSONObject jsonObject = JSONObject.parseObject(returnMsg);


        TextMessage textMessage = new TextMessage();
        textMessage.setContent(jsonObject.getString("content"));
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setFromUserName(toUserName);
        textMessage.setToUserName(fromUserName);
        textMessage.setMsgType("text");

        String s = XmlUtils.messageToXml(textMessage);
        log.info("---------返回微信平台报文：\n{}",s);
        writer.write(s);


    }


}

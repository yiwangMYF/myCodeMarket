package cn.myf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * @Description
 * @Author myf
 * @CreateDate 2021/1/20 16:14
 * @Version 1.0
 **/
@Component
@Slf4j
public class Error extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        Enumeration<String> attributeNames = request.getAttributeNames();
        log.info("---------------------------------------------------------------------");
       /* while (attributeNames.hasMoreElements()){
            log.info("属性：{};值：{}",attributeNames.nextElement(),request.getAttribute(attributeNames.nextElement()));
        }*/
        log.info("error:{}",format.format(new Date()));
        log.info("---------------------------------------------------------------------");
        return null;
    }
}

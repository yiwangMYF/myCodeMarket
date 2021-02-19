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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 测试过滤器
 * @Author myf
 * @CreateDate 2021/1/20 15:47
 * @Version 1.0
 **/
@Component
@Slf4j
public class FilterOne extends ZuulFilter{
    private static AtomicInteger count = new AtomicInteger(0);
    /**
     * 指定过滤器的类型，zuul过滤器公有4种：pre、route、post、error
     * pre:路由前进行拦截
     * route：路由请求时拦截
     * post:路由后（完成服务调用）进行拦截
     * error：用于错误处理
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
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
            Thread.sleep(1000);
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
        log.info("pre:{}",format.format(new Date()));
        log.info("---------------------------------------------------------------------");
        count.getAndAdd(1);
        log.info("访问总数:{}",count.get());
        return null;
    }
}

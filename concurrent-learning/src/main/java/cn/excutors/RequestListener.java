package cn.excutors;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.*;

/**
 * @Description 请求监听器，监听到请求后额外执行任务（不返回前端）
 * @Author myf
 * @CreateDate 2020/12/7 17:22
 * @Version 1.0
 **/
public class RequestListener implements ServletRequestListener {
    static {
        System.out.println("-------我被加载了---------");
    }

    private static final ExecutorService threadPool =
            new ThreadPoolExecutor(1,1,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>(20), new ThreadPoolExecutor.AbortPolicy());

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {


    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest servletRequest = sre.getServletRequest();
        Task task = new Task(servletRequest);
        Future<Result> resultFuture = threadPool.submit(task);
        Result result=new Result();
        try {
             result= resultFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("--------执行结果---------->"+result.toString());
    }
}

package cn.excutors;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Description 要执行的任务
 * @Author myf
 * @CreateDate 2020/12/7 16:33
 * @Version 1.0
 **/
public class Task implements Callable<Result>{

    private ServletRequest request;

    public Task(ServletRequest request){
        this.request = request;

    }
    @Override
    public Result call() throws Exception {
        System.out.println("-------执行任务--------");
        System.out.println(
                "当前线程："+Thread.currentThread().getName()+" 时间："+new Date().toString()
        );

        Result result=new Result();
        result.setCode("1");
        result.setMessage("成功！");
        List<String> data=new ArrayList<>(2);
        data.add(this.request.getRemoteHost());
        result.setData(data);
        return result;
    }
}

package cn.excutors;

import java.util.concurrent.*;

/**
 * @Description 测试CountDownLatch的使用和线程池饱和策略
 * @Author myf
 * @CreateDate 2020/12/8 15:13
 * @Version 1.0
 **/
public class CountDownLatchTest {

    private static final ExecutorService threadPool =
            new ThreadPoolExecutor(1,1,1,
                    TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>(10),
                    new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {

        CountDownLatch cdl=new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            final int j=i;
            threadPool.execute(()->{
                String threadName = Thread.currentThread().getName();
                System.out.println("---------当前执行线程的名称："+threadName);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cdl.countDown();
            });
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------finished--------------");

    }
}

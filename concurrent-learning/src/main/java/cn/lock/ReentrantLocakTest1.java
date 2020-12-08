package cn.lock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 测试reentrantLock
 * @Author myf
 * @CreateDate 2020/12/3 9:50
 * @Version 1.0
 **/
public class ReentrantLocakTest1 {
    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();
    private static  int k=10;
    private static AtomicInteger finishedCount= new AtomicInteger(0);

    public static void main(String[] args) {
        final Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("-------------------当前线程名："+Thread.currentThread().getName());

                //每个线程运行先阻塞随机时间
                try {
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------------------"+Thread.currentThread().getName()+" K值1："+k);
                lock.lock();
                try{
                    System.out.println("-------------------"+Thread.currentThread().getName()+" K值2："+k);
                    if (k<=0){
                        System.out.println("--------"+Thread.currentThread().getName()+"哎呀，没次数了---------");
                        condition.await();
                    }
                    k--;
                    System.out.println("-------------------"+Thread.currentThread().getName()+" K值3："+k);
                    Thread.sleep(random.nextInt(500));
                    finishedCount.addAndGet(1);
                    System.out.println("-------------------"+Thread.currentThread().getName()+" finished--------------");
                }catch (Exception e){
                    System.out.println(e);

                }finally {
                   /* k++;
                    condition.signalAll();*/

                    lock.unlock();
                    System.out.println("-----------------------完成数目："+finishedCount.get());

                }

            });
            thread.start();

        }


    }
}

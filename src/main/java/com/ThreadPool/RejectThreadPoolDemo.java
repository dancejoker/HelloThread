package com.ThreadPool;

import java.util.concurrent.*;

/**
 * Created by ddp on 2017/8/28.
 */
public class RejectThreadPoolDemo {
        public static class MyTask implements Runnable{
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis() + ":Thread ID : " + Thread.currentThread().getId());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        //参数1;制定了线程中的线程数量
        //参数2:指定了线程池中的最大线程数
        //参数3:当线程池线程数量超过corePoolSize时，多余的空闲线程的存活时间
        //参数4:参数3的单位
        //参数5:任务队列，被提交但尚未被执行的任务
        //参数6:线程工厂，用于创建线程，一般用默认的即可
        //参数7:拒绝策略。当任务太多，如何拒绝任务
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(10), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + " is discard");
            }
        });
        for(int i = 0 ; i < Integer.MAX_VALUE; ++i){
            threadPoolExecutor.submit(myTask);
            Thread.sleep(10);
        }
    }
}

package com.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * P99
 * newFixedThreadPool()固定线程池中的线程数量
 *
 * Created by ddp on 2017/8/27.
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ": Thread ID: " +  Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
//        ExecutorService es = Executors.newFixedThreadPool(5);  //确定线程池中有5个线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  //返回一个根据实际情况调整数量的线程池
        for(int i = 0; i < 10; i++)
//            es.submit(myTask);
            cachedThreadPool.submit(myTask);
    }

}

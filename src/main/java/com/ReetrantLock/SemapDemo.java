package com.ReetrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 允许多线程访问临界区
 * Created by ddp on 2017/8/24.
 */
public class SemapDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);
    public static int i = 20;
    @Override
    public void run() {
        try {
            semp.acquire();
            --i;
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ": done ! and  i = " +i);
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        SemapDemo semapDemo = new SemapDemo();
        for(int i = 0; i < 20; ++i)
            executorService.submit(semapDemo);
        executorService.shutdown();
    }
}

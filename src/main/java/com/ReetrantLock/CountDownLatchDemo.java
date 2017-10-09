package com.ReetrantLock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch(倒计时器)
 * 功能：控制线程等待，它可以让某一个线程等待直到倒计时结束，再执行
 * Created by ddp on 2017/8/24.
 */
public class CountDownLatchDemo implements Runnable {
    //表示需要10个线程完成任务，等待在CountDownLatch上的线程完成任务,等待在CountDownLatch上的线程才能继续执行
    public static CountDownLatch end = new CountDownLatch(10);
    public static CountDownLatchDemo demo = new CountDownLatchDemo();
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
            end.countDown();  //通知CountDownLatch，一个线程已经完成了任务，倒计时器可以减一
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i = 0;i < 10; ++i){
            exec.submit(demo);
        }
        end.await();  //要求主线程等待所有10个检查任务全部完成，完成后才可以执行主线程
        System.out.println("Fire !");
        exec.shutdown();
    }
}

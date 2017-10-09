package com.ReetrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁ReetrantLock的简单应用
 * Created by ddp on 2017/8/17.
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public  int i = 0;
    @Override
    public void run() {
        for(int j = 0; j < 10000000;j++){
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(reenterLock.i);
    }
}

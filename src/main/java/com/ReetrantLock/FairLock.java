package com.ReetrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ddp on 2017/8/24.
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairlock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try {
                fairlock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                fairlock.unlock();
            }


        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock, "Thread_t1");
        Thread t2 = new Thread(fairLock, "Thread_t2");
        t1.start();
        t2.start();
    }
}

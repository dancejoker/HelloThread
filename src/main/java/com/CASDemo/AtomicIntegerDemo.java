package com.CASDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS具有非阻塞性，它对死锁问题天生免疫，并且，线程之间的相互影响
 * 也远远比基于锁的方式小。更重要的是，使用无锁的方式没有锁竞争带来
 * 的系统开销，也没有锁竞争带来的系统开销，也没有线程间频繁调度带来的
 * 开销 P159
 * Created by ddp on 2017/9/8.
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for(int k = 0;k < 10000; ++k){
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int k = 0;k < 10;k++){
            threads[k] = new Thread(new AddThread());
        }
        for(int k = 0;k < 10;k++) threads[k].start();
        for(int k = 0;k < 10;k++) threads[k].join();
        System.out.println(i);
    }

}

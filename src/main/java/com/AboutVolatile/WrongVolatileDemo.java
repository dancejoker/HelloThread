package com.AboutVolatile;

/**
 * 2个线程同时对i进行累加操作，各执行10000000次，我们希望的结果是i为20000000，
 * 实际结果多半是小于20000000
 * 原因：两个线程同时对i进行写入时，其中一个线程的结果会覆盖另外一个
 * eg：线程1和线程2同时读取i为0，并各自计算得到i=1,并先后写入这个结果，因此
 * 虽然i++被执行了2次，但实际i的值只增加了1
 * Created by ddp on 2017/8/17.
 */
public class WrongVolatileDemo implements Runnable {
    static WrongVolatileDemo instance = new WrongVolatileDemo();
    static volatile int i = 0;

    public static void increase(){
        ++i;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000000; ++i) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

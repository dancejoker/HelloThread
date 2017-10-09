package com.BadUseSynchronized;

/**
 * 错误：i小于10000000
 * 原因：由于存在多个线程间，并不一定能够看到同一个i对象(因为++i是赋值操作，有2个对象)
 * 2个线程加锁每次加锁可能加在不同的对象实例上，从而导致对临界区代码控制出现问题。
 * 修改方法：synchronized (i)改为synchronized (example)
 * Created by ddp on 2017/8/17.
 */
public class BadLockOnInteger implements Runnable {
    public static Integer i = 0;
 //   static BadLockOnInteger example = new BadLockOnInteger();

    @Override
    public void run() {
        for(int j = 0 ; j < 10000000; j++){
            synchronized (i){
                /**
                 * Integer属于不变对象，也就是对象一旦被创建，就不可能被修改。
                 */
                ++i;  //等价于i = Integer.valueOf(i.intValue()+1),其本质就是创建一个新的Integer对象，并将它的引用赋值给i
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BadLockOnInteger example = new BadLockOnInteger();
        Thread t2 = new Thread(example);
        Thread t4 = new Thread(example);
        t2.start();
        t4.start();
        t2.join();
        t4.join();
        System.out.println(i);
    }
}

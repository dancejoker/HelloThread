package com.AboutArrayList;

import java.util.ArrayList;

/**
 * ArrayList并不是线程安全的
 * 错误：
 * 1.程序抛出异常
 * 原因：ArrayList在扩容过程中，内容一致性被破坏，但由于没有锁保护，另外一个线程访问到了不一致的内部状态，
 * 导致出现越界问题
 * 2.一个隐蔽错误，输出的值小于200000
 * 原因：这是由于多线程访问冲突，使得保存容器大小的变量被多线程不正常的访问，同时两个线程也同时对ArrayList中的同一
 * 个位置进行赋值导致的。
 * 解决方法：
 * 使用线程安全的Vector替代ArrayList
 * Created by ddp on 2017/8/17.
 */
public class ArrayListMultiThread {
    static ArrayList<Integer> al = new ArrayList<Integer>();
    public static class AddNumber implements Runnable{
        @Override
        public void run() {
            for(int i = 0 ;i < 100000;++i){
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddNumber());
        Thread t2 = new Thread(new AddNumber());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());

    }
}

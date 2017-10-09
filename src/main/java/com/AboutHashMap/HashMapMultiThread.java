package com.AboutHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.一个隐蔽错误，输出的值小于100000
 * 原因：这是由于多线程访问冲突，使得保存容器大小的变量被多线程不正常的访问，同时两个线程也同时对ArrayList中的同一
 * 个位置进行赋值导致的。
 * 2.死循环
 * 原因：由于多线程的冲突，HashMap中的链表的结构已经遭到了破坏。
 * 当链表坏的时候，迭代链表就相当于一个死循环，next遍历就会出现死循环
 * 不过在JDK8中对HashMap进行了改进，规避了这个问题
 * 解决方法：使用ConcurrentHashMap代替HashMap
 * Created by ddp on 2017/8/17.
 */
public class HashMapMultiThread {
    static Map<String,String> map = new HashMap<String, String>();
    public static class AddThread implements Runnable{
        int start = 0;
        public AddThread(int start){
            this.start = start;
        }
        @Override
        public void run() {
            for(int i = start; i < 100000; i += 2){
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread(0));
        Thread t2 = new Thread(new AddThread(1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

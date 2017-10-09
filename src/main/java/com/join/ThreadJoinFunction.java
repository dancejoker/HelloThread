package com.join;

/**
 * 如果不使用join等待AddThread，那么得到的i很可能是0或者很小，因为addThread还没开始执行
 * System就已经输出了，但在使用join(),表示主线程愿意等待AddThread执行完毕，再进行System输出
 * Created by ddp on 2017/8/16.
 */
public class ThreadJoinFunction {
    public volatile static int i = 0;
    public static class AddThread extends  Thread{
        @Override
        public void run() {
            for(int i = 0 ; i < 1000000; ++i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join();
        System.out.println(i);
    }
}

package com.priority;

/**
 * 设置高优先级的线程通常会比设置为低优先级的线程容易抢到运行权
 * Created by ddp on 2017/8/17.
 */
public class PriortyThread {
    public  class HighPriorty extends Thread{
        int count = 0;
        @Override
        public void run() {
            while(true){
                synchronized (PriortyThread.class){
                    count++;
                    if(count > 10000000){
                        System.out.println("HighPriorty is complete");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriorty extends Thread{
        static int count = 0;
        @Override
        public void run() {
            while(true){
                synchronized (PriortyThread.class){
                    count++;
                    if(count > 10000000){
                        System.out.println("LowPriorty is complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PriortyThread priortyThread = new PriortyThread();
        HighPriorty highPriorty = priortyThread.new HighPriorty();
        LowPriorty lowPriorty = new LowPriorty();
        highPriorty.setPriority(Thread.MAX_PRIORITY);
        lowPriorty.setPriority(Thread.MIN_PRIORITY);
        lowPriorty.start();
        highPriorty.start();
    }
}

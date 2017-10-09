package com.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**P100
 *  scheduleAtFixedRate:创建一个周期性任务。任务开始与初始延时时间，后续任务按照给定的周期进行。
 *  scheduleWithFixedDelay：创建一个周期性任务。任务开始与初始延时时间，后续任务将会按照给定的延时时间执行
 * Created by ddp on 2017/8/27.
 */
public class ScheduleExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0 ,5 , TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                    System.out.println(System.currentTimeMillis() / 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },0,5,TimeUnit.SECONDS);
    }


}

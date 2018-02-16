package com.waitAndNotify;

/**
 * Created by ddp on 2017/12/24.
 */
public class T1 extends Thread {
    @Override
    public void run() {
        synchronized (WaitAndNotifySample.object){
            System.out.println(System.currentTimeMillis() + ": T1 start ! ");
            try {
                System.out.println(System.currentTimeMillis() + ": T1 wait for object ");
                WaitAndNotifySample.object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ": T1 end!");
        }
    }
}

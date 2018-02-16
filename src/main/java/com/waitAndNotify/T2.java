package com.waitAndNotify;

/**
 * Created by ddp on 2017/12/24.
 */
public  class T2 extends Thread {
    @Override
    public void run() {
        synchronized (WaitAndNotifySample.object) {
            System.out.println(System.currentTimeMillis() + ": T2 start ! notify one thread");
            WaitAndNotifySample.object.notify();
            System.out.println(System.currentTimeMillis() + ": T2 end!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
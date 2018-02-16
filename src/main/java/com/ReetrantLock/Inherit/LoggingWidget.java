package com.ReetrantLock.Inherit;

/**
 * Created by ddp on 2018/2/16.
 */
public class LoggingWidget  extends Widget {
    @Override
    public synchronized void doSometing() {
        try {
            System.out.println("loggingwidget do something...");
            Thread.sleep(5000);
            System.out.println("end loggingwidget do something...");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.doSometing();
    }

    public synchronized void doMyLike() {
        System.out.println("loggingwidget do my like...");
    }
}

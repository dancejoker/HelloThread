package com.ReetrantLock.Inherit;

/**
 * Created by ddp on 2018/2/16.
 */
public class Widget {
    public synchronized void doSometing() {
        System.out.println("widget ... do something...");
    }

    public synchronized void doAnother() {
        System.out.println("widget... do another thing...");
    }

    public void doNother() {
        System.out.println("widget... do Nothing...");
    }
}

package com.happy;

/**
 * Created by ddp on 2017/8/16.
 */
public class HelloThread implements Runnable {
    @Override
    public void run() {
        System.out.println("hello world ,i am a new sub thread");
    }
}

package com.happy;

/**
 * Created by ddp on 2017/8/16.
 */
public class Main {
    public static void main(String[] args) {
//        HelloThread helloThread = new HelloThread(new SubThread());
//        helloThread.start();
        Thread fatherThread = new Thread() {
            @Override
            public void run() {
                System.out.println("hello , I am  Sub Thread");
            }
        };

        fatherThread.start();

        Thread helloThread = new Thread(new HelloThread());
        helloThread.start();

    }
}

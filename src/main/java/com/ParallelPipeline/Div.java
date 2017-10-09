package com.ParallelPipeline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ddp on 2017/9/17.
 */
public class Div implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();
    @Override
    public void run() {
        while(true) {
            try {
                Msg msg = bq.take();
                msg.i = msg.i / 2;
                System.out.println(msg.orgStri + " = " + msg.i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

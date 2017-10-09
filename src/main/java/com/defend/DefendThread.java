package com.defend;

/**
 * 由于defendT被设置为守护进程，系统中只有主线程main为用户线程，因此在main线程休眠2s后退出，随之整个程序结束。
 * 但如果不把DefendT设置为守护进程，main线程结束后，t线程依然会不停的打印
 * Created by ddp on 2017/8/17.
 */
public class DefendThread {
    public static class DefendT extends Thread{
        @Override
        public void run() {
            while(true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            DefendT defendT = new DefendT();
  //          defendT.setDaemon(true);
            defendT.start();
            Thread.sleep(2000);
        }
    }
}

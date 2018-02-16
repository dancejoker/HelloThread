package com.waitAndNotify;

/**
 * Created by ddp on 2017/8/16.
 */
public class WaitAndNotifySample {
    final static Object object = new Object();

//    public  class T1 extends Thread{
//        @Override
//        public void run() {
//            synchronized (object){
//                System.out.println(System.currentTimeMillis() + ": T1 start ! ");
//                try {
//                    System.out.println(System.currentTimeMillis() + ": T1 wait for object ");
//                    object.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(System.currentTimeMillis() + ": T1 end!");
//            }
//        }
//    }
//
//    public  class T2 extends Thread{
//        @Override
//        public void run() {
//            synchronized (object){
//                System.out.println(System.currentTimeMillis() + ": T2 start ! notify one thread");
//                object.notify();
//                System.out.println(System.currentTimeMillis() + ": T2 end!");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
 //       }
 //   }

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}

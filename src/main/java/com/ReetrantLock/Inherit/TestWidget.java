package com.ReetrantLock.Inherit;

/**
 * Created by ddp on 2018/2/16.
 */
public class TestWidget {
    public static void main(String[] args) throws InterruptedException {
        final LoggingWidget widget = new LoggingWidget();
        Thread th1 = new Thread("th1") {
            @Override
            public void run() {
                System.out.println(super.getName() + ":start\r\n");
                widget.doSometing();
            }
        };

        Thread th2 = new Thread("th2") {
            @Override
            public void run() {
                System.out.println(super.getName() + ":start\r\n");
                /** 为了说明子类复写父类方法后，调用时也持有父类锁*/
                widget.doAnother();
                /**证明了内置锁对那些没有加synchronized修饰符的方法是不起作用的*/
                widget.doNother();
                /**为了说明子类复写父类方法后，调用时也持有父类锁，也持有自己本类的锁*/
                 widget.doMyLike();
                /**这是两个线程，这是需要等待的，并不是继承的关系，不是重入，重入是发生在一个线程中的*/
                widget.doSometing();
            }
        };
        th1.start();
   //     Thread.sleep(1000);
 //       th2.start();
    }
}

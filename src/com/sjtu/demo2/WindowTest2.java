package com.sjtu.demo2;

/**
 * @author dango
 * @create 2022-03-13 17:42
 */
class MThread2 implements Runnable{
    private int ticket = 100;
    //private Object obj = new Object();
    @Override
    public void run() {
        synchronized(this) {
            while (true) {
                if (ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票：票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        MThread2 wt = new MThread2();

        Thread thread1 = new Thread(wt);
        thread1.start();

        Thread thread2 = new Thread(wt);
        thread2.start();

    }
}

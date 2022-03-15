package com.sjtu.demo2;

/**
 * @author dango
 * @create 2022-03-13 23:19
 */
class MThread3 implements Runnable{
    private int ticket = 100;
    //private Object obj = new Object();
    @Override
    public void run() {
            while(true){
                show();
            }
    }
    public synchronized void show(){
        if (ticket > 0) {
            try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            System.out.println(Thread.currentThread().getName() + ":卖票：票号为：" + ticket);
            ticket--;
        }
    }
}
public class WindowTest4 {
    public static void main(String[] args) {
        MThread3 wt = new MThread3();

        Thread thread1 = new Thread(wt);
        thread1.start();

        Thread thread2 = new Thread(wt);
        thread2.start();

        Thread thread3 = new Thread(wt);
        thread3.start();

    }
}

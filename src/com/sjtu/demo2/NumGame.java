package com.sjtu.demo2;

/**
 * @author dango
 * @create 2022-03-14 12:07
 */
public class NumGame {
    public static void main(String[] args) {
        Windows5 w5 = new Windows5();

        Thread t1 = new Thread(w5);
        Thread t2 = new Thread(w5);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}


class Windows5 implements Runnable{
    private int number = 100;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                notify();
                if(number>0){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    number--;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
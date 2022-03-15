package com.sjtu.demo2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dango
 * @create 2022-03-14 1:10
 */
class Window5 implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    private static int ticket = 100;
    @Override
    public void run() {
            while(true){
                try{
                    lock.lock();
                    if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+":"+""+ticket);
                    ticket--;
                }else{
                    break;
                }
                }finally {
                    lock.unlock();
                }

            }

        }
        }


public class LockTest {
    public static void main(String[] args) {
        Window5 w5 = new Window5();

        Thread thread1 = new Thread(w5);
        Thread thread2 = new Thread(w5);
        Thread thread3 = new Thread(w5);

        thread1.setName("xc1");
        thread2.setName("xc2");
        thread3.setName("xc3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

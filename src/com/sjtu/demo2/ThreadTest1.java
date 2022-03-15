package com.sjtu.demo2;

/**
 * 创建多线程的方法2
 * @author dango
 * @create 2022-03-13 17:26
 */
class MThread implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"  "+i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread t1 = new MThread();

        Thread thread1 = new Thread(t1);
        thread1.setName("线程1");
        thread1.start();
        Thread thread2 = new Thread(t1);
        thread2.start();

    }
}

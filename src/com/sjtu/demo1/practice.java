package com.sjtu.demo1;

/**
 * @author dango
 * @create 2022-03-11 19:14
 */
public class practice {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("线程-1");
        myThread1.setPriority(Thread.MAX_PRIORITY);
        MyThread2 myThread2 = new MyThread2();
        myThread2.setPriority(Thread.MIN_PRIORITY);
        myThread1.start();
        myThread2.start();
        new Thread(

        ){

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i+"  priority:"+getPriority());
                    }
                }
            }
        }.start();
    }

}

class MyThread1 extends Thread{
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i+"  priority:"+getPriority());
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+":"+i+"  priority:"+getPriority());
            }
        }
    }
}
package com.sjtu.demo2;

/**
 * @author dango
 * @create 2022-03-14 13:32
 */
public class ProductionTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer1 = new Producer(clerk);
        Customers customers1 = new Customers(clerk);

        producer1.setName("生产者1");
        customers1.setName("消费者1");

        producer1.start();
        customers1.start();
    }
}

class Clerk{

    int good_num = 0;
    public synchronized void production() {
        if(good_num<20){
            good_num++;
            System.out.println(Thread.currentThread().getName()+"生产了第"+good_num+"个商品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if(good_num>0){
            System.out.println(Thread.currentThread().getName()+"消费了第"+good_num+"个商品");
            good_num--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"准备开始生产。。。。");
        while(true){
            clerk.production();
        }
    }
}

class Customers extends Thread{
    Clerk clerk;

    public Customers(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+"准备开始消费。。。。");
        while(true){
            clerk.consume();
        }
    }
}


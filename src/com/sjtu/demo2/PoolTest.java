package com.sjtu.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dango
 * @create 2022-03-14 15:30
 */
public class PoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) service;
        tpe.setCorePoolSize(15);
        service.execute(new ThreadTT());
        service.execute(new ThreadTT2());
        service.shutdown();


    }
}

class ThreadTT implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<100l;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"结果是："+i);
            }
        }
    }
}

class ThreadTT2 implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<100l;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"结果是："+i);
            }
        }
    }
}

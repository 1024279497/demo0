package com.sjtu.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dango
 * @create 2022-03-14 15:00
 */
public class CallableTest {
    public static void main(String[] args) {
        NumThread nT = new NumThread();

        FutureTask futureTask = new FutureTask(nT);

        //new Thread(futureTask).start();
        Thread t1 = new Thread(futureTask);
        Thread t2 = new Thread(futureTask);

        t1.start();
        t2.start();

        try {
            Object sum = futureTask.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i =0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"输出："+i);
            sum+=i;
        }
        return sum;
    }
}



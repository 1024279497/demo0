package com.sjtu.demo1;

/**
 * @author dango
 * @create 2022-03-11 18:59
 */

class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for(int i = 0;i<100;i++){
            if(i%2==0){
                System.out.println(i+"main");
            }
    }
}
}

package com.sjtu.demo2;

/**
 * @author dango
 * @create 2022-03-13 14:39
 */
public class WindowTest {
    public static void main(String[] args) throws InterruptedException {
        Window ticket1 = new Window();
        Window ticket2 = new Window();
        Window ticket3 = new Window();
        ticket1.setName("线程1");
        ticket2.setName("线程2");
        ticket3.setName("线程3");
        //Window2 ticket4 = new Window2();
        ticket1.start();
        //ticket1.join(1000);
        ticket2.start();
        //ticket1.join(1000);
        ticket3.start();
        //ticket4.start();
    }

}

class Window extends Thread{
    //private static Object obj = new Object();
    private static int ticket = 100;
    public void run(){
        while(true){
        synchronized(Window.class){

            if(ticket>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName()+"买票，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
    }
}

class Window2 extends Thread{
    //private static Object obj = new Object();
    private static int ticket = 100;
    public void run(){

            while(true){
                synchronized(Window.class){
                if(ticket>0){
                    System.out.println(getName()+"买票，票号为："+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

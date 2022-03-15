package com.sjtu.demo2;

/**
 * @author dango
 * @create 2022-03-13 23:10
 */
public class Window3 {
    public static void main(String[] args) {
        WindowT ticket1 = new WindowT();
        WindowT ticket2 = new WindowT();
        WindowT ticket3 = new WindowT();
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

class WindowT extends Thread{
    //private static Object obj = new Object();
    private static int ticket = 100;
    public void run(){
        while(true){
            show();
            }
        }
    public static synchronized void show(){
        if(ticket>0){
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"买票，票号为："+ticket);
            ticket--;
        }
    }
}


//class WindowT2 extends Thread{
//    //private static Object obj = new Object();
//    private static int ticket = 100;
//    public void run(){
//
//        while(true){
//            synchronized(Window.class){
//                if(ticket>0){
//                    System.out.println(getName()+"买票，票号为："+ticket);
//                    ticket--;
//                }else{
//                    break;
//                }
//            }
//        }
//    }
//}


package com.sjtu.demo2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dango
 * @create 2022-03-14 11:25
 */
public class BankPra {
    public static void main(String[] args) {
        Account account = new Account(3000);

        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        customer1.setName("甲");
        customer2.setName("乙");

        customer1.start();
        customer2.start();

    }
}


class Customer extends Thread{
    private Account acct;
    private static ReentrantLock lock =  new ReentrantLock();

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            for(int i =0;i<3;i++){
                acct.deposit(1000);
            }
        }finally{
            lock.unlock();}
    }
}

class Account{
    private double money;


    public void setMoney(double money) {
        this.money = money;
    }

    public Account(double money) {
        this.money = money;
    }

    public void deposit(double amt){
        if(amt>0){
            this.money+=amt;
            System.out.println(Thread.currentThread().getName()+"存钱成功"+"余额为："+this.getMoney());
        }else{
            System.out.println("输出有误");
        }
    }

    public double getMoney() {
        return money;
    }
}
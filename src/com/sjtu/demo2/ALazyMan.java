package com.sjtu.demo2;

/**
 * @author dango
 * @create 2022-03-14 20:10
 */
public class ALazyMan {
}


class Bank{
    private Bank() {
    }
    private static Bank instance = null;
    public static Bank getInstance(){

        if (instance == null) {
            synchronized (Bank.class) {
                if(instance==null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

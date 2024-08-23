package com.salesforce;

public class PerformTask implements Runnable{


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"tas done");
    }
}

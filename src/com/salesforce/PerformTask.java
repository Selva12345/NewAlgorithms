package com.salesforce;

public class PerformTask implements TaskExecutor, Runnable{
    @Override
    public void executeTask(Task task) {

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"tas done");
    }
}

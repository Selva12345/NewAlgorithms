package com.salesforce;

public interface Scheduler {
    Task getNextTask() throws InterruptedException;
    void addTask(Task task) throws Exception;

    void performTask(Task task) throws Exception;

}

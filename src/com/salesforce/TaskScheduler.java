package com.salesforce;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskScheduler implements Scheduler {
    PriorityQueue<Task> taskQueue;
    PerformTask performTask;
    ScheduledExecutorService service;
    TaskScheduler(){
        taskQueue=new PriorityQueue<>();
        performTask=new PerformTask();
        service= Executors.newScheduledThreadPool(6);

    }
    @Override
    public synchronized Task getNextTask() throws InterruptedException {
        while(taskQueue.isEmpty()){
            wait();
        }
        return taskQueue.poll();
    }

    @Override
    public synchronized void  addTask(Task task) throws Exception {
        taskQueue.add(task);
        notify();
    }

    @Override
    public void performTask(Task task) throws Exception {
        service.schedule(performTask,1, TimeUnit.MINUTES);
    }

}

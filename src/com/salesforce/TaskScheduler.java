package com.salesforce;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class TaskScheduler implements Scheduler {
    PriorityQueue<Task> taskQueue;
    PerformTask performTask;
    ScheduledExecutorService service;
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    TaskScheduler(CountDownLatch countDownLatch){
        taskQueue=new PriorityQueue<>((a,b)->Long.compare(a.getTimeInEpoc(),b.getTimeInEpoc()));
        performTask=new PerformTask();
        service= Executors.newScheduledThreadPool(2);
        semaphore=new Semaphore(5);
       this.countDownLatch=countDownLatch;

    }
    @Override
    public synchronized Task getNextTask() throws InterruptedException {
        while(taskQueue.isEmpty()){

            System.out.println("Waiting");
            wait();
        }
        return taskQueue.poll();
    }

    @Override
    public synchronized void  addTask(Task task) throws Exception {
        taskQueue.add(task);
        notify();
    }
    public void shutDown(){
        service.shutdown();
    }
    @Override
    public void performTask(Task task) throws Exception {
        semaphore.acquire();

        service.schedule(performTask,5, TimeUnit.SECONDS);
      //  Thread.sleep(1000);
        countDownLatch.countDown();
        semaphore.release();

        System.out.println("Permits: "+semaphore.availablePermits());

    }

}

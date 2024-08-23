package com.salesforce;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

public class JobApplication {
    public static void main(String[] args) throws Exception {

        TaskScheduler taskScheduler=new TaskScheduler(new CountDownLatch(15));
        for (int i=0;i<10;i++){
            Instant future=Instant.now().plus(Duration.ofMinutes(10));
            Task task=new Task(i,"ABC- "+i, future.getEpochSecond());
            taskScheduler.addTask(task);

        }
        Runnable runnable = () -> {

                Task task= null;
                try {
                    task = taskScheduler.getNextTask();
                    taskScheduler.performTask(task);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

        };


       for(int i=0;i<15;i++) {
           Thread value= new Thread(runnable);
           value.start();
       }
       Thread.sleep(4000
       );
        for (int i=0;i<5;i++){
            Instant future=Instant.now().plus(Duration.ofMinutes(10));
            Task task=new Task(i,"ABC- "+i, future.getEpochSecond());
            taskScheduler.addTask(task);

        }
        taskScheduler.countDownLatch.await();
        taskScheduler.shutDown();

    }
}

package com.salesforce;

import java.time.Duration;
import java.time.Instant;

public class JobApplication {
    public static void main(String[] args) throws Exception {
        TaskScheduler taskScheduler=new TaskScheduler();
        for (int i=0;i<10;i++){
            Instant future=Instant.now().plus(Duration.ofMinutes(10));
            Task task=new Task(i,"ABC-"+i, future.getEpochSecond());
            taskScheduler.addTask(task);

        }
        for(int i=0;i<5;i++){
            Task task=taskScheduler.getNextTask();
            taskScheduler.performTask(task);

        }


    }
}

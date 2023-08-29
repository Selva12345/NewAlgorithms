package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJointExample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        List<SubTaskWork> subTaskWorkList =new ArrayList<>();
        subTaskWorkList.add(new SubTaskWork("Good,people live everywhere"));
        subTaskWorkList.add(new SubTaskWork("Great!people live everywhere I hate cold countries"));
        ForkJoinTask.invokeAll(subTaskWorkList);
    }
}

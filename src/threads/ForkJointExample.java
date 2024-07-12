package threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJointExample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        List<SubTaskWork> subTaskWorkList =new ArrayList<>();
        subTaskWorkList.add(new SubTaskWork("Good,people live everywhereaaaaaaaaa"));
       // subTaskWorkList.add(new SubTaskWork("Great!people live everywhere I hate cold countries"));
        Collection<SubTaskWork> v=ForkJoinTask.invokeAll(subTaskWorkList);
        System.out.println(v);
    }
}

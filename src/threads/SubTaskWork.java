package threads;

import java.util.concurrent.RecursiveTask;

public class SubTaskWork extends RecursiveTask {
    String str;
    SubTaskWork(String str){
        this.str=str;
    }
    @Override
    protected Object compute() {

        return null;
    }
}

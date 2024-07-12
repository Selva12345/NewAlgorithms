package threads;

import java.util.concurrent.RecursiveTask;

public class SubTaskWork extends RecursiveTask<Integer> {
    String str;
    SubTaskWork(String str){
        this.str=str;
    }
    @Override
    protected Integer compute() {
        int count=0;
        if(str.length()<5){
            for(char c:str.toCharArray()){
                    if(c=='a')count++;
            }
            return count;
        }else{
            int len=str.length();
            SubTaskWork left=new SubTaskWork(str.substring(0,len/2));
            SubTaskWork right=new SubTaskWork(str.substring(len/2,len));
            left.fork();
            Integer l=right.compute();
            Integer r=left.join();
            return l+r;

        }

    }
}

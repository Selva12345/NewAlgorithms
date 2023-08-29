package threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Semaphore;

public class Application {
    public static void main(String[] args) {
        for(int i=0;i<60;i++){
            StringManipulation st=new StringManipulation("woierldnljsdnjvsfvbxmbwehf");
            Thread threadStater=new Thread(st);
            threadStater.start();
        }
    }

}

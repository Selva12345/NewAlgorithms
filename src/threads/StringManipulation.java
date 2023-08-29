package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class StringManipulation implements Runnable{
    private String doc;
    Map<Character,Integer> count;
    static Semaphore semaphore = new Semaphore(4);
    StringManipulation(String doc){
        this.doc =doc;
        count=new HashMap<>();
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();

            System.out.println(semaphore.availablePermits());

            for(int i=0;i<doc.length();i++){
                count.put(doc.charAt(i),count.getOrDefault(doc.charAt(i),0)+1);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }

        System.out.println(count);


    }
}

package ThreadPool;

import java.util.concurrent.Executors;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;

/**
 * TaskQueue
 */
public class TaskQueue {

    public static void main(String[] args) {
        ExecutorService executors=Executors.newFixedThreadPool(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        for(int i=1;i<=10;i++){
            final int taskId=i;
            executors.submit(()->{
                 String threadName = Thread.currentThread().getName();
                System.out.println("[" + LocalTime.now().format(formatter) + "] " 
                    + threadName + " STARTED Task " + taskId);
                try {
                    // Each task sleeps for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("[" + LocalTime.now().format(formatter) + "] " 
                    + threadName + " FINISHED Task " + taskId);

            });
        }
    }
}
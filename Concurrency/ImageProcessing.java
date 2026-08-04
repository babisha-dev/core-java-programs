package Concurrency;
import java.util.concurrent.*;
public class ImageProcessing {
    public static void main(String[] args) {
        ExecutorService executor=Executors.newFixedThreadPool(5);
        for(int i=0;i<=5;i++){
            final int id=i;
            executor.submit(()->{
                try{
                    long sleepTime=ThreadLocalRandom.current().nextLong(500,2000);
                    Thread.sleep(sleepTime);
                System.out.printf("Image %d processed (took %.2fs)%n", 
                                      id, sleepTime / 1000.0);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            });
        }
        executor.shutdown();
        try{
            executor.awaitTermination(1,TimeUnit.MINUTES);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

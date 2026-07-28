package ThreadPool;

import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Task implements Runnable{
    int id;
    public Task(int id){
        this.id=id;
    }
  public void run(){
       System.out.println("task "+id +" by "+Thread.currentThread().getName());
       if(id==3){
        throw new RuntimeException("Error");
       
       }
             // System.out.println("task "+id +" by "+Thread.currentThread().getName());

       try{
       Thread.sleep(1000);
  }
catch(Exception e){}}
}
public class CreatingThreadPool {
    public static void main(String[] args) {
       // Executor executors= Executors.newFixedThreadPool(3);
                ExecutorService executors= Executors.newFixedThreadPool(3);

        for(int i=1;i<=10;i++){
          Future<?> future= executors.submit(new Task(i));
          try{
                  System.out.println(future.get());
          }catch(Exception e){}

        }
        
       executors.shutdown();
    }
    
}

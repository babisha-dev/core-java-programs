package MultiThreading.LockAPi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
class SharedBlockingQueue {
    BlockingQueue<Integer>  que=new LinkedBlockingQueue<>();
}
class ProducerA extends Thread{
    SharedBlockingQueue sharedque;
    public ProducerA(SharedBlockingQueue que){
          this.sharedque=que;
    }
    public void run(){
        for(int i=1;i<=10;i++){
            try{
             sharedque.que.put(i);
             System.out.println("Produced: "+i+" from "+Thread.currentThread().getName());
            }
            catch(Exception e){}
        }
    }
}
class ConsumerA extends Thread {
    SharedBlockingQueue sharedque;
    public ConsumerA(SharedBlockingQueue que){
        this.sharedque=que;
    }
    public void run() {
        for(int i=0;i<10;i++){
            try{
            System.out.println("Consumed:  "+sharedque.que.peek()+" from "+Thread.currentThread().getName());

            sharedque.que.poll();
        }catch(Exception e){}
    }
    }
}
public class BlockedQueue {
    public static void main(String[] args) throws InterruptedException {
        SharedBlockingQueue que=new SharedBlockingQueue();
        ProducerA prod=new ProducerA(que);
        ConsumerA cons=new ConsumerA(que);
        
        prod.start();
        cons.start();

        prod.join();
        prod.join();
    }
    
}

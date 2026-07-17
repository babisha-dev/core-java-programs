
package MultiThreading.LockAPi;
import java.util.*;
import java.util.concurrent.locks.*;

class Buffer121{
    private final Queue<Integer> buffer=new LinkedList<>();
    private final int capacity=5;
    private ReentrantLock lock=new ReentrantLock();
    private final Condition notFull=lock.newCondition();
    private final Condition notEmpty=lock.newCondition();

    public void produce(int val) throws InterruptedException{
        lock.lock();
        try{
            while(buffer.size()==capacity){
                notFull.await();
            }
            buffer.add(val);
            System.out.println("produced: "+val +" By "+Thread.currentThread().getName());
            notEmpty.signal();
        }
        finally{
            lock.unlock();
        }
    }
    public void consume() throws InterruptedException{
        lock.lock();
        try{
            while (buffer.isEmpty()) {
                notEmpty.await();
            }
           int val= buffer.remove();
            System.out.println("Consumed"+val+" By "+Thread.currentThread().getName() );
            notFull.signal();
        }
        finally{
            lock.unlock();
        }
    }
}

class Producer121 extends Thread{
    Buffer121 buffer;
    public Producer121(Buffer121 buffer){
this.buffer=buffer;
    }
    public void run(){
      for(int i=0;i<5;i++){
        try{
        buffer.produce(i);
        }
        catch(Exception e){

        }
      }
    }
}
class Consumer121 extends Thread{
    Buffer121 buffer;
    public Consumer121(Buffer121 buffer){
this.buffer=buffer;
    }
    public void run(){
      for(int i=0;i<5;i++){
        try{
        buffer.consume();
        }
        catch(Exception e){
            
        }
      }
    }
}

class ConditionReentrant{
public static void main(String[] args) throws InterruptedException{
    Buffer121 buffer=new Buffer121();
    Producer121 prod=new Producer121(buffer);
    Consumer121 cons1=new Consumer121(buffer);
     Producer121 prod1=new Producer121(buffer);
    Consumer121 cons2=new Consumer121(buffer);
    prod.start();
    prod1.start();
    cons1.start();
    cons2.start();

    prod.join();
    prod1.join();
    cons1.join();
    cons2.join();
    
}
}
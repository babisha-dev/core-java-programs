package MultiThreading.LockAPi;

import java.util.concurrent.locks.ReentrantLock;

// THis is to illustrate how Lock acts if no try and finally are used, if finally is not used we get wrong output

class Counter{
private int count=0;
final private ReentrantLock lock=new ReentrantLock();
public void increment(){

//try{
count++;
//} finally{
lock.unlock();
//}
}
public int getCount(){
    return count;
}
}
class Worker2 extends Thread{
    Counter counter;
    public Worker2(Counter counter){
        this.counter=counter;
    }
    public void run(){
      for(int i=0;i<10000;i++){
        counter.increment();
      }
    }
}

public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter =new Counter();
        Worker2 work1=new Worker2( counter);
       Worker2 work2=new Worker2( counter);

        work1.start();
        work2.start();

        work1.join();
        work2.join();

System.out.println(counter.getCount());
        
    }
    
}

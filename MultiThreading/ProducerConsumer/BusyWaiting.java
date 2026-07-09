package MultiThreading.ProducerConsumer;

class Buffer{
    int numbers;
       boolean full;
   synchronized public void produce(int val){
            while(full){

            }
             numbers=val;
             full=true;
          System.out.println("Produces:"+numbers+" by "+Thread.currentThread().getName());
         
    }
   synchronized public void consumer(){
    while(!full){}
    int val=numbers;
    full=false;
    System.out.println("Consumes:"+val+" by "+Thread.currentThread().getName());

    }
}
class Producer implements Runnable{
    Buffer buffer;
    public Producer(Buffer buffer){
   this.buffer=buffer;
    }
    public void run(){
       for(int i=1;i<=10;i++){
        buffer.produce(i);
        try{
            Thread.sleep(500);
        }catch(Exception e){}
       }
    }
}
class Consumer implements Runnable{
    Buffer buffer;
    public Consumer(Buffer buffer){
        this.buffer=buffer;
    }
    public void run(){
    for(int i=1;i<=10;i++){
    buffer.consumer();
    try{
        Thread.sleep(700);
    }catch(Exception e){}
}    }
}
public class BusyWaiting {
    public static void main(String[] args) throws InterruptedException{
        Buffer buffer=new Buffer();
        Thread t1=new Thread(new Producer(buffer));
                //Thread t2=new Thread(new Producer(buffer));
                        Thread t3=new Thread(new Consumer(buffer));

                                //Thread t4=new Thread(new Consumer(buffer));
        t1.start();
        //t2.start();
        t3.start();
       // t4.start();


        t3.join();
        t1.join();
    }
    
}

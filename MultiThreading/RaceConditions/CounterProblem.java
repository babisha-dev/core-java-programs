package MultiThreading;

class Counter{
    int count=0;
    void increment(){
         count++;
    }
}
class Count extends Thread{
    Counter c1=new Counter();
     public Count(Counter c1){
          this.c1=c1;
     }
    @Override
   public void run(){
    for(int i=0;i<1000;i++){
          c1.increment();
    }
      
    }

}
public class CounterProblem {
    
    public static void main(String[] args) throws InterruptedException{
        Counter counter=new Counter();
        Count[] count=new Count[100];
        for(int i=0;i<100;i++){  // creating threads
            count[i]=new Count(counter);
        }
        for(int i=0;i<100;i++){  // starting threads
            count[i].start();
        }
       for(int i=0;i<100;i++){
           count[i].join();
        }
        System.out.println(counter.count);
        
    }
    
}

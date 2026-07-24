package MultiThreading.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

class TotalViews{
     AtomicInteger views=new AtomicInteger();
}
class UserA extends Thread{
    TotalViews totalviews;
    public UserA(TotalViews totalviews){
        this.totalviews=totalviews;
    }
    public void run(){
        for(int i=0;i<10000;i++){
         totalviews.views.incrementAndGet();
        }
    }
}
public class CounterAtomicInt {
    public static void main(String[] args) throws InterruptedException{
        TotalViews totalviews=new TotalViews();
        Thread[] userA=new Thread[10];
        for(int i=0;i<10;i++ ){
            userA[i]=new UserA(totalviews);
        }
        for(int i=0;i<10;i++){
            userA[i].start();
        }
        for(int i=0;i<10;i++){
             userA[i].join();
        }
        System.out.println("Total Views: "+totalviews.views);
    }
}

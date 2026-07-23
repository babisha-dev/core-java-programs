package MultiThreading.LockAPi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class SharedMap{
    ConcurrentHashMap<Integer,String> map=new ConcurrentHashMap<>();
    AtomicInteger key=new AtomicInteger(); // This will provide unique key value, so size is 10,000
    //HashMap<Integer,String> map=new HashMap<>(); // not thread safe, inccorrect size as output 
    }
class UserD extends Thread{
    SharedMap sharedmap;
    public UserD(SharedMap map){
        this.sharedmap=map;
    }
    public void run(){
        try{
       for(int i=1;i<=1000;i++){
        int uniqkey=sharedmap.key.getAndIncrement();
        sharedmap.map.put(uniqkey,"User"+i);
        Thread.sleep(1);
       }}
       catch(Exception e){
        System.out.println(e);
       }
    }
}
public class ConcurrentHashMapDemo {
    public static void main(String[] args)  throws InterruptedException {
   SharedMap sharedmap=new SharedMap();
        UserD[] userd1=new UserD[10];
        for(int i=0;i<10;i++){
            userd1[i]=new UserD(sharedmap);
        }
        for(int i=0;i<10;i++){
            userd1[i].start();
        }
        for(int i=0;i<10;i++){
        userd1[i].join();
        }
        System.out.println(sharedmap.map.size());
    }

}

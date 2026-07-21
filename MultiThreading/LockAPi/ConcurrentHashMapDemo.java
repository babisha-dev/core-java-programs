package MultiThreading.LockAPi;

import java.util.HashMap;

class SharedMap{
    HashMap<Integer,String> map=new HashMap<>();
}
class UserD extends Thread{
    SharedMap sharedmap;
    public UserD(SharedMap map){
        this.sharedmap=map;
    }
    public void run(){
        try{
       for(int i=1;i<=1000;i++){
        sharedmap.map.put(i,"User"+i);
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

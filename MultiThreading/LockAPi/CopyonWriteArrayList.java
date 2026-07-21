package MultiThreading.LockAPi;

//import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
class SharedArrayList {
    CopyOnWriteArrayList<Integer> segment;
}
class Userk1 extends Thread{
   
    CopyOnWriteArrayList<Integer> segment;
     public Userk1(CopyOnWriteArrayList<Integer> segment){
        this.segment=segment;
     }
    public void run(){
         
         try{
       for(int i=1;i<=100;i++){
        segment.add(i); // adding thread
         Thread.sleep(10); 
       }
       System.out.println("Added "+segment.size()+" values to " + Thread.currentThread().getName());
    }
    catch(Exception e){

    }
}

}
class Userk2 extends Thread{
   private volatile boolean running=true;
    CopyOnWriteArrayList<Integer> segment;
     public Userk2(CopyOnWriteArrayList<Integer> segment){
        this.segment=segment;
     }
     public void shutdown(){
        this.running=false;
     }
    public void run(){
        try{
            while (running) {   // this never throws error regarding InterrupteException.
       // while(!Thread.currentThread().isInterrupted()){ // using interruption so the user2 never fall in infinite loop like using true.
             //while(true){
        
            for(Integer val:segment){  // looping thread
                 System.out.println(val +Thread.currentThread().getName());
            }
            Thread.sleep(20);
        }
                       System.out.println(segment.size()+" is the size from  " + Thread.currentThread().getName());
}
        catch (InterruptedException e) {
            // Fix: Log a clean termination message instead of e.printStackTrace()
    //  System.out.println(segment.size()+" is the size from  " + Thread.currentThread().getName());  // if u use interrupt then interruption exception occurs so use this in catch block so it will print, but if u use volatile flag then this is not necessary.

            System.out.println(Thread.currentThread().getName() + " received shutdown signal while sleeping. Exiting gracefully.");
        }
        catch(Exception e){
        e.printStackTrace();
    }}

}
public class CopyonWriteArrayList {
    public static void main(String[] args) throws InterruptedException{
        CopyOnWriteArrayList<Integer> segment =new CopyOnWriteArrayList<>();
        Userk1 userk1=new Userk1(segment);
        Userk2 userk2=new Userk2(segment);

        userk1.start();
        userk2.start();

        userk1.join(); // waiting for user1 to finish
       // userk2.interrupt(); // stop user 2 if user1 finished
       userk2.shutdown();
        userk2.join();

        
    }
}

// prints difeerent values coz: non atomic(not a single transaction)   i) if cpu calculates the size , if when thread-0 executing the size() method and at that particulat time(ms) the arraylist size if 1016.it stores the size as 1016 for thread-0.
// ii) now the cpu switches before printing into console. Now Thread-1 executes adding values to arraylist and after completing for loop it calculates the size(). now size is 2000, and it is printed into console, 
// iii)then thread-0 resumes and prints the already generated 1016 value to console.

/// ArrayIndexOutOfBound Error:
/// If a thread-0 tries to expand the size of arraylist coz arraylist if full.
/// At that time fi threas-1 tries to add value in the outdated arraylist , it throws ArrayIndexOutOfBound Exception.
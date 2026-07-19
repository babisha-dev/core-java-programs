package MultiThreading.LockAPi;

import java.util.ArrayList;

class SharedArrayList {
    ArrayList<Integer> segment;
}
class Userk1 extends Thread{
   
    ArrayList<Integer> segment;
     public Userk1(ArrayList<Integer> segment){
        this.segment=segment;
     }
    public void run(){
         
         try{
       for(int i=1;i<=100;i++){
        segment.add(i);
         Thread.sleep(10); 
       }
       System.out.println("Added"+segment.size()+" " + Thread.currentThread().getName());
    }
    catch(Exception e){

    }
}

}
class Userk2 extends Thread{
   
    ArrayList<Integer> segment;
     public Userk2(ArrayList<Integer> segment){
        this.segment=segment;
     }
    public void run(){
        try{
        while(true){
            for(Integer val:segment){
                 int temp=val;
            }
            Thread.sleep(20);
       System.out.println(segment.size()+" " + Thread.currentThread().getName());
        }}
        catch(Exception e){
        e.printStackTrace();
    }}

}
public class CopyonWriteArrayList {
    public static void main(String[] args) throws InterruptedException{
        ArrayList<Integer> segment =new ArrayList<>();
        Userk1 userk1=new Userk1(segment);
        Userk2 userk2=new Userk2(segment);

        userk1.start();
        userk2.start();

        userk1.join();
        userk2.join();

        
    }
}

// prints difeerent values coz: non atomic(not a single transaction)   i) if cpu calculates the size , if when thread-0 executing the size() method and at that particulat time(ms) the arraylist size if 1016.it stores the size as 1016 for thread-0.
// ii) now the cpu switches before printing into console. Now Thread-1 executes adding values to arraylist and after completing for loop it calculates the size(). now size is 2000, and it is printed into console, 
// iii)then thread-0 resumes and prints the already generated 1016 value to console.

/// ArrayIndexOutOfBound Error:
/// If a thread-0 tries to expand the size of arraylist coz arraylist if full.
/// At that time fi threas-1 tries to add value in the outdated arraylist , it throws ArrayIndexOutOfBound Exception.
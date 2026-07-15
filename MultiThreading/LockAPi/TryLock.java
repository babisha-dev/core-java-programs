package MultiThreading.LockAPi;
import java.util.concurrent.locks.*;;
class Printer12{
final private ReentrantLock lock=new ReentrantLock();
public void print(){
if(lock.tryLock()){
try{
System.out.println("prints value");
} finally{
lock.unlock();
}}
else{
    System.out.println("Printer Busy");
}
}
}
class Worker12 extends Thread{
Printer12 printer;
    public Worker12(Printer12 printer){
        this.printer=printer;
    }
    public void run(){
      for(int i=0;i<5;i++){
        printer.print();
      }
    }
}

public class TryLock {
    public static void main(String[] args) throws InterruptedException {
Printer12 printer=new Printer12();
        Worker12 work1=new Worker12( printer);
       Worker12 work2=new Worker12( printer);

        work1.start();
        work2.start();

        work1.join();
        work2.join();
}
}
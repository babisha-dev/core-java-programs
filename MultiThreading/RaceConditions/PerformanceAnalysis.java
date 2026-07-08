package MultiThreading.RaceConditions;
class Printer {
   synchronized  void print() {  //synchronized method

        for(int i=0;i<5;i++){
            System.out.println("starting...");
          //  synchronized(this){ // synchronized block
            System.out.println("print "+i+" "+Thread.currentThread().getName());
            try{
            Thread.sleep(1000);
            }
            catch(Exception e){}
       // }
        }
                 
    }
    synchronized  void colorPrint() {  //synchronized method

        for(int i=0;i<5;i++){
            System.out.println("starting...");
          //  synchronized(this){ // synchronized block
            System.out.println("color print "+i+" "+Thread.currentThread().getName());
            try{
            Thread.sleep(1000);
            }
            catch(Exception e){}
       // }
        }
                 
    }
   
}
 class PrintTask implements Runnable {
    Printer printer;
    public PrintTask(Printer printer){
        this.printer=printer;
    }
    public void run(){
     printer.print();
    }
}
 class ColorTask implements Runnable {
    Printer printer;
    public ColorTask(Printer printer){
        this.printer=printer;
    }
    public void run(){
     printer.colorPrint();
    }
}
public class PerformanceAnalysis  {
   
    public static void main(String[] args) throws InterruptedException {

      /*   Printer print1=new Printer();
        Printer print2=new Printer();
       Thread t1=new Thread(new PrintTask(print1),"t1");
       Thread t2=new Thread(new PrintTask(print2),"t2");   //If Print1 is given(i.e same lock) thread blocks the other t1 executes completely then only t2 starts execution , but here t1, t2 execute together.
       t1.start();
       t2.start();*/

         Printer print=new Printer();
        Thread[] thread=new Thread[3];
        long start=System.currentTimeMillis();

        for(int i=0;i<3;i++){
           thread[i]=new Thread(new PrintTask(print),"Thread-"+i);
            thread[i].start();
        }
         for(int i=0;i<3;i++){
            thread[i].join();
        }
         for(int i=0;i<3;i++){
           thread[i]=new Thread(new ColorTask(print),"Thread-"+i);
            thread[i].start();
        }
        for(int i=0;i<3;i++){
            thread[i].join();
        }
         long end=System.currentTimeMillis();

                    System.out.println(end-start);

    }
    
}

/// If we have two synchronized method , the methods should not run parallely, should execute one after the other.
/// the print should execute first completely then after the colorprint must start
/// we are using two separate classes to demonstrate it.
/// join() is important after creating threads , if not used the blocks execute paralley coz before complete first thread execution the next thread starts w/o join.
/// 
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

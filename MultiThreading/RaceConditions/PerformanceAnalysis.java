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
   
}
public class PerformanceAnalysis implements Runnable {
    Printer printer;
    public PerformanceAnalysis(Printer printer){
        this.printer=printer;
    }
    public void run(){
     printer.print();

    }
    public static void main(String[] args) throws InterruptedException {
        Printer print=new Printer();
        Thread[] thread=new Thread[3];
        long start=System.currentTimeMillis();

        for(int i=0;i<3;i++){
           thread[i]=new Thread(new PerformanceAnalysis(print),"Thread-"+i);
            thread[i].start();
        }
        for(int i=0;i<3;i++){
            thread[i].join();
        }
         long end=System.currentTimeMillis();

                    System.out.println(end-start);

    }
    
}

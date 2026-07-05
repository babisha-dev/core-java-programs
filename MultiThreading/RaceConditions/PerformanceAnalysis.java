package MultiThreading.RaceConditions;


class Printer {
   synchronized  void print() {  //synchronized method
                            long start=System.currentTimeMillis();

        for(int i=0;i<5;i++){
            System.out.println("starting...");
           // synchronized(this){ // synchronized block
            System.out.println("print "+i+" "+Thread.currentThread().getName());
            try{
            Thread.sleep(200);
            }
            catch(Exception e){}
       // }
        }
                    long end=System.currentTimeMillis();
                                System.out.println(end-start+" inside loop");


    }
   
}
public class PerformanceAnalysis implements Runnable {
    Printer printer;
    public PerformanceAnalysis(Printer printer){
        this.printer=printer;
    }
    public void run(){
                    long start=System.currentTimeMillis();

     printer.print();
            long end=System.currentTimeMillis();
            System.out.println(end-start);

    }
    public static void main(String[] args) {
        Printer print=new Printer();
        for(int i=0;i<3;i++){
            Thread perf=new Thread(new PerformanceAnalysis(print),"Thread-"+i);
            perf.start();


        }
        
    }
    
}

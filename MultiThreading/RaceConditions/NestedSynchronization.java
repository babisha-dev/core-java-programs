package MultiThreading.RaceConditions;

/**
 * NestedSynchronization
 */
class ResourceA{
    public void workA(){
        System.out.println("working with A");
    }
}
class ResourceB{
    public void workB(){
        System.out.println("working with B");
    }
}
class Worker{
                    ResourceA resourceA;
                   ResourceB resourceB;


    public Worker(ResourceA resourceA,ResourceB resourceB){
        this.resourceA=resourceA;
        this.resourceB=resourceB;
    }
    void process(){
        synchronized(resourceA){
                System.out.println(Thread.currentThread().getName()+" acquired ResourceA");
                try{Thread.sleep(2000);}catch(Exception e){}
                synchronized(resourceB){
                    System.out.println(Thread.currentThread().getName()+" acquired ResourceB");
                    resourceA.workA();
                    resourceB.workB();
                                                    System.out.println(Thread.currentThread().getName()+" released ResourceB");

                }
        
                        System.out.println(Thread.currentThread().getName()+" released ResourceA");
            }
    }
}
class Mythread8 extends Thread{
    Worker worker;
    public Mythread8(Worker worker){
       this.worker=worker;
    }
    public void run(){
        worker.process();
    }
}
public class NestedSynchronization {

    public static void main(String[] args) throws InterruptedException{
        ResourceA resourceA=new ResourceA();
        ResourceB resourceB=new ResourceB();
        Worker worker=new Worker(resourceA, resourceB);
        Mythread8 t1=new Mythread8(worker);
        Mythread8 t2=new Mythread8(worker);

        t1.start();
       // t1.join();
        t2.start();
       // t2.join();
    }
}
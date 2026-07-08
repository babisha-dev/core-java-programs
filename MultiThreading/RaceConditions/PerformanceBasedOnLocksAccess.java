package MultiThreading.RaceConditions;

 class  Account1 {
    double balance=1000;

synchronized public void withdraw(double amt){
 balance-=amt;
 System.out.println("Withdrawn amount: "+amt+ " Balance : "+balance +" "+Thread.currentThread().getName());
  try{  Thread.sleep(1000);  }
    catch(Exception e){}

}
static synchronized public void audit(){
 System.out.println("Deposited amount: "+Thread.currentThread().getName());
 try{  Thread.sleep(1000);  }
    catch(Exception e){}
}    
}
class AccHolder implements Runnable{
    Account1 acc;
    public AccHolder(Account1 acc){
        this.acc=acc;
    }
    public void run(){
        acc.withdraw(100);
    }

}
class NonAccHolder implements Runnable{
    Account1 acc;
    public NonAccHolder(Account1 acc){
        this.acc=acc;
    }
    public void run(){
        Account1.audit();
    }

}

public class PerformanceBasedOnLocksAccess {
    public static void main(String[] args) throws InterruptedException {
        Account1 acc1=new Account1();
        Account1 acc2=new Account1();

        Thread[] thread=new Thread[3];
        Thread[] thread1=new Thread[3];

        for(int i=0;i<3;i++){
            thread[i]=new Thread(new AccHolder(acc1));
            thread[i].start();
        }
          
         for(int i=0;i<3;i++){
            thread1[i]=new Thread(new NonAccHolder(acc2));
            thread1[i].start();

        }
        for(int i=0;i<3;i++){
            thread1[i].join();
        }
        for(int i=0;i<3;i++){
            thread[i].join();
        }

    }
    
}

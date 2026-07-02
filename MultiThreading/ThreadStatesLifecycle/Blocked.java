package MultiThreading.ThreadStatesLifecycle;

class Mythread2 extends Thread{
    public void run(){
        synchronized(Blocked.lock){
         System.out.println("Entered");
System.out.println(Thread.currentThread().getState() +" "+ Thread.currentThread().getName());

        }
    }
}
public class Blocked {
    static  Object lock=new Object();
    public static void main(String[] args) {
        synchronized(lock){
     Mythread2 t=new Mythread2();
     t.start();
System.out.println(Thread.currentThread().getState() +" "+ Thread.currentThread().getName());

    }
    }
}

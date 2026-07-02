package MultiThreading;

public class CreateThreadRunnable implements Runnable{
     public void run(){
        System.out.println("Hello World of Multi threading from: "+Thread.currentThread().getName());
     }
    public static void main(String[] args){
     CreateThreadRunnable Runnable=new CreateThreadRunnable();
     Thread thread1=new Thread(Runnable);
     thread1.start();
     thread1.run();
    }
}
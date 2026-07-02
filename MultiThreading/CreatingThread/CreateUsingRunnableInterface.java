package MultiThreading.CreatingThread;

public class CreateUsingRunnableInterface implements Runnable{
     public void run(){
        System.out.println("Hello World of Multi threading from: "+Thread.currentThread().getName());
     }
    public static void main(String[] args){
     CreateUsingRunnableInterface Runnable=new CreateUsingRunnableInterface();
     Thread thread1=new Thread(Runnable);
     thread1.start();
     thread1.run();
    }
}
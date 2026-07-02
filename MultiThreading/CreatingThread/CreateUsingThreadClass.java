package MultiThreading;
class CustomThread extends Thread{
  public void run(){
    System.out.println(Thread.currentThread().getName());
    try{
      Thread.sleep(5000);
          System.out.println("after 500ms");

    }
    catch (InterruptedException e){
      System.out.println("Thread is Interrupted");
    }
  }
}
public class CreateThreas {
  public static void main(String[] args) {
    CustomThread thread=new CustomThread();
    thread.setName("Dummy");
    thread.start();
          System.out.println("STARTED");

    
  }  
}

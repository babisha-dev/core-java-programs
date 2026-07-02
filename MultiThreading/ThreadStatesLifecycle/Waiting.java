package MultiThreading.ThreadStatesLifecycle;

class Mythread1 extends Thread{
    public void run(){
        try{
            Thread.currentThread().join();
                  System.out.print(getState());

        }
        catch(Exception e){System.out.println(e);}
    }
} 
public class Waiting {
    public static void main(String[] args) throws Exception{
        Mythread1 t=new Mythread1();
        t.start();
        Thread.sleep(100);
      System.out.print(t.getState()+" "+Thread.currentThread().getName());
    }
    
}

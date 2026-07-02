package MultiThreading;

class Mythread3 extends Thread{
    public void run(){
        System.out.println("Thread is running");
                System.out.println(getState()+" "+Thread.currentThread().getName());

    }

}
public class NewRunnableTerminate {
    public static void main(String[] args) throws Exception {
        Mythread3 t=new Mythread3();
        System.out.println(t.getState()+Thread.currentThread().getName());
        t.start();
        System.out.println(t.getState() +Thread.currentThread().getName());
        t.join();
         System.out.println(t.getState() +Thread.currentThread().getName());

    }
    
}

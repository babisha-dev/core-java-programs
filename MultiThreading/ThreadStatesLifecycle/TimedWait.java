package MultiThreading.ThreadStatesLifecycle;

class Mythread extends Thread {
public void run(){
    try{
        Thread.sleep(5000);// wait 5s
                System.out.println(getState()+" "+Thread.currentThread().getName());

    }
    catch(Exception e){
        System.out.println(e);
    }
}
}
public class TimedWait {
    public static void main(String[] args) throws Exception {
        Mythread t= new Mythread();
        t.start();
        for(int i=0;i<5;i++){   // while t waits 5s this executes
            System.out.println("child "+i);
        }
        Thread.sleep(100);
        System.out.println(t.getState()+" "+Thread.currentThread().getName());
        t.join();



    }
    
}

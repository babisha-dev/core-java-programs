package MultiThreading.ProducerConsumer;
import java.util.concurrent.locks.*;
class ClassB{
final  private ReentrantLock lock=new ReentrantLock();
public void methodA(){
    lock.lock();
    try{
        System.out.println("Inside Method A");
        try{
        Thread.sleep(1000);
        }
        catch(Exception e   ){}
                System.out.println("Existing Method A");
    }
    finally{
        lock.unlock();
    }
}
}
class  ClassA extends Thread{
    ClassB classB;
    public ClassA(ClassB classB){
      this.classB=classB;
    }
    public void run(){
        classB.methodA();
    }

}
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ClassB classB=new ClassB();
        ClassA classA=new ClassA(classB);
        classA.start();
    }
    
}

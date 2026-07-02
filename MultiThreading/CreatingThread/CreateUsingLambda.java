package MultiThreading.CreatingThread;
 class CreateThreadLamda{
    public static void main(String[] args) {
        Runnable lambda = () ->{
            Thread.currentThread().setName("hello 1");
            System.out.println(Thread.currentThread().getName());
        };
        Thread myThread6=new Thread(lambda);
        myThread6.start();;
    }
    
}
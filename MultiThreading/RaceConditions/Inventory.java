package MultiThreading.RaceConditions;

class Stock{
    int stock =20;
    synchronized public void buyStock(){
        if(stock >0){
            try{
                Thread.sleep(100);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            stock--;
            System.out.println("Stock purchased by : "+Thread.currentThread().getName());
        }
        else{
            System.out.println("Out of Stock");
        }
    }
}
class Buyer implements Runnable{
    Stock stock;
    public Buyer(Stock stock){
        this.stock=stock;
    }
    public void run(){
        stock.buyStock();
    }

}
public class Inventory {

    public static void main(String[] args) {
        Stock stock=new Stock();
        for(int i=1;i<=25;i++){
            Thread thread=new Thread(new Buyer(stock), "user-"+i);
            thread.start();
        }
    }
}
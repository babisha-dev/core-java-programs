package MultiThreading.RaceConditions;
class Ticket{
    int ticket=5;
     void bookTicket(){
          if(ticket>=1){
            try {
            Thread.sleep(100);   // Just to Simulate processing time
             } catch (InterruptedException e) {
            e.printStackTrace();
            }
            ticket--;
            System.out.println("Booked : "+" tickets by " + Thread.currentThread().getName());
          }
          else{
            System.out.println("full");
          }
          
    }
}
class User extends Thread{
    Ticket ticket;
    public User(Ticket ticket){
        this.ticket=ticket;
    }
   public void run(){
     ticket.bookTicket();
    }

}
public class TicketBooking {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        User user1=new User(ticket);
                User user2=new User(ticket);
                 User user4=new User(ticket);
                User user5=new User(ticket);

    User user6=new User(ticket);
                     User user7=new User(ticket);
                 User user8=new User(ticket);
                 User user9=new User(ticket);
                 User user10=new User(ticket);
                 User user3=new User(ticket);



        user1.start();
        user2.start();
        user3.start();
                user4.start();

                        user5.start();
                                user6.start();
        user7.start();

                user8.start();
        user9.start();

                user10.start();


    }
    
}

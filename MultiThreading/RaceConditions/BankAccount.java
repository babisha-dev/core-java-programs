package MultiThreading.RaceConditions;
class Account{
   double balance =1000;
    synchronized void withdraw(double amount){
    if(balance >amount){
       balance-=amount;
       System.out.println("Balance : " +balance);
   }
}}
class Users extends Thread{
    Account account;
       public Users(Account account, String name){
        super(name);
         this.account=account;
       }
    public void run(){
       account.withdraw(700);
    }
}
public class BankAccount {
    public static void main(String[] args) {
        Account account =new Account();
        Users user1=new Users(account,"users-1");
        Users user2=new Users(account, "users-2");

        user1.start();
        user2.start();
    }
    
}


//errorlog:
/*1. created a Thread t=new Thread(); //for create thread instead of creating thread for the thread extending class.
  2. created a account object on Users class --> so each time user object is called a account is newly created.
    but we need only one account that is used by more users to describe the race condition.
*/
/* Result
1. why -400,-400?
   CPU first executes thread-1 upto balance-=amount;, then it switches thread-2, so now thread -2 executes balance-=amount,
   then print statement execute, now CPU switch to thread-1 , now print executes.
   To avoid this : Use Synchronized.
 2. If we use synchronized output will be 300,-400.
 3. If we use  if(balance >amount), sometimes the output will be correct and sometimes incorrect,
   coz if cpu switches after checking  if(balance >amount) then definitely incorrect value.
*/
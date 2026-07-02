package OOP;


class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String accountNumber,double amount, double balance){
       super("Insufficient Balance for Account Number : "+accountNumber+"\nAmount Required: "+amount+"\nAvailable Balance: "+balance);
    }
}
class AccountFrozenException extends RuntimeException{
    public AccountFrozenException(String msg){
            super(msg);
    }
}
class AccountNotExists extends Exception{
   public AccountNotExists(String msg,String accountNumber){
    super(accountNumber+msg);
   }
}
class Account{
private String accountNumber;
private String accountHolderName;
private double balance;
private boolean isFrozen;
private String frozenReason;
//private  List<Transaction> transactionHistory;
//private double todayWithDrawalAmount;

public Account(String accountNumber, String accountHolderName, double balance, boolean isFrozen,String frozenReason){

this.accountNumber=accountNumber;
this.accountHolderName=accountHolderName;
this.balance=balance;
this.isFrozen=isFrozen;
this.frozenReason=frozenReason;
//this.transactionHistory=transactionHistory;
//this.todayWithDrawalAmount=todayWithDrawalAmount;
    }


public void deposit(double amount){
    if(amount <=0){
        throw new IllegalArgumentException("Amount must be greater than 0");
    }
    balance+=amount;
    System.out.println("Amount deposited successfully: "+balance);
}


public void withdraw(double amt) throws InsufficientBalanceException{
    if(isFrozen){
        throw  new AccountFrozenException("\naccountHolderName: "+accountHolderName+"\nfrozen Reason: "+frozenReason);
    }
    if(amt > balance){
     throw new InsufficientBalanceException(accountNumber, amt, balance);
    }
    balance=balance-amt;
    System.out.print("Amount withdrawn Successfully: "+amt);
}

public double getBalance(){
    return balance;
}

public boolean isFrozen(){
    return isFrozen;
}

public void freezeAccount(String reason){
    isFrozen=true;
    frozenReason=reason;
    System.out.println("Account Frozen "+accountNumber+" on "+System.currentTimeMillis());
}

public void unfreezeAccount(){
   isFrozen=false;
   frozenReason="";
   System.out.print(accountHolderName+" Account unfrozen on "+System.currentTimeMillis());
}
}
class BankingService{
   
public void transferFunds(String fromacc, String toacc, double amt)throws AccountNotExists{
        if(fromacc==null && toacc==null){
            throw new AccountNotExists(fromacc, toacc);
        }
       // if(isFrozen()){

       // }
    }


}

class Transaction{

}
public class ExceptionHandling {
    public static void main(String[] args) {
        Account acc1=new Account("SBI1", "seelan", 1000, true, "No Active transaction");
        acc1.deposit(1000);
        try{
        acc1.withdraw(3000);
        }
        catch(InsufficientBalanceException e){
            System.out.println(e);
        }
        catch(AccountFrozenException e){
            System.out.print(e);
        }
      
    }
    
}
 
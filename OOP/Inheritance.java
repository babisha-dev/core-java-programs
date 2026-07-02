package OOP;
 class BankAccount{
    protected int acc_num;
    protected double balance;
    protected String customer_name;
    public BankAccount(int acc_num, double balance, String customer_name){
        this.acc_num=acc_num;
        this.balance=balance;
        this.customer_name=customer_name;
    }

    public void deposit(double amt){
        balance+=amt;
        System.out.println("The amount "+ amt+" deposited successfuly");
    }
    public void withdraw(double amt){
        if((balance-amt)>0){
             balance =balance-amt;
             System.out.println("The amount "+ amt +" is successfully withdrawn from account"+acc_num +" : "+ customer_name + " Balance Amount:"+balance);
        }
        else
        System.out.println(" No Sufficient balance ");
    }
    public double calc_Interest(){
return 0;    }
    public void checkBalance(){
        System.out.println("The balance is: "+balance);
    }
}


class SavingsAccount extends BankAccount {

public SavingsAccount(int acc_num, double balance, String customer_name){
super(acc_num, balance, customer_name);
}

    public void withdraw(double amt){
    if((balance-amt)>500){
             balance =balance-amt;
             System.out.println("The amount "+ amt +" is successfully withdrawn " + " from account "+acc_num +" : "+ customer_name +" Balance Amount:"+balance);
        }
        else
        System.out.println("Minimum balance of 500 required to withdraw "+amt );
    }
     public double calc_Interest(){
        return balance*0.04;
    }
}

class CurrentAccount  extends BankAccount{

    private double overdraft=0;
   private double overdraft_limit=5000;

    public CurrentAccount(int acc_num, double balance, String customer_name){
        super(acc_num, balance, customer_name);
    }

    public void withdraw(int amt){
         if((balance-amt)>=0){
            balance=balance-amt;
            System.out.println("Amount withdrawn from account : "+acc_num+" \nBalance: "+balance);
        }
        else if((amt-balance)<=overdraft_limit ){
            overdraft=overdraft+amt-balance;
             balance =amt-overdraft-balance;
             System.out.println("The amount "+ amt +" is successfully withdrawn " + " from account : "+acc_num +" , account holder : "+ customer_name +" with \n Overdraft :"+overdraft+ " \n Balance Amount:"+balance);
        }
        else 
        System.out.println("No sufficient Amount to withdraw ");
  
    }

} 

class OopTest1Inheritance{
    public static void main(String[] args) {
        BankAccount acc1=new BankAccount(622201, 1000, "Babisha");
        acc1.deposit(100);
        acc1.checkBalance();
        acc1.withdraw(50);
        acc1.calc_Interest();
        SavingsAccount sav1=new SavingsAccount(622201, 1000, "Babin");
        sav1.withdraw(100);
        sav1.calc_Interest();
        sav1.withdraw(500);
        CurrentAccount cur1=new CurrentAccount(622201, 1000, "seelan");
        cur1.withdraw(5500);
    }

    
}
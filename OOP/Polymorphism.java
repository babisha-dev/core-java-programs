package OOP;

abstract class Payment{
    protected double amount;
    protected int transactionId;
    public Payment(double amount, int transactionId){
        this.amount=amount;
        this.transactionId=transactionId;
    }
    abstract void processPayment(double amt);
    abstract double calculateFee(double amt);

}

class CreditCardPayment extends Payment{
public CreditCardPayment(double amount, int transactionId){
    super(amount, transactionId);
}
double fee=0.02;
    public void processPayment(double amt){
            double fee=calculateFee(amt) + amt;
        System.out.println("Processing payment via credit card \n Total amount : "+fee+"\n Fee : "+calculateFee(amt));
    }
     public double calculateFee(double amount){
    return fee*amount;
    }

}

class PaypalPayment extends Payment{
public PaypalPayment(double amount, int transactionId){
    super(amount, transactionId);
}
double fee=0.02;
    public void processPayment(double amt){
            double fee=calculateFee(amt) + amt;
        System.out.println("Processing payment via paypal \n Total amount : "+fee+"\n Fee : "+calculateFee(amt));
    }
     public double calculateFee(double amount){
    return fee*amount;
    }

}

class ProcessPayment{
    private double totalFees=0;
   public void processPayment(Payment payment){
      payment.processPayment(payment.amount );
      totalFees+=payment.calculateFee(payment.amount);
   }
   public double cal_fee(){
    return totalFees;
   }
}
public class Polymorphism {
public static void main(String[] args) {
    Payment[] p= {new CreditCardPayment(1000, 0),
              new PaypalPayment(2000, 1)
};

ProcessPayment p1=new ProcessPayment();
for(Payment pay:p){
p1.processPayment(pay);
}
System.out.println("Total Fees: "+p1.cal_fee());
}
}
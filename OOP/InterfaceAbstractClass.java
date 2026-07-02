package OOP;
abstract class PaymentGateway{
   // private int merchantId;
  //  private String apiKey;
    protected double transactionFee;
    public PaymentGateway(int merchantId, String apiKey, double transactionFee){
   // this.merchantId=merchantId;
   // this.apiKey=apiKey;
    this.transactionFee=transactionFee;
    }

    abstract public void authenticate(String credentials);
    abstract public void processPayment(double amount);
    abstract public void refund(String transactionId);

    public boolean validateTransaction(double amount){
          return amount > 0;
}
}

class PayPalGateway extends PaymentGateway{
    private static double transactionFee=0.29;
    private double fixedFee=0.30;
    public PayPalGateway(int merchantId, String apiKey){
        super(merchantId, apiKey,transactionFee);

    }
    public void processPayment(double amount){
     if(!validateTransaction(amount)){
        throw new IllegalArgumentException("Invalid amount");
     }
     double fee=amount *transactionFee+ fixedFee;
     double total=amount+fee;

     System.out.println("Amount: "+amount);
        System.out.println("Fee: "+fee);
        System.out.println("Total Amount: "+total);

    }

    public void authenticate(String email){
        if(email !=null && email.contains("@")){
             System.out.println("Email is valid");
        }
        else
            throw new IllegalArgumentException("Email Not valid");
    }

    public void refund(String TransactionId){

    }
}

class StripeGateway extends PaymentGateway{
    private static double transactionFee=0.29;
    public StripeGateway(int merchantId, String apiKey){
        super(merchantId, apiKey, transactionFee);

    }
    public void processPayment(double amount){
     if(!validateTransaction(amount)){
        throw new IllegalArgumentException("Invalid amount");
     }
     double fee=amount *transactionFee;
     double total=amount+fee;

     System.out.println("Amount: "+amount);
        System.out.println("Fee: "+fee);
        System.out.println("Total Amount: "+total);

    }

    public void authenticate(String otp){
      if(otp!=null && otp.matches("\\d{6}")){
        System.out.println("OTP valid");
      }
      else
        throw new IllegalArgumentException("not valid otp");
    }

    public void refund(String TransactionId){

    }
}


class RazorPayGateway extends PaymentGateway{
    private static double transactionFee=0.02;
    public RazorPayGateway(int merchantId, String apiKey){
        super(merchantId, apiKey, transactionFee);

    }
    public void processPayment(double amount){
     if(!validateTransaction(amount)){
        throw new IllegalArgumentException("Invalid amount");
     }
     double fee=amount *transactionFee;
     double total=amount+fee;

     System.out.println("Amount: "+amount);
        System.out.println("Fee: "+fee);
        System.out.println("Total Amount: "+total);

    }

    public void authenticate(String jwt){
   if(jwt!=null && jwt.startsWith("JWT-")){
    System.out.println("Jwt valid");
   }
   else
    throw new IllegalArgumentException("Token not valid");
    }

    public void refund(String TransactionId){

    }
}


class PaymentProcess{
    public void processPayment(PaymentGateway payment, double amt){
       payment.processPayment(amt);
    }
}
public class InterfaceAbstractClass {
    public static void main(String[] args) {
        PaymentProcess p1=new PaymentProcess();
        PaymentGateway[] payment={new PayPalGateway(1, "paypal-98"),
            new RazorPayGateway(2, "razor-93"),
            new StripeGateway(3, "stripe-34")
        };
        for(PaymentGateway pay:payment){
            p1.processPayment(pay, 1000);
        }
        
    
}
    
}

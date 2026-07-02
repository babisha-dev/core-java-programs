package OOP;
import java.util.Scanner;


public class OopTest {

    public static double toFahrenheit(double c)
{
    return (c * 9.0 / 5) + 32;
}
    public static double toCelsius(double f)
{
    return (f - 32) * 5.0 / 9;
}
public static boolean areEquals(double temp1,char unit1,double temp2,char unit2){
    double inCelsius1 = (unit1 == 'C') ? temp1 : toCelsius(temp1);
        double inCelsius2 = (unit2 == 'C') ? temp2 : toCelsius(temp2);
        return Math.abs(inCelsius1 - inCelsius2) < 0.0001;
}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double c=sc.nextDouble();
        double f=sc.nextDouble();

        System.out.println("Fahrenheit"+toFahrenheit(c));
         System.out.println("celsius"+toCelsius(f));
         System.out.print(areEquals(c,'C', f, 'F'));

sc.close();

        
    }
}
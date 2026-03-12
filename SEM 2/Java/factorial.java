import java.util.Scanner;
public class factorial{
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }   
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=scanner.nextInt();
        System.out.println("Factorial of "+n+" is: "+factorial(n));
        scanner.close();
    }
}
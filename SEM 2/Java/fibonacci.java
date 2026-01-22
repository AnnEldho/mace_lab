import java.util.Scanner;
public class fibonacci{
    public static int fibonacci(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }   
        return fibonacci(n-1)+fibonacci(n-2);
    }   
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=scanner.nextInt();
        System.out.println(n+"th Fibonacci number is: "+fibonacci(n));
        scanner.close();
    }   
}
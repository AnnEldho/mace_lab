
import java.util.Scanner;

// functio for Multiplication table of a number
public class mult{
    public int multiply(int n, int i){
        if(i>10){
            return 0;
        }
        System.out.println(n+" x "+i+" = "+(n*i));
        return multiply(n, i+1);
    }   
    public static void main(String[] args) {
        mult m=new mult();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=scanner.nextInt();
        System.out.println("Multiplication Table:");
        m.multiply(n, 1);
        scanner.close();
    }
}
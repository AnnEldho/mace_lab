//function to find a number is prime
import java.util.Scanner;
public class prime {
    public  boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prime p=new prime();
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (p.isPrime(n)) {
            System.out.println(n + " is a Prime number");
        } else {
            System.out.println(n + " is not a Prime number");
        }
        sc.close();
    }
}

import java.util.*;

class NegativeException extends Exception {
    NegativeException(String msg) {
        super(msg);
    }
}

class pgm21 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of integers:");
        int n = sc.nextInt();

        int sum = 0;
        int count = 0;

        while (count < n) {
            try {
                System.out.println("Enter number:");
                int num = sc.nextInt();

                if (num < 0)
                    throw new NegativeException("Negative number not allowed");

                sum += num;
                count++;   // count only valid numbers
            }

            catch (NegativeException e) {
                System.out.println("Exception: " + e.getMessage());
                // does not increase count, asks again
            }
        }

        double avg = (double) sum / n;
        System.out.println("Average = " + avg);

        sc.close();
    }
}

/*
Enter number of integers:
5
Enter number:
1
Enter number:
2
Enter number:
-3
Exception: Negative number not allowed
Enter number:
8
Enter number:
0
Enter number:
6
Average = 3.4
*/
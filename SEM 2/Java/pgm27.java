import java.io.*;
import java.util.*;

class pgm27 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter word to search: ");
        String search = sc.nextLine();

        System.out.print("Enter word to replace: ");
        String replace = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("f1.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("f2.txt"));

        String line;
        int count = 0;

        while ((line = br.readLine()) != null) {

            while (line.contains(search)) {
                line = line.replaceFirst(search, replace);
                count++;
            }

            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        System.out.println("Replacements made: " + count);
    }
}
/*javac pgm27.java
user@user-OptiPlex-5000:~/Desktop/mace_lab-main/mace_lab/SEM 2/Java$ java pgm27
Enter word to search: java
Enter word to replace: python
Replacements made: 3 */
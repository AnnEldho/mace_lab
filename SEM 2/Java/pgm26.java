import java.io.*;

class pgm26 {

    public static void main(String[] args) throws Exception {

        BufferedInputStream in = new BufferedInputStream(new FileInputStream("input.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output.txt"));

        int ch;

        while ((ch = in.read()) != -1) {
            char c = (char) ch;
            c = Character.toUpperCase(c);
            out.write(c);
        }

        in.close();
        out.close();

        System.out.println("File copied with uppercase!");
    }
}
/*
javac pgm26.java
user@user-OptiPlex-5000:~/Desktop/mace_lab-main/mace_lab/SEM 2/Java$ java pgm26
File copied with uppercase!
 */
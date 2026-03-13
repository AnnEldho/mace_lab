/*write a java pgm that create two thread to perform the following;
thread a (extending thread) print square of nos from 1 to 10 with a delay of 500ms btw each print
thread b(implementing runnable) print cubes of nos from 1 to 10 with delay 700ms btw each print
main thread must ensure that the msg "calculatio completed!" is only printed aftter both thraed have finished their execution*/

class Square extends Thread{
    @Override
    public void run(){
        System.out.println("---Square of number 1 to 10---");
        for(int i =1;i<=10;i++){
            System.out.println("Square of "+i +"-"+(i*i));
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Cube implements Runnable{
    @Override
    public void run(){
        System.out.println("---Cube of number 1 to 10---");
        for(int i =1;i<=10;i++){
            System.out.println("Cube of "+i +"-"+(i*i*i));
            try {
                Thread.sleep(700);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }    
    }
}

public class pgm23 {

    public static void main(String[] args) throws InterruptedException {

        Square t1 = new Square();
        Cube c = new Cube();
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Calculation completed!");
    }
}
/*
---Square of number 1 to 10---
---Cube of number 1 to 10---
Square of 1-1
Cube of 1-1
Square of 2-4
Cube of 2-8
Square of 3-9
Cube of 3-27
Square of 4-16
Square of 5-25
Cube of 4-64
Square of 6-36
Cube of 5-125
Square of 7-49
Cube of 6-216
Square of 8-64
Square of 9-81
Cube of 7-343
Square of 10-100
Cube of 8-512
Cube of 9-729
Cube of 10-1000
Calculation completed!*/
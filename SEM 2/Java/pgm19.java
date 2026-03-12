import java.util.*;

class pgm19 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer,String> students = new HashMap<>();

        int ch,id;
        String name;

        do{
            System.out.println("\n1.Add Student  2.Search by ID  3.Display  4.Exit");
            ch = sc.nextInt();
            sc.nextLine();

            switch(ch){

                case 1:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    students.put(id,name);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    if(students.containsKey(id))
                        System.out.println("Name: "+students.get(id));
                    else
                        System.out.println("Not Found");
                    break;

                case 3:
                    System.out.println(students);
                    break;
            }

        }while(ch!=4);
    }
}
/*
1.Add Student  2.Search by ID  3.Display  4.Exit
1
Enter ID: 1
Enter name: abhijith

1.Add Student  2.Search by ID  3.Display  4.Exit
1
Enter ID: 2
Enter name: abhinav

1.Add Student  2.Search by ID  3.Display  4.Exit
1
Enter ID: 3
Enter name: abhirami

1.Add Student  2.Search by ID  3.Display  4.Exit
2
Enter ID: 2
Name: abhinav

1.Add Student  2.Search by ID  3.Display  4.Exit
3
{1=abhijith, 2=abhinav, 3=abhirami}

*/
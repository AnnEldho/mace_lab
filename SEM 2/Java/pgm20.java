import java.util.*;

class Attendee {
    String name,email;
    int registrationId;

    Attendee(String n,String e,int id){
        name=n;
        email=e;
        registrationId=id;
    }
@Override
    public int hashCode(){
        return registrationId;
    }
    public boolean equals(Object o){
        Attendee a = (Attendee)o;
        return registrationId == a.registrationId;
    }
@Override
    public String toString(){
        return registrationId+" "+name+" "+email;
    }
}

class pgm20 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        HashSet<Attendee> set = new HashSet<>();

        int ch;

        do{
            System.out.println("\n1.Add Attendee  2.Display  3.Exit");
            ch = sc.nextInt();
            sc.nextLine();

            if(ch==1){
                System.out.print("Name: ");
                String n=sc.nextLine();

                System.out.print("Email: ");
                String e=sc.nextLine();

                System.out.print("Registration ID: ");
                int id=sc.nextInt();

                set.add(new Attendee(n,e,id));
            }

            if(ch==2){
                for(Attendee a:set)
                    System.out.println(a);
            }

        }while(ch!=3);
    }
}
/*
1.Add Attendee  2.Display  3.Exit
1
Name: Ann
Email: ann@gmail.com
Registration ID: 101

1.Add Attendee  2.Display  3.Exit
1
Name: Appu
Email: app2gmail.com
Registration ID: 102

1.Add Attendee  2.Display  3.Exit
1
Name: Apsara
Email: apsara@gmail.com
Registration ID: 102

1.Add Attendee  2.Display  3.Exit
2
101 Ann ann@gmail.com
102 Appu app2gmail.com
*/
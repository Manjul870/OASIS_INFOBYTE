import java.util.Scanner;

public class Login_Form {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------LOGIN FORM-----------------------------------------");
        System.out.print("Enter Username: ");
        String userId=sc.next();;
        sc.nextLine();
        System.out.print("Enter Password: ");
        String password=sc.nextLine();
        DataAccess data=new DataAccess();
        if(data.CheckLoginDetails(userId,password)){
            do {
                    System.out.println("-----------------------------------------ONLINE RESERVATION SYSTEM-------------------------------------------");
                    System.out.println("Welcome " + userId + "/n Would you like to make a reservation: Type 1");
                    System.out.println("If you want to cancel your reservation: Type 2");
                    System.out.println("If you want to exit: Type 3");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.println("-----------------------------------------RESERVATION FORM-------------------------------------------");
                        Resevation.Form();
                        return;
                    } else if (choice == 2) {
                        System.out.println("-----------------------------------------CANCELLATION FORM-------------------------------------------");
                        Cancellation_Form.Cancellation_Form();
                        return;
                    }else if(choice==3){
                        System.out.println("-----------------------------------------EXIT---------------------------------------------------------");
                        return;
                    }
                    else {
                        System.out.println("Invalid Choice Please Try Again");
                    }
                }while(true);
            }
            else{
                System.out.println("Invalid Username or Password");
            }
    }
}

package Online_Examination;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------Login Page------------------------------------------------------------------------------------");
        System.out.print("Enter the User Id: ");
        String UserId=sc.nextLine();
        System.out.print("Enter the Password: ");
        String Password=sc.nextLine();
        if(Login.CheckLoginDetails(UserId,Password)) {
            while (true) {
                System.out.println("Press 1 for Update Profile");
                System.out.println("Press 2 for Participate in Examination");
                System.out.println("Press 2 for Closed the Session");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("--------------------------------------------------------Update Profile and Password-------------------------------------------------------------------------");
                        Update_Profile_and_Password.Update_Profile_and_Password(UserId);
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("--------------------------------------------------------Exam-------------------------------------------------------------------------");
                        Question_Paper.Exam();
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 3:
                        System.out.println("Session Closed");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        return;

                }
            }
        }
        else{
                System.out.println("Wrong Username or Password");
            }
    }
}

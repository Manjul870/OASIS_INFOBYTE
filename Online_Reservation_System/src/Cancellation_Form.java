import java.util.Scanner;

public class Cancellation_Form {
    public static void Cancellation_Form() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter PNR Number: ");
        String pnr_Number=sc.nextLine();
        DataAccess data=new DataAccess();
        if(data.isPnrExist(pnr_Number)){
            System.out.println("---------------------------------------------------DETAILS----------------------------------");
            data.getDetails(pnr_Number);
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("Enter OK: ");
            String choice=sc.nextLine();
            if(choice.equalsIgnoreCase("OK")){
                data.deleteDetails(pnr_Number);
            }
        }
        else{
            System.out.println("Invalid PNR Number!");
            System.out.println("-------------------------------------------------------------------------------------");

        }

    }

    public static void main(String[] args) {
        Cancellation_Form();
    }
}

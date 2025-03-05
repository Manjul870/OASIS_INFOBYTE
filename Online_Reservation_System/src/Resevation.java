import java.util.Random;
import java.util.Scanner;

public class Resevation {
    static DataAccess data=new DataAccess();
    public static void Form(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Resevation Details: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Gender(M/F): ");
        String gender= sc.nextLine();

        System.out.print("Enter Train Number: ");
        int train_Number = sc.nextInt();
        String train_Name= data.getTrainName(train_Number);
        if(train_Name == null){
            System.out.print("Invalid Train Number! ");
            return;
        }
        System.out.print("Train Name: "+train_Name+"\n");
        sc.nextLine();
        System.out.print("Enter Class Type (Sleeper/AC/General): ");
        String class_Type = sc.nextLine();
        System.out.print("Enter Date of Journey(YYYY-MM_DD): ");
        String date_Of_Journey = sc.nextLine();

        System.out.print("Enter from Station: ");
        String from_Station = sc.nextLine();

        System.out.print("Enter To Station: ");
        String to_Station = sc.nextLine();
        String pnr_Number=pnrGenerator(train_Number,to_Station,from_Station);
        System.out.print("Type Insert Button ");
        String choice=sc.nextLine();
        if(choice.toUpperCase().equalsIgnoreCase("INSERT")){
            if(data.InsertReservation(pnr_Number.toUpperCase(),name.toUpperCase(),age,gender.toUpperCase(),train_Number,train_Name,class_Type.toUpperCase(),date_Of_Journey,from_Station.toUpperCase(),to_Station.toUpperCase())){
                System.out.println("Reservation Successful! Your PNR is: "+pnr_Number);
            }
            else{
                System.out.println("Reservation Failed!");
            }
        }
        else{
            System.out.print("You Entered Wrong Choice! ");
        }


    }
    //Method for PNR Generator
    public static String pnrGenerator(int train_number,String to_Station,String from_Station){
        Random random = new Random();
        int unique_Number = 100000+random.nextInt(900000);
        String pnr = train_number+to_Station.substring(0,1).toUpperCase()+from_Station.substring(0,1).toUpperCase()+unique_Number;
        while(data.isPnrExist(pnr)){
            unique_Number = 100000+random.nextInt(900000);
            pnr = train_number+to_Station.substring(0,1).toUpperCase()+from_Station.substring(0,1).toUpperCase()+unique_Number;
        }
        return pnr;
    }
}

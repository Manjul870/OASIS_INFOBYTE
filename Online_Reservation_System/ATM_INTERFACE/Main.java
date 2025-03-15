package ATM_INTERFACE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Data_Accesss.SelectDatabase();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Acccount Number: ");
        String acccountNumber=sc.nextLine();
        System.out.print("Enter Password: ");
        String password=sc.nextLine();

            if (Login.CheckLoginDetails(acccountNumber, password)) {
                System.out.println("Login Successful");
                if(!Balance.isexistBalance(acccountNumber)){
                    Balance.InsertBalance(acccountNumber);
                }
                while(true) {
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("Enter 1 for Transaction History ");
                        System.out.println("Enter 2 for Withdrawn Money ");
                        System.out.println("Enter 3 for Deposit Money ");
                        System.out.println("Enter 4 for Transfer Money ");
                        System.out.println("Enter 5 for Exit");
                        System.out.println("-----------------------------------------------------------------------------------------");

                        int choice = sc.nextInt();
                        sc.nextLine();
                        int Amount ;
                        switch (choice) {
                            case 1:
                                Transactions_History.Transactions_History(acccountNumber);
                                break;
                            case 2:
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                Withdraw.withdraw(acccountNumber);
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                break;
                            case 3:
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                System.out.println("Enter Amount to Deposit Money: ");
                                Amount = sc.nextInt();
                                sc.nextLine();
                                if (Deposite.Deposite_Amount(acccountNumber, Amount,"deposite")) {
                                    System.out.println("Deposite Successful");
                                    Balance.BalanceUpdate(acccountNumber,Amount);
                                    System.out.println("Current Balance: "+Balance.GetBalance(acccountNumber));
                                }
                                else {
                                    System.out.println("Deposite Failed");
                                }
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                break;
                            case 4:
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");

                                System.out.println("Enter Account Number to Transfer Money: ");
                                String reciverAccountNumber=sc.nextLine();
                                System.out.println("Enter Amount to Transfer Money: ");
                                Amount = sc.nextInt();
                                sc.nextLine();

                                if(Login.isUserexist(reciverAccountNumber)) {
                                    if (!Balance.isexistBalance(reciverAccountNumber)) {
                                        Balance.InsertBalance(reciverAccountNumber);
                                    }
                                    if (Amount < Balance.GetBalance(acccountNumber)) {
                                        Transactions_History.AmountTransfer(acccountNumber, -Amount, "Withdraw");
                                        Balance.BalanceUpdate(acccountNumber, -Amount);
                                        Transactions_History.AmountTransfer(reciverAccountNumber, Amount, "Deposite");
                                        Balance.BalanceUpdate(reciverAccountNumber, Amount);
                                        System.out.println("Transfer Successful");
                                    } else {
                                        System.out.println("Not Sufficient Balance");
                                    }
                                }
                                else {
                                    System.out.println("Receiver Account Number not exist");
                                }

                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                break;
                            case 5:
                                Balance.GetBalance(acccountNumber);
                                return;
                }

                }
            } else {
                System.out.println("Login Credential is incorrect");
            }
        }

}



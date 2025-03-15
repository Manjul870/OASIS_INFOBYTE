package ATM_INTERFACE;

import java.util.Scanner;

public class Withdraw {
    public static void withdraw(String acccountNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Amount to Withdraw: ");
        int Amount = sc.nextInt();
        double balance = Balance.GetBalance(acccountNumber);
        //Error
        if(Amount > balance) {
            System.out.println("Insufficient Balance");
            return;
        }
        else {
            Balance.BalanceUpdate(acccountNumber, -Amount);
            System.out.println("Withdraw Successful");
            System.out.println("Update Balance: "+ Balance.GetBalance(acccountNumber));

        }
    }


}

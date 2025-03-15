package ATM_INTERFACE;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Balance {
    public static String query;

    public static double GetBalance(String Account_Number) {
        double Balance = 0;
        try {
            query = "SELECT Balance FROM Account_Balance WHERE Account_Number = ?";
            PreparedStatement pstmt = Data_Accesss.connect(query);
            pstmt.setString(1, Account_Number);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Balance = rs.getDouble("Balance");
            }
        } catch (Exception e) {
            System.out.println("Database Error in GetBalance Method in Balance");
            e.printStackTrace();
        }
        return Balance;
    }

    public static boolean BalanceUpdate(String Account_Number, double Amount) {
        String query = "UPDATE Account_Balance SET Balance = Balance + ? WHERE Account_Number = ?";
        try (PreparedStatement pstmt = Data_Accesss.connect(query)) {
            pstmt.setDouble(1, Amount);
            pstmt.setString(2, Account_Number);

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0; // Return true if update was successful
        } catch (Exception e) {
            System.err.println("Database Error in BalanceUpdate Method in Data_Accesss");
            e.printStackTrace();
            return false; // Return false in case of failure
        }
    }


    public static boolean isexistBalance(String Account_Number) {
        boolean exists = false;
        try {
            query = "Select * from Account_Balance WHERE Account_Number = ?";
            PreparedStatement pstmt = Data_Accesss.connect(query);
            pstmt.setString(1, Account_Number);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                exists = true;
            }
        }
        catch (Exception e) {
            System.out.println("Database Error in isexistBalance Method in Data_Accesss");
            e.printStackTrace();
        }
        return exists;
    }

    public static void InsertBalance(String Account_Number) {
        try {
            query = "Insert into Account_Balance(Account_Number, Balance) values( ?,?)";
            PreparedStatement pstmt = Data_Accesss.connect(query);
            pstmt.setString(1, Account_Number);
            pstmt.setDouble(2, 0.0);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Database Error in InsertBalance Method in Data_Accesss");
            e.printStackTrace();
        }
    }


}

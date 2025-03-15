package ATM_INTERFACE;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transactions_History {
    public static void Transactions_History(String Account_Number) {
        System.out.println("----------------------------------------Transactions_History of " + Account_Number +"---------------------------------------------------------------");
            try {
                String query = "SELECT * FROM Transactions Where Account_Number = ?";
                PreparedStatement pstmt = Data_Accesss.connect(query);
                pstmt.setString(1, Account_Number);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("Transaction_Id");
                    String Amount = rs.getString("Amount");
                    String Transaction_Type = rs.getString("Transaction_Type");
                    Date Date = rs.getDate("Transaction_Date");
                    String Location = rs.getString("ATM_Location");
                    String Status = rs.getString("Status");
                    System.out.println("Transactions_Id: "+id+"\n"+"Account_Number: "+Account_Number+"\nAmount: "+Amount);
                    System.out.println("Transaction_Type: "+Transaction_Type+"\nDate: "+Date+"\nLocation: "+Location+"\nStatus: "+Status);
                    System.out.println("----------------------------------------------------------------------------------------------------------------");
                }

            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

    }

    public static boolean AmountTransfer(String Account_Number,int amount,String type ) {
        boolean flag = false;
        try {
            String query = "INSERT INTO Transactions (Account_Number, Amount, Transaction_Type, ATM_Location,Status) VALUES (?,?,?,?,?)";
            PreparedStatement psmt = Data_Accesss.connect(query);
            psmt.setString(1, Account_Number);
            psmt.setInt(2, amount);
            psmt.setString(3,"Deposite");
            psmt.setString(4,type);
            psmt.setString(5,"Success");
            psmt.executeUpdate();
            flag = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}

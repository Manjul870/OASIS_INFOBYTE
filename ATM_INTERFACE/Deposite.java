package ATM_INTERFACE;

import java.sql.PreparedStatement;

public class Deposite {
   public static boolean Deposite_Amount(String Account_Number,int amount,String type) {
       boolean flag = false;
        try {
            String query = "INSERT INTO Transactions (Account_Number, Amount, Transaction_Type, ATM_Location,Status) VALUES (?,?,?,?,?)";
            PreparedStatement psmt = Data_Accesss.connect(query);
            psmt.setString(1, Account_Number);
            psmt.setInt(2, amount);
            psmt.setString(3,type);
            psmt.setString(4,"Lucknow");
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

package ATM_INTERFACE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static String query;
    public static Boolean CheckLoginDetails(String id,String passworduser){
            query="SELECT * FROM LoginDetails WHERE Account_Number = ?";
            PreparedStatement pstmt = Data_Accesss.connect(query);
            try{
                if(pstmt!=null) {
                    pstmt.setString(1, id);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        String Loginid = rs.getString("Account_Number");
                        if (Loginid.equals(id)) {
                            String password1 = rs.getString("Password");
                            if (passworduser.equals(password1)) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
            catch (SQLException e){
                System.out.println("Database Error in CheckLoginDetails Method in Data_Accesss");
                e.printStackTrace();
            }
            return false;
        }

    public static String GetUserName(String id){
        String name="";
        try{
            query="SELECT name FROM LoginDetails WHERE Account_Number = ?";
            PreparedStatement pstmt = Data_Accesss.connect(query);
            if(pstmt!=null) {
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    name = rs.getString("name");
                }
            }
        }
        catch (SQLException e){
            System.out.println("Database Error in CheckLoginDetails Method in Data_Accesss");
            e.printStackTrace();
        }
        return name;
    }

    public static boolean isUserexist(String Account_Number) {
        boolean exists = false;
        try {
            query = "Select * from LoginDetails WHERE Account_Number = ?";
            PreparedStatement pstmt = Data_Accesss.connect(query);
            pstmt.setString(1, Account_Number);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                exists = true;
            }
        }
        catch (Exception e) {
            System.out.println("Database Error in isUserExist Method in Login");
            e.printStackTrace();
        }
        return exists;
    }
}


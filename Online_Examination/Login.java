package Online_Examination;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public static String query;
    public static Boolean CheckLoginDetails(String id,String passwordUser){
        query="SELECT * FROM Users WHERE userId = ?";
        PreparedStatement pstmt = Data_Access.connect(query);
        try{
            if(pstmt!=null) {
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String Userid = rs.getString("UserId");
                    if (Userid.equals(id)) {
                        String password1 = rs.getString("Password");
                        if (passwordUser.equals(password1)) {
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

}

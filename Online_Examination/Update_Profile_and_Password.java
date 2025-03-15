package Online_Examination;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_Profile_and_Password {
    public static String query;
    public static void Update_Profile_and_Password(String loginId){
        System.out.println("Press 1 for Update Profile Name");
        System.out.println("Press 3 for Update Profile Password");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextInt();
        switch(choice){
            case 1:
                System.out.println("Previous Name: "+GetUserName(loginId));
                System.out.print("Enter New User Name: ");
                String UserName = input.nextLine();
                UpdateUserName(loginId,UserName);
                System.out.println("Enter New Password");
                break;
            case 2:
                System.out.print("Enter New Password: ");
                String password = input.nextLine();
                UpdatePassword(loginId,password);
        }
    }

    public static void UpdatePassword(String loginId, String password){
        query="UPDATE users SET Password = ? WHERE UserId = ?";
        try {
            PreparedStatement pstmt = Data_Access.connect(query);
            pstmt.setString(1, password);
            pstmt.setString(2, loginId);
            pstmt.executeUpdate();
            System.out.println("User Password Updated Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void UpdateUserName(String loginId, String UserName){
        query="UPDATE users SET User_Name = ? WHERE UserID = ?";
        try {
            PreparedStatement pstmt = Data_Access.connect(query);
            pstmt.setString(1, UserName);
            pstmt.setString(2, loginId);
            pstmt.executeUpdate();
            System.out.println("User Name Updated Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String GetUserName(String id){
        String name="";
        try{
            query="SELECT name FROM OnlineExamination WHERE LoginId = ?";
            PreparedStatement pstmt = Data_Access.connect(query);
            if(pstmt!=null) {
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    name = rs.getString("name");
                }
            }
        }
        catch (SQLException e){
            System.out.println("Database Error in Get UserName Method in Update_Profile_and_Password");
            e.printStackTrace();
        }
        return name;
    }
}

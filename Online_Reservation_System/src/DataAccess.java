import java.sql.*;

//Data Access Class is used for inserting and retrieving the Data From Data Base  OnlineReservationSystem
public class DataAccess {
    private static final String url="jdbc:mysql://localhost:3306/onlinereservationsystem";
    private static final String user="root";
    private static final String password="admin@123";

    public static void main(String[] args) {
        System.out.println(isPnrExist("PNR123455"));
        Resevation.Form();
    }


/*
    The method CheckLoginDetails takes the ID and password, and through the JDBC driver, it extracts the user ID and password from the database and validates them against the provided user ID and password.
    If all the details are correct, it forwards you to the Reservation class; otherwise, it terminates the program by showing an error
*/

    public static Boolean CheckLoginDetails(String id,String passworduser){
        try{
            Connection con=DriverManager.getConnection(url,user,password);
            Statement s=con.createStatement();
            String query = "SELECT * FROM LoginDetails WHERE Login_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String Loginid=rs.getString("Login_id");
                if(Loginid.equals(id)){
                    String password1=rs.getString("Password");
                    if(passworduser.equals(password1)){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else {
                    return false;
                }
            }


        }
        catch (SQLException e){
            System.out.println("Database Error 1");
            e.printStackTrace();
        }
        return false;
    }

    /*
        The getTrainName module helps you find the name of a train using the entered train number. It extracts train data from the Trains table and validates it against the entered train number.
        If the train number is correct, it returns the train name; otherwise, it returns an error message and terminates the program."
    */

    public static String getTrainName(int train_number){
        String Train_name=null;
        try{

            Connection con=DriverManager.getConnection(url,user,password);
            Statement s=con.createStatement();
            String query = "SELECT * FROM Trains WHERE Train_number = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, train_number);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Train_name=rs.getString("Train_name");
            }
        }
        catch (SQLException e){
            System.out.println("Database Error in GetTrainName Module");
            e.printStackTrace();
        }
        return Train_name;
    }

    public static boolean InsertReservation(String pnr_Number,String name,int age,String gender,int train_number,String train_name,
                                         String classType,String journeyDate,String fromStation, String toStation){
        String query = "INSERT INTO reservation (`pnr_number`, `passenger_name`, `age`, `gender`, `train_number`, `train_name`, `class_type`, `journey_date`, `from_station`, `to_station`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection con=DriverManager.getConnection(url,user,password);
            Statement s=con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, pnr_Number);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, gender);
            pstmt.setInt(5, train_number);
            pstmt.setString(6, train_name);
            pstmt.setString(7, classType);
            pstmt.setString(8, journeyDate);
            pstmt.setString(9, fromStation);
            pstmt.setString(10, toStation);
            int rowInserted=pstmt.executeUpdate();
            return rowInserted>0;
        }
        catch (SQLException e){
            System.out.println("Database Error in InsertReservation Module");
            e.printStackTrace();
        }
        return false;
    }
    public static boolean isPnrExist(String pnr){
        String query = "SELECT 1 FROM reservation WHERE pnr_number = ? LIMIT 1";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, pnr);
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean exists = rs.next();
                return exists; // Returns true if a record exists

            }
        } catch (SQLException e) {
            System.err.println("Database Error in isPnrExist Module: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    //Get Details For Cancellation Form
    public static void getDetails(String pnr_number){
        try{

            Connection con=DriverManager.getConnection(url,user,password);
            Statement s=con.createStatement();
            String query = "SELECT * FROM Reservation WHERE pnr_number = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, pnr_number);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                System.out.println("PNR_Number: "+pnr_number);
                String name = rs.getString("Passenger_name");
                System.out.println("Name: "+name);
                int age = rs.getInt("age");
                System.out.println("Age: "+age);
                String gender = rs.getString("gender");
                System.out.println("Gender: "+gender);
                String train_number = rs.getString("train_number");
                System.out.println("Train_Number: "+train_number);
                String train_name = rs.getString("train_name");
                System.out.println("Train_Name: "+train_name);
                String classType = rs.getString("class_type");
                System.out.println("ClassType: "+classType);
                String journeyDate = rs.getString("journey_date");
                System.out.println("Journey Date: "+journeyDate);
                String fromStation = rs.getString("from_station");
                System.out.println("From Station: "+fromStation);
                String toStation = rs.getString("to_station");
                System.out.println("To Station: "+toStation);
            }


        }
        catch (SQLException e){
            System.out.println("Database Error in GetTrainName Module");
            e.printStackTrace();
        }
    }

    //Remove Pnr Number Corresponding Data
    public static void deleteDetails(String pnr_number){
        try{
            Connection con=DriverManager.getConnection(url,user,password);
            Statement s=con.createStatement();
            String query = "DELETE FROM reservation WHERE pnr_number = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, pnr_number);
            int rowDeleted=pstmt.executeUpdate();
            System.out.println("Cancellation of Reservation "+pnr_number+" is Successful!");
        }
        catch(Exception e){
            System.out.println("Database Error in DeleteDetails Module");
        }

    }
}

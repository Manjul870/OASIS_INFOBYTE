package Online_Examination;
import java.sql.*;

public class Data_Access {
        private static final String URL = "jdbc:mysql://localhost:3306/OnlineExamination";
        private static final String USER = "root";
        private static final String PASSWORD = "admin@123";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        public static PreparedStatement connect(String query) {
            try {
                Connection con = getConnection();
                return con.prepareStatement(query);
            } catch (SQLException e) {
                System.err.println("Database Connection Error in Data_Accesss.connect()");
                e.printStackTrace();
                return null;
            }
        }

        public static void SelectDatabase() {
            String query = "USE OnlineExamination";
            try (Connection con = getConnection();
                 Statement stmt = con.createStatement()) {
                stmt.executeUpdate(query);
            } catch (SQLException e) {
                System.err.println("Please Create Database ATM. Read the ATM setup file for details.");
                e.printStackTrace();
            }
        }
}


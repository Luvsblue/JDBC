import java.sql.*;

public class JDBCExample {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    static final String USER = "root";
    static final String PASS = "Muthu21@";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS Employee (" +
                    "Empcode INT NOT NULL, " +
                    "Empname VARCHAR(255), " +
                    "Empage INT, " +
                    "Esalary INT, " +
                    "PRIMARY KEY (Empcode))";
            stmt.executeUpdate(sql);

            String[] empCodes = {"101", "102", "103", "104", "105"};
            String[] empNames = {"Jenny", "Jacky", "Jeo", "John", "Shameer"};
            int[] empAges = {25, 30, 20, 40, 25};
            int[] empSalaries = {10000, 20000, 40000, 80000, 90000};

            for (int i = 0; i < empCodes.length; i++) {
                sql = "INSERT INTO Employee (Empcode, Empname, Empage, Esalary) VALUES (" +
                        "'" + empCodes[i] + "', '" + empNames[i] + "', '" + empAges[i] + "', '" + empSalaries[i] + "')";
                stmt.executeUpdate(sql);
            }

            System.out.println("Data inserted successfully.");

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

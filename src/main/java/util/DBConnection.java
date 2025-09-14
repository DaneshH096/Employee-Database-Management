package util;
import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://yamabiko.proxy.rlwy.net:30287/employee";
    private static final String USER = "root";
    private static final String PASS = "PxHBkIqxkTYhesMquZHGVTmZIUybLhZv";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
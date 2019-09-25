package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() { ///method is used to get DB connection
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/waterstock_db";
        String userName = "root";
        String password = "root";
        Connection con = null;
        try {
            Class.forName(driverClassName);
            con = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(con);
        return con;
    }
    public static  void close(Connection con, PreparedStatement pst) { ///method is used to close DB connection
        try {
            if (pst != null)
                pst.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


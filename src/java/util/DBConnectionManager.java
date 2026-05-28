package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Simple Oracle DB connection manager.
 * Configure the URL/USER/PASS below before running.
 */
public class DBConnectionManager {

    // TODO: update these values to match your Oracle DB
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "wms_user";
    private static final String PASS = "wms_password";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Oracle JDBC Driver not found: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

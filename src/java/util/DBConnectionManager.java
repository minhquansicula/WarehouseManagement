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
    // Format: jdbc:oracle:thin:@hostname:port:SID or jdbc:oracle:thin:@hostname:port/serviceName
    // Example SID (older): jdbc:oracle:thin:@localhost:1521:XE
    // Example Service Name (newer): jdbc:oracle:thin:@localhost:1521:XEPDB1
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";
    private static final String PASS = "12345";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            // Don't fail class initialization here so we can show a clearer runtime error
            System.err.println("Oracle JDBC Driver not found: " + e.getMessage());
            System.err.println("Please add the Oracle JDBC driver JAR (ojdbc8.jar or ojdbc11.jar) to WEB-INF/lib or the container classpath.");
        }
    }

    private static boolean driverAvailable;

    static {
        try {
            Class.forName(DRIVER);
            driverAvailable = true;
        } catch (ClassNotFoundException e) {
            driverAvailable = false;
        }
    }

    public static Connection getConnection() throws SQLException {
        if (!driverAvailable) {
            throw new SQLException("JDBC driver not available. Add the Oracle JDBC driver JAR (ojdbc8.jar/ojdbc11.jar) to WEB-INF/lib or the container lib.");
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

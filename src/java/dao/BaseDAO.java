package dao;

import java.sql.Connection;
import java.sql.SQLException;
import util.DBConnectionManager;

/**
 * Base DAO providing connection helper methods.
 */
public abstract class BaseDAO {

    protected Connection getConnection() throws SQLException {
        return DBConnectionManager.getConnection();
    }

    protected void closeQuietly(AutoCloseable ac) {
        if (ac != null) {
            try { ac.close(); } catch (Exception e) { /* ignore */ }
        }
    }
}

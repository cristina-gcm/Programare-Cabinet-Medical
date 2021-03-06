package cabinet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbSQL {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cabinetmedical";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection databaseConnection;

    private dbSQL() {
    }

    public static Connection getDatabaseConnection() {
        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return databaseConnection;
    }

    public static void closeDatabaseConnection() {
        try {
            if (databaseConnection != null && !databaseConnection.isClosed()) {
                databaseConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


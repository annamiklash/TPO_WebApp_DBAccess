package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static common.Constants.DRIVER;
import static common.Constants.PASSWORD;
import static common.Constants.URL;
import static common.Constants.USER_NAME;

public class ConnectionSingleton {

    private static Connection instance;

    public static Connection getInstance() {
        if (instance == null) {
            try {
                Class.forName(DRIVER);
                instance = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                instance.setAutoCommit(false);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}

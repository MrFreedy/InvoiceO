package service.database;

import java.sql.*;

public class DTBConnection {

    public static String url;
    public static String user;
    public static String password;


    public DTBConnection(String url, String user, String password) {
        DTBConnection.url = url;
        DTBConnection.user = user;
        DTBConnection.password = password;

    }

    public static void connection_test() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database !");
            } else {
                System.out.println("Failed to make connection !");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection connect() throws SQLException {
        DTBConnection dtbConnection = new DTBConnection(url, user, password);
        return DriverManager.getConnection(url, user, password);
    }

}


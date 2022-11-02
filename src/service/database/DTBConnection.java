package service.database;

import java.sql.*;

public class DTBConnection {

    public static String url;
    public static String user;
    public static String password;


    public DTBConnection(String url, String user, String password) {
        this.url = "jdbc:mysql://"+url;
        this.user = user;
        this.password = password;

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

    public static void close() {
        try {
            DriverManager.getConnection(url, user, password).close();
            System.out.println("Disconnect from the database !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection connect() throws SQLException {
        DTBConnection dtbConnection = new DTBConnection("db-mysql-lon1-83723-do-user-12354957-0.b.db.ondigitalocean.com:25060/invoice", user, password);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;




    }

}


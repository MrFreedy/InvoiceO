package service.database;

import java.sql.*;

public class DTBConnection {

    private static String url;
    private static String user;
    private static String password;


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

    public static Connection connect() throws SQLException {
        Connection conn= DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void close() {
        try {
            DriverManager.getConnection(url, user, password).close();
            System.out.println("Disconnect from the database !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public void createInvoice() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO invoice (id, date, customer_id, total) VALUES (1, '2020-01-01', 1, 100)";
            stmt.executeUpdate(sql);
            System.out.println("Invoice created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

}


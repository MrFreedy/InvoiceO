package service.database;

import java.sql.*;
import java.util.Scanner;

import controller.MainApp;
import service.database.DTBConnection;
import controller.start.Initialization;



public class DTBActions {
    private static String customer_name, customer_address, seller_name, seller_address, product_name,date_sale,date_expiry ;
    private static int product_quantity;

    private static double price;




    public static void createInvoice(){

        System.out.println("Please enter the customer name :");
        Scanner customer_name_in = new Scanner(System.in);
        customer_name=customer_name_in.nextLine();
        System.out.println("Please enter the customer address :");
        Scanner customer_address_in = new Scanner(System.in);
        customer_address=customer_address_in.nextLine();

        System.out.println("Please enter the seller name :");
        Scanner seller_name_in = new Scanner(System.in);
        seller_name=seller_name_in.nextLine();

        System.out.println("Please enter the seller address :");
        Scanner seller_address_in = new Scanner(System.in);
        seller_address=seller_address_in.nextLine();

        System.out.println("Please enter the product name :");
        Scanner product_name_in = new Scanner(System.in);
        product_name=product_name_in.nextLine();

        System.out.println("Please enter the product quantity :");
        Scanner product_quantity_in = new Scanner(System.in);
        product_quantity=product_quantity_in.nextInt();

        System.out.println("Please enter the price :");
        Scanner price_in = new Scanner(System.in);
        price=price_in.nextDouble();

        System.out.println("Please enter the date of sale :");
        Scanner date_sale_in = new Scanner(System.in);
        date_sale=date_sale_in.nextLine();

        System.out.println("Please enter the date of expiry :");
        Scanner date_expiry_in = new Scanner(System.in);
        date_expiry=date_expiry_in.nextLine();



        DTBConnection dtbConnection = new DTBConnection("localhost:3306/invoice", "root", "");
        try(Connection conn = dtbConnection.connect()) {
            Statement stmt = conn.createStatement();{
                String sql= "INSERT INTO garage_michel (customerName, customerAdress, sellerName, sellerAdress, product, quantity, price, dateSale, dateExpiry) VALUES ('"+customer_name+"', '"+customer_address+"', '"+seller_name+"', '"+seller_address+"', '"+product_name+"', '"+product_quantity+"', '"+price+"', '"+date_sale+"', '"+date_expiry+"')";
                stmt.executeUpdate(sql);
                System.out.println("Invoice created");
                Initialization.restart();

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    public static void deleteInvoice() throws SQLException {
        DTBConnection dtbConnection = new DTBConnection("localhost:3306/invoice", "root", "");
        try(Connection conn = dtbConnection.connect()) {
            Statement stmt = conn.createStatement();{
                String sql = "DELETE FROM garage_michel WHERE idInvoice = 1";
                stmt.executeUpdate(sql);
                System.out.println("Invoice deleted");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayAllInvoices() throws SQLException {
        DTBConnection dtbConnection = new DTBConnection("localhost:3306/invoice", "root", "");
        try(Connection conn = dtbConnection.connect()) {
            Statement stmt = conn.createStatement();{
                String sql = "SELECT * FROM garage_michel";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(rs.getInt("idInvoice") + "|\t" + rs.getString("customerName") + "|\t" + rs.getString("customerAdress") + "|\t" + rs.getString("sellerName") + "|\t" + rs.getString("sellerAdress") + "|\t" + rs.getString("product") + "|\t" + rs.getInt("quantity") + "|\t" + rs.getInt("price") + "|\t" + rs.getString("dateSale") + "|\t" + rs.getString("dateExpiry"));
                }
                System.out.println("Invoice displayed");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}

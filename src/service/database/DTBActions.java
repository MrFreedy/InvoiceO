package service.database;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import controller.start.Initialization;
import ui.Edit;
import ui.Id;
import ui.Search;

public class DTBActions {
    private static String customer_name, customer_address, seller_name, seller_address, product_name,date_sale,date_expiry, status ;
    private static int id_invoice,product_quantity;
    private static double price;

    public static String test;

    public static void createInvoice() throws SQLException {

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

        System.out.println("Please enter the status of the invoice :");
        Scanner status_in = new Scanner(System.in);
        status=status_in.nextLine();

        Statement stmt = DTBConnection.connect().createStatement();{
        String sql= "INSERT INTO garage_michel (customerName, customerAddress, sellerName, sellerAdress, product, quantity, price, dateSale, dateExpiry, statusInvoice) VALUES ('"+customer_name+"', '"+customer_address+"', '"+seller_name+"', '"+seller_address+"', '"+product_name+"', '"+product_quantity+"', '"+price+"', '"+date_sale+"', '"+date_expiry+"', '"+status+"')";
        stmt.executeUpdate(sql);
        System.out.println("Invoice created");
        Initialization.restart();
        }
    }

    public static void createInvoiceSimple(String customer_name, String customer_address, String seller_name, String seller_address,String product_name, int product_quantity, double price, java.sql.Date date_sale_sql, java.sql.Date date_expiry_sql, String status) throws SQLException {
        Statement stmt = DTBConnection.connect().createStatement();{
            String sql= "INSERT INTO garage_michel (customerName, customerAddress, sellerName, sellerAdress, product, quantity, price, dateSale, dateExpiry, statusInvoice) VALUES ('"+customer_name+"', '"+customer_address+"', '"+seller_name+"', '"+seller_address+"', '"+product_name+"', '"+product_quantity+"', '"+price+"', '"+date_sale_sql+"', '"+date_expiry_sql+"', '"+status+"')";
            stmt.executeUpdate(sql);
        }
    }

    public static void searchInvoice(String customer_name, String customer_address, String seller_name, String seller_address,String product_name, String product_quantity, String price, java.sql.Date date_sale_sql, java.sql.Date date_expiry_sql, String status) throws SQLException{
        Statement stmt = DTBConnection.connect().createStatement();{
            String sql;
            if(Search.isDateExpirySelected & Search.isDateExpirySelected){
                sql = "SELECT * FROM garage_michel WHERE  customerName LIKE '%"+customer_name+"%' AND customerAddress LIKE '%"+customer_address+"%' AND sellerName LIKE '%"+seller_name+"%' AND sellerAdress LIKE '%"+seller_address+"%' AND product LIKE '%"+product_name+"%' AND quantity LIKE '%"+product_quantity+"%' AND price LIKE '%"+price+"%' AND dateSale LIKE '%"+date_sale_sql+"%' AND dateExpiry LIKE '%"+date_expiry_sql+"%'";
            }else if(Search.isDateSaleSelected & !Search.isDateExpirySelected){
                sql = "SELECT * FROM garage_michel WHERE  customerName LIKE '%"+customer_name+"%' AND customerAddress LIKE '%"+customer_address+"%' AND sellerName LIKE '%"+seller_name+"%' AND sellerAdress LIKE '%"+seller_address+"%' AND product LIKE '%"+product_name+"%' AND quantity LIKE '%"+product_quantity+"%' AND price LIKE '%"+price+"%' AND dateSale LIKE '%"+date_sale_sql+"%'";
            }else if(!Search.isDateSaleSelected & Search.isDateExpirySelected){
                sql = "SELECT * FROM garage_michel WHERE  customerName LIKE '%"+customer_name+"%' AND customerAddress LIKE '%"+customer_address+"%' AND sellerName LIKE '%"+seller_name+"%' AND sellerAdress LIKE '%"+seller_address+"%' AND product LIKE '%"+product_name+"%' AND quantity LIKE '%"+product_quantity+"%' AND price LIKE '%"+price+"%' AND dateExpiry LIKE '%"+date_expiry_sql+"%'";
            }else {
                sql = "SELECT * FROM garage_michel WHERE  customerName LIKE '%"+customer_name+"%' AND customerAddress LIKE '%"+customer_address+"%' AND sellerName LIKE '%"+seller_name+"%' AND sellerAdress LIKE '%"+seller_address+"%' AND product LIKE '%"+product_name+"%' AND quantity LIKE '%"+product_quantity+"%' AND price LIKE '%"+price+"%'";
            }
            if(Search.isStatusSelected){
                sql = sql + " AND statusInvoice LIKE '%"+status+"%'";
            }
            ResultSet rs = stmt.executeQuery(sql);
            Search.dataGet = new ArrayList<>();
            while(rs.next()){
                Search.dataGet.add(String.valueOf(rs.getInt("idInvoice")));
                Search.dataGet.add(rs.getString("customerName"));
                Search.dataGet.add(rs.getString("customerAddress"));
                Search.dataGet.add(rs.getString("sellerName"));
                Search.dataGet.add(rs.getString("sellerAdress"));
                Search.dataGet.add(rs.getString("product"));
                Search.dataGet.add(String.valueOf(rs.getInt("quantity")));
                Search.dataGet.add(String.valueOf(rs.getDouble("price")));
                Search.dataGet.add(String.valueOf(rs.getDate("dateSale")));
                Search.dataGet.add(String.valueOf(rs.getDate("dateExpiry")));
                Search.dataGet.add(rs.getString("statusInvoice"));

            }
        }

    }


    public static void displayAllInvoices() throws SQLException {

        Statement stmt = DTBConnection.connect().createStatement();{
            String sql = "SELECT * FROM garage_michel";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("idInvoice") + "|\t" + rs.getString("customerName") + "|\t" + rs.getString("customerAddress") + "|\t" + rs.getString("sellerName") + "|\t" + rs.getString("sellerAdress") + "|\t" + rs.getString("product") + "|\t" + rs.getInt("quantity") + "|\t" + rs.getInt("price") + "|\t" + rs.getString("dateSale") + "|\t" + rs.getString("dateExpiry") + "|\t" + rs.getString("statusInvoice"));
            }
            System.out.println("Invoice displayed");
            Initialization.restart();
        }
    }

    public static void displayOneInvoice() throws SQLException {
        Scanner id_invoice_in = new Scanner(System.in);
        id_invoice=id_invoice_in.nextInt();
        Statement stmt = DTBConnection.connect().createStatement();{
            String sql = "SELECT * FROM garage_michel WHERE idInvoice = "+id_invoice;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("idInvoice") + "|\t" + rs.getString("customerName") + "|\t" + rs.getString("customerAddress") + "|\t" + rs.getString("sellerName") + "|\t" + rs.getString("sellerAdress") + "|\t" + rs.getString("product") + "|\t" + rs.getInt("quantity") + "|\t" + rs.getInt("price") + "|\t" + rs.getString("dateSale") + "|\t" + rs.getString("dateExpiry") + "|\t" + rs.getString("statusInvoice"));
            }
            System.out.println("Invoice displayed");
            Initialization.restart();
        }
    }

    public static void updateInvoice(String customer_name, String customer_address, String seller_name, String seller_address, String product_name, String product_quantity, String price, Date date_sale, Date date_expiry, String status) throws SQLException {
        Statement stmt = DTBConnection.connect().createStatement();{
            String sql = "UPDATE garage_michel SET customerName = '"+customer_name+"', customerAddress = '"+customer_address+"', sellerName = '"+seller_name+"', sellerAdress = '"+seller_address+"', product = '"+product_name+"', quantity = '"+product_quantity+"', price = '"+price+"', dateSale = '"+date_sale+"', dateExpiry = '"+date_expiry+"', statusInvoice = '"+status+"' WHERE idInvoice = "+ Edit.id;
            stmt.executeUpdate(sql);
        }
    }

    public static void getData() throws SQLException {
        Statement stmt = DTBConnection.connect().createStatement();{
            String sql = "SELECT * FROM garage_michel WHERE idInvoice = "+Edit.id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Edit.customerAddressStatic = rs.getString("customerAddress");
                Edit.customerNameStatic = rs.getString("customerName");
                Edit.sellerAddressStatic = rs.getString("sellerAdress");
                Edit.sellerNameStatic = rs.getString("sellerName");
                Edit.productStatic = rs.getString("product");
                Edit.quantityStatic = String.valueOf(rs.getInt("quantity"));
                Edit.priceStatic = String.valueOf(rs.getInt("price"));
                Edit.dateSaleStatic = rs.getString("dateSale");
                Edit.dateExpiryStatic = rs.getString("dateExpiry");
                Edit.statusInvoiceStatic = rs.getString("statusInvoice");


            }
        }
    }

    public static String getStatus() throws SQLException {
        Statement stmt = DTBConnection.connect().createStatement();{
            String sql = "SELECT statusInvoice FROM garage_michel WHERE idInvoice = "+Edit.id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Id.gettedStatus = rs.getString("statusInvoice");
            }
        }
        return Edit.statusInvoiceStatic;
    }

    public static void getNameColumns(List<String> list) throws SQLException{
        Statement stmt = DTBConnection.connect().createStatement();{
            String sql = "SELECT * FROM garage_michel";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            for (int i = 1; i <= columnsNumber; i++) {
                list.add(rsmd.getColumnName(i));
            }
        }
    }

    public static void getDataColumns(List<String> list) throws SQLException{
        Statement stmt = DTBConnection.connect().createStatement();{
            String sql = "SELECT * FROM garage_michel";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    list.add(rs.getString(i));
                }
            }
        }
    }

}
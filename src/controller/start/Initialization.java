package controller.start;

import java.sql.SQLException;
import java.util.Scanner;

import service.database.DTBActions;

public class Initialization {

    public static void start() {
        System.out.println("Welcome on InvoiceO");
        System.out.println("What do you want to do ?");
        System.out.println("1. Create a new invoice");
        System.out.println("2. Display all invoices");
        System.out.println("3. Display an invoice");
        System.out.println("4. Update an invoice");
        System.out.println("5. Delete an invoice");
        System.out.println("6. Exit");
        System.out.println("Please enter a number between 1 and 6 :");

    }

    public static void restart() throws SQLException {
        System.out.println("What do you want to do ?");
        System.out.println("1. Create a new invoice");
        System.out.println("2. Display all invoices");
        System.out.println("3. Display an invoice");
        System.out.println("4. Update an invoice");
        System.out.println("5. Exit");
        System.out.println("Please enter a number between 1 and 6 :");
        choiceStart();
    }

    public static void choiceStart() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> createInvoice();
            case 2 -> displayAllInvoices();
            case 3 -> displayInvoice();
            default -> System.out.println("You choose to exit");
        }

    }

    public static void createInvoice() throws SQLException {
        System.out.println("You choose to create a new invoice");
        DTBActions.createInvoice();
    }

    public static void displayAllInvoices() throws SQLException {
        System.out.println("You choose to display all invoices");
        DTBActions.displayAllInvoices();
    }

    public static void displayInvoice() throws  SQLException {
        System.out.println("You choose to display an invoice");
        DTBActions.displayOneInvoice();

    }

}

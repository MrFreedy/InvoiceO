/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ui;


import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.database.DTBActions;
import service.database.DTBConnection;



public class CreatorMenu {
    private JPanel panel1;
    private JTextField customerName;
    private JTextField customerAddress;
    private JTextField sellerAddress;
    private JTextField product;
    private JTextField quantity;
    private JTextField price;
    private JLabel customeNameTitle;
    private JLabel customerAddressTitle;
    private JLabel sellerNameTitle;
    private JLabel sellerAddressTitle;
    private JLabel productTitle;
    private JLabel quantityTile;
    private JLabel priceTitle;
    private JLabel dateSaleTitle;
    private JLabel dateExpiryTitle;
    private JLabel statusInvoiceTitle;
    private JRadioButton radioButtonPending;
    private JRadioButton radioButtonTransmitted;
    private JButton createButton;
    private JDatePickerImpl JDatePickerSale;
    private JDatePickerImpl JDatePickerExpiry;
    private JTextField sellerName;

    public static String username ;
    public static String password ;

    public static String url=HomePage.url;

    public CreatorMenu() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DTBConnection.connect();
                    DTBActions.createInvoiceSimple(customerName.getText(),customerAddress.getText(),sellerName.getText(),sellerAddress.getText(),product.getText(),Integer.parseInt(quantity.getText()),Double.parseDouble(price.getText()),convertDate(getDateSale()),convertDate(getDateExpiry()),selectionRadioButton());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                JFrame success_frame= new JFrame("Success");
                success_frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                JLabel label_success = new JLabel("<html><font color='green'>SUCCESS ! Your invoice has been added to the database</font></html>");
                success_frame.add(label_success);
                label_success.setHorizontalAlignment(SwingConstants.CENTER);
                ImageIcon icon = new ImageIcon("src\\image\\validate\\validate-16.png");
                success_frame.setIconImage(icon.getImage());
                success_frame.setSize(400, 100);
                success_frame.setLocationRelativeTo(null);
                Toolkit.getDefaultToolkit().beep();
                success_frame.setVisible(true);

            }
        });
        radioButtonPending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButtonTransmitted.setSelected(false);
            }
        });

        radioButtonTransmitted.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioButtonPending.setSelected(false);
            }
        });
    }

    public String getDateSale() {
        return JDatePickerSale.getJFormattedTextField().getText();
    }

    public String getDateExpiry() {
        return JDatePickerExpiry.getJFormattedTextField().getText();
    }


    public String selectionRadioButton(){
        if (radioButtonPending.isSelected()){
            return "Pending";
        }else if (radioButtonTransmitted.isSelected()){
            return "Transmitted";
        }else{
            return "Error";
        }
    }


    public java.sql.Date convertDate(String date) {
        String[] dateSplit = date.split(" ");
        int year = Integer.parseInt(dateSplit[2]);

        return switch (dateSplit[1]) {
            case "janv." -> java.sql.Date.valueOf(year + "-01-" + dateSplit[0]);
            case "févr." -> java.sql.Date.valueOf(year + "-02-" + dateSplit[0]);
            case "mars" -> java.sql.Date.valueOf(year + "-03-" + dateSplit[0]);
            case "avr." -> java.sql.Date.valueOf(year + "-04-" + dateSplit[0]);
            case "mai" -> java.sql.Date.valueOf(year + "-05-" + dateSplit[0]);
            case "juin" -> java.sql.Date.valueOf(year + "-06-" + dateSplit[0]);
            case "juil." -> java.sql.Date.valueOf(year + "-07-" + dateSplit[0]);
            case "août" -> java.sql.Date.valueOf(year + "-08-" + dateSplit[0]);
            case "sept." -> java.sql.Date.valueOf(year + "-09-" + dateSplit[0]);
            case "oct." -> java.sql.Date.valueOf(year + "-10-" + dateSplit[0]);
            case "nov." -> java.sql.Date.valueOf(year + "-11-" + dateSplit[0]);
            case "déc." -> java.sql.Date.valueOf(year + "-12-" + dateSplit[0]);
            default -> null;
        };

    }




    public static void main(String[] args) {
        FlatOneDarkIJTheme.setup();
        JFrame frame = new JFrame("CreatorMenu");
        frame.setContentPane(new CreatorMenu().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(750,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void generateUI() {
        JFrame creator = new JFrame("InvoiceO");
        ImageIcon icon = new ImageIcon("src\\image\\invoice\\invoice-16.png");
        creator.setIconImage(icon.getImage());
        creator.setContentPane(new CreatorMenu().panel1);
        creator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creator.pack();
        creator.setLocationRelativeTo(null);
        creator.setVisible(true);
        creator.requestFocus();
    }

}

/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package menu;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import service.database.*;

public class Edit {
    private JPanel panel1;
    public JTextField customerName;
    public JTextField customerAddress;
    public JTextField sellerName;
    public JTextField sellerAddress;
    public JTextField product;
    public JTextField quantity;
    public JTextField price;
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
    private JButton EditBtn;
    private JDatePickerImpl JDatePickerSale;
    private JDatePickerImpl JDatePickerExpiry;

    public static String id;
    public static String customerNameStatic;
    public static String customerAddressStatic;
    public static String sellerNameStatic;
    public static String sellerAddressStatic;
    public static String productStatic;
    public static String quantityStatic;
    public static String priceStatic;
    public static String dateSaleStatic;
    public static String dateExpiryStatic;
    public static String statusInvoiceStatic;

    private void successMessage(){
        JFrame frame_success= new JFrame("Success");
        ImageIcon icon = new ImageIcon("src\\image\\validate\\validate-16.png");
        frame_success.setIconImage(icon.getImage());
        frame_success.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JLabel label_success = new JLabel("<html><font color='green'>Invoice successfully edited !</font></html>");
        JButton okBtn = new JButton("OK");
        okBtn.setBackground(menu.Color.azureRadiance);
        okBtn.setForeground(Color.white);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
                frame_success.dispose();
            }
        });
        //put okBtn in South/East frame_success
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(okBtn);
        frame_success.add(buttonPanel, BorderLayout.SOUTH);
        okBtn.setPreferredSize(new Dimension(100, 30));
        frame_success.add(label_success, BorderLayout.NORTH);
        frame_success.add(label_success);
        label_success.setHorizontalAlignment(SwingConstants.CENTER);
        frame_success.setSize(250, 150);
        frame_success.setResizable(false);
        frame_success.setLocationRelativeTo(null);
        frame_success.setVisible(true);

    }

    public String getDateSale() {
        return JDatePickerSale.getJFormattedTextField().getText();
    }

    public String getDateExpiry() {
        return JDatePickerExpiry.getJFormattedTextField().getText();
    }

    public String selectionRadioButton() {
        if (radioButtonPending.isSelected()) {
            return "Pending";
        } else if (radioButtonTransmitted.isSelected()) {
            return "Transmitted";
        } else {
            return "null";
        }
    }


    private java.sql.Date convertDateToSQL(String date) {
        String[] dateSplitSQL = date.split(" ");
        int year = Integer.parseInt(dateSplitSQL[2]);

        return switch (dateSplitSQL[1]) {
            case "janv." -> java.sql.Date.valueOf(year + "-01-" + dateSplitSQL[0]);
            case "févr." -> java.sql.Date.valueOf(year + "-02-" + dateSplitSQL[0]);
            case "mars" -> java.sql.Date.valueOf(year + "-03-" + dateSplitSQL[0]);
            case "avr." -> java.sql.Date.valueOf(year + "-04-" + dateSplitSQL[0]);
            case "mai" -> java.sql.Date.valueOf(year + "-05-" + dateSplitSQL[0]);
            case "juin" -> java.sql.Date.valueOf(year + "-06-" + dateSplitSQL[0]);
            case "juil." -> java.sql.Date.valueOf(year + "-07-" + dateSplitSQL[0]);
            case "août" -> java.sql.Date.valueOf(year + "-08-" + dateSplitSQL[0]);
            case "sept." -> java.sql.Date.valueOf(year + "-09-" + dateSplitSQL[0]);
            case "oct." -> java.sql.Date.valueOf(year + "-10-" + dateSplitSQL[0]);
            case "nov." -> java.sql.Date.valueOf(year + "-11-" + dateSplitSQL[0]);
            case "déc." -> java.sql.Date.valueOf(year + "-12-" + dateSplitSQL[0]);
            default -> null;
        };
        }
    private String convertDateToString(String date) {
        String convertedDate;
        String[] dateSplitString = date.split("-");
        int year = Integer.parseInt(dateSplitString[0]);

        switch (dateSplitString[2]){
            case "01" -> dateSplitString[2] = "1";
            case "02" -> dateSplitString[2] = "2";
            case "03" -> dateSplitString[2] = "3";
            case "04" -> dateSplitString[2] = "4";
            case "05" -> dateSplitString[2] = "5";
            case "06" -> dateSplitString[2] = "6";
            case "07" -> dateSplitString[2] = "7";
            case "08" -> dateSplitString[2] = "8";
            case "09" -> dateSplitString[2] = "9";
            default -> dateSplitString[2] = dateSplitString[2];
        }

        return switch (dateSplitString[1]) {
            case "01" -> convertedDate = dateSplitString[2]+" janv. "+year;
            case "02" -> convertedDate = dateSplitString[2]+" févr. "+year;
            case "03" -> convertedDate = dateSplitString[2]+" mars "+year;
            case "04" -> convertedDate = dateSplitString[2]+" avr. "+year;
            case "05" -> convertedDate = dateSplitString[2]+" mai "+year;
            case "06" -> convertedDate = dateSplitString[2]+" juin "+year;
            case "07" -> convertedDate = dateSplitString[2]+" juil. "+year;
            case "08" -> convertedDate = dateSplitString[2]+" août "+year;
            case "09" -> convertedDate = dateSplitString[2]+" sept. "+year;
            case "10" -> convertedDate = dateSplitString[2]+" oct. "+year;
            case "11" -> convertedDate = dateSplitString[2]+" nov. "+year;
            case "12" -> convertedDate = dateSplitString[2]+" déc. "+year;
            default -> null;
        };
    }

    private void setRadioBtn(){
        if (statusInvoiceStatic.equals("Pending")) {
            radioButtonPending.setSelected(true);
        } else if (statusInvoiceStatic.equals("Transmitted")) {
            radioButtonTransmitted.setSelected(true);
        }else{
            radioButtonPending.setSelected(false);
            radioButtonTransmitted.setSelected(false);
        }
    }

    private void editSetters() throws SQLException {
        DTBActions.getData();
        customerName.setText(customerNameStatic);
        customerAddress.setText(customerAddressStatic);
        sellerName.setText(sellerNameStatic);
        sellerAddress.setText(sellerAddressStatic);
        product.setText(productStatic);
        quantity.setText(quantityStatic);
        price.setText(priceStatic);
        JDatePickerSale.getJFormattedTextField().setText(convertDateToString(dateSaleStatic));
        JDatePickerExpiry.getJFormattedTextField().setText(convertDateToString(dateExpiryStatic));
        setRadioBtn();

    }


    public Edit() throws SQLException {
        editSetters();
        EditBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DTBConnection.connect();
                    DTBActions.updateInvoice(customerName.getText(), customerAddress.getText(), sellerName.getText(), sellerAddress.getText(), product.getText(), quantity.getText(), price.getText(), convertDateToSQL(getDateSale()), convertDateToSQL(getDateExpiry()), selectionRadioButton());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                successMessage();

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

        public static void main (String[]args) throws IOException, SQLException {
            try {
                FlatOneDarkIJTheme.setup();
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
            JFrame frame = new JFrame("Edit");

            frame.setContentPane(new Edit().panel1);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.requestFocus();

        }
    }

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
import service.database.DTBActions;
import service.database.DTBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Search {
    private JPanel panel1;
    private JTextField customerAddress;
    private JTextField sellerName;
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
    private JButton searchBtn;
    private JDatePickerImpl JDatePickerSale;
    private JDatePickerImpl JDatePickerExpiry;
    private JTextField customerName;

    public Search() {
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Search button pressed");
                try {
                    DTBActions.searchInvoice();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        searchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchBtn.setBackground(Color.mako);
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

    public  static void main(String[] args) {
        FlatOneDarkIJTheme.setup();
        JFrame frame = new JFrame("Search Invoice");
        frame.setContentPane(new Search().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(750,500);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

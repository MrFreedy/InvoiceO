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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Search {
    private JPanel panel1;
    private JTextField customerName;
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
    private JButton searchBtn;
    private JDatePickerImpl JDatePickerSale;
    private JDatePickerImpl JDatePickerExpiry;
    private JCheckBox pendingCheckBox;
    private JCheckBox transmittedCheckBox;

    private static final java.util.List<String> columnNames= new ArrayList<>();
    public static List<String> dataGet = new ArrayList<>();
    public static String[] columnNamesArray;

    public static Object[][] data;

    public static boolean isDateSaleSelected = false;
    public static boolean isDateExpirySelected = false;

    public static boolean isStatusSelected = false;

    public Search() {

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

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DTBActions.searchInvoice(customerName.getText(),customerAddress.getText(),sellerName.getText(),sellerAddress.getText(),product.getText(),quantity.getText(),price.getText(), convertDate(getDateSale()), convertDate(getDateExpiry()), selectionRadioButton());
                    DTBActions.getNameColumns(columnNames);
                    columnNamesArray= new String[columnNames.size()];
                    columnNamesArray = columnNames.toArray(columnNamesArray);
                    data = new Object[dataGet.size() / columnNamesArray.length][columnNamesArray.length];
                    // Loop to fill data
                    int k = 0;
                    for (int i = 0; i < data.length; i++) {
                        for (int j = 0; j < data[i].length; j++) {
                            data[i][j] = dataGet.get(k);
                            k++;
                        }
                    }
                    JTable table = new JTable(0, 0);
                    JFrame visualTable = new JFrame();
                    table.setModel(new DefaultTableModel(data, columnNamesArray){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }

                    });
                    visualTable.add(new JScrollPane(table));
                    visualTable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    visualTable.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    visualTable.setLocationRelativeTo(null);
                    table.setEnabled(true);
                    JTableHeader header = table.getTableHeader();
                    resizeColumnWidth(table);
                    header.setReorderingAllowed(false);
                    visualTable.setVisible(true);
                }catch (SQLException error){
                    error.printStackTrace();
                }
            }
        });
        pendingCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transmittedCheckBox.setSelected(false);
                isStatusSelected = true;
            }
        });

        transmittedCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pendingCheckBox.setSelected(false);
                isStatusSelected = true;
            }
        });

        JDatePickerSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isDateSaleSelected = true;
            }
        });

        JDatePickerExpiry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isDateExpirySelected = true;
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


    public String getDateSale() {
        return JDatePickerSale.getJFormattedTextField().getText();
    }

    public String getDateExpiry() {
        return JDatePickerExpiry.getJFormattedTextField().getText();
    }


    public String selectionRadioButton(){
        if (pendingCheckBox.isSelected()){
            return "Pending";
        }else if (transmittedCheckBox.isSelected()){
            return "Transmitted";
        }else{
            return "Error";
        }
    }


    public static void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 30; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }


    public  static void main(String[] args) {
        FlatOneDarkIJTheme.setup();
        JFrame frame = new JFrame("Search Invoice");
        ImageIcon icon = new ImageIcon("src\\image\\search\\search-16.png");
        frame.setContentPane(new Search().panel1);
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(750,500);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

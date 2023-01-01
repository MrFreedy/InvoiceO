/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package menu;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
import java.util.List;

import service.database.DTBActions;

public class DisplayUI {

    private static final List<String> columnNames= new ArrayList<>();
    public static final List<String> dataGet = new ArrayList<>();
    public static String[] columnNamesArray;

    public static Object[][] data;

    static JTable table = new JTable(0,0);

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



    public static void main(String[] args) throws SQLException {
        DTBActions.getNameColumns(columnNames);
        DTBActions.getDataColumns(dataGet);
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

        table.setModel(new DefaultTableModel(data, columnNamesArray){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        });

        table.setEnabled(true);
        JTableHeader header = table.getTableHeader();
        resizeColumnWidth(table);
        header.setReorderingAllowed(false);



        JFrame frame = new JFrame("Garage Michel - Invoice");
        ImageIcon icon = new ImageIcon("src\\image\\table\\table-16.png");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                columnNames.clear();
            }
        });
    }
}


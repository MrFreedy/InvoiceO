package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

import service.database.DTBActions;

public class UI {


    private static final List<String> columnNames= new ArrayList<>();
    private static final List<String> dataGet = new ArrayList<>();



    public static void main(String[] args) throws SQLException {
        DTBActions.getNameColumns(columnNames);
        DTBActions.getDataFromColumns(dataGet);


        //convert columnNames to String[]
        String[] columnNamesArray = new String[columnNames.size()];
        columnNamesArray = columnNames.toArray(columnNamesArray);

        Object[][] data = new Object[dataGet.size() / columnNamesArray.length][columnNamesArray.length];

        // Loop to fill data
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = dataGet.get(k);
                k++;
            }
        }




        JTable table = new JTable(data, columnNamesArray);

        table.setEnabled(false);
        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);


        JFrame frame = new JFrame("Garage Michel - Invoice");
        ImageIcon icon = new ImageIcon("src\\image\\invoice.png");

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}


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

        System.out.println(dataGet.size());

        //convert columnNames to String[]
        String[] columnNamesArray = new String[columnNames.size()];
        columnNamesArray = columnNames.toArray(columnNamesArray);
        System.out.println(Arrays.toString(columnNamesArray));

        Object[][] data = new Object[][]{

                {dataGet.get(0), dataGet.get(1), dataGet.get(2), dataGet.get(3), dataGet.get(4), dataGet.get(5), dataGet.get(6), dataGet.get(7), dataGet.get(8), dataGet.get(9), dataGet.get(10)},
                {dataGet.get(11), dataGet.get(12), dataGet.get(13), dataGet.get(14), dataGet.get(15), dataGet.get(16), dataGet.get(17), dataGet.get(18), dataGet.get(19), dataGet.get(20), dataGet.get(21)},

        };

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


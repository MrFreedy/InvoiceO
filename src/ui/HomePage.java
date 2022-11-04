/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ui;

import javax.swing.*;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class HomePage {
    private JPanel panel1;
    private JList list1;
    private JButton addBtn;
    private JPanel sideMenu;
    private JButton settingsBtn;
    private JButton aboutBtn;
    private JButton deleteBtn;
    private JButton editBtn;
    private JScrollPane scrollServerPane;


    private JTextField db_name;

    public static String url;




    public HomePage() throws IOException, CsvException {

        try{
            CSVReader reader = new CSVReader(new FileReader("src\\data\\database.csv"));
            List<String[]> r = reader.readAll();
            DefaultListModel listModel = new DefaultListModel();
            for(String[] row : r){
                listModel.addElement(row[0]);//row[0] is the name of the database
            }
            list1.setModel(listModel);
        }catch (Exception e){
            System.out.println(e);
        }





    /*    deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                listModel.remove(index);
                if(listModel.isEmpty()){
                    deleteBtn.setEnabled(false);
                    editBtn.setEnabled(false);
                }

            }
        });*/
/*
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                String element = (String) listModel.getElementAt(index);
                db_name.setText(element);
            }
        });*/

        addBtn.setIconTextGap(25);
        aboutBtn.setIconTextGap(25);
        settingsBtn.setIconTextGap(25);
        deleteBtn.setIconTextGap(25);
        editBtn.setIconTextGap(25);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Add Server");
                frame.setContentPane(new AddServer().panel1);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.requestFocus();
            }
        });


        addBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                addBtn.setBackground(Color.standardBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                addBtn.setBackground(Color.defaultColor);
            }
        });

        editBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                editBtn.setBackground(Color.standardBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                editBtn.setBackground(Color.defaultColor);
            }
        });

        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                deleteBtn.setBackground(Color.standardBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                deleteBtn.setBackground(Color.defaultColor);
            }
        });

        settingsBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                settingsBtn.setBackground(Color.standardBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                settingsBtn.setBackground(Color.defaultColor);
            }
        });

        aboutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                aboutBtn.setBackground(Color.standardBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                aboutBtn.setBackground(Color.defaultColor);
            }
        });


    }



    public static void main(String[] args) throws IOException, CsvException {
        try{
            FlatOneDarkIJTheme.setup();

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        JFrame frame = new JFrame("HomePage");

        frame.setContentPane(new HomePage().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.requestFocus();

    }
}

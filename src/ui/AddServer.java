/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ui;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.opencsv.CSVWriter;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class AddServer {
    private JTextField ip_server;
    private JTextField port_server;
    private JTextField db_name;
    private JTextField titleDatabase;
    JPanel panel1;
    private JLabel connectionLabel;
    private JLabel ipLabel;
    private JLabel portLabel;
    private JLabel namedtbLabel;
    private JLabel nameLabel;
    private JButton addBtn;
    private JButton cancelBtn;




    public AddServer() {



        titleDatabase.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!titleDatabase.getText().equals("eg. My Database server 1")){

                }else{
                    titleDatabase.setText("");
                }
                titleDatabase.setBackground(Color.focusedField);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(titleDatabase.getText().equals("")){
                    titleDatabase.setText("eg. My Database server 1");
                }
                titleDatabase.setBackground(Color.defaultColor);
            }
        });

        ip_server.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!ip_server.getText().equals("eg. 127.0.0.1 or mydomain.com")){

                }else {
                    ip_server.setText("");
                }

                ip_server.setBackground(Color.focusedField);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(ip_server.getText().equals("")){
                    ip_server.setText("eg. 127.0.0.1 or mydomain.com");
                }
                ip_server.setBackground(Color.defaultColor);
            }
        });

        port_server.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!port_server.getText().equals("eg. 3306")){

                }else {
                    port_server.setText("");
                }
                port_server.setBackground(Color.focusedField);
            }

            public void focusLost(FocusEvent e) {
                if (port_server.getText().isEmpty()) {
                    if (port_server.getText().equals("")) {
                        port_server.setText("eg.3306");
                    }
                }
                port_server.setBackground(Color.defaultColor);
            }
        });

        db_name.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!db_name.getText().equals("eg. invoicedtb")){

                }else {
                    db_name.setText("");
                }
                db_name.setBackground(Color.focusedField);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(db_name.getText().equals("")){
                    db_name.setText("eg. invoicedtb");
                }
                db_name.setBackground(Color.defaultColor);
            }
        });

        cancelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cancelBtn.setBackground(Color.standardBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                cancelBtn.setBackground(Color.defaultColor);
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(titleDatabase.getText().equals("eg. My Database server 1") || titleDatabase.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a title for your database server");
                }else if(ip_server.getText().equals("eg. 127.0.0.1 or mydomain.com") || ip_server.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid IP address or domain name");

                }else if(port_server.getText().equals("eg. 3306") || port_server.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid port number");
                }else if(db_name.getText().equals("eg. invoicedtb") || db_name.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid database name");
                }else{
                    String[] data1 = {titleDatabase.getText(), ip_server.getText(), port_server.getText(), db_name.getText()};
                    try {
                        CSVWriter writer = new CSVWriter(new FileWriter("src\\data\\database.csv", true));
                        writer.writeNext(data1);
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Database server added successfully");
                    JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                    frame.dispose();
                }
            }
        });
    }

    public static void main(String[] args){
        try{
            FlatOneDarkIJTheme.setup();
        }catch (Exception e){
            e.printStackTrace();
        }
        JFrame frame = new JFrame("AddServer");
        frame.setContentPane(new AddServer().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("src\\image\\database\\database-64.png");
        frame.setIconImage(img.getImage());
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

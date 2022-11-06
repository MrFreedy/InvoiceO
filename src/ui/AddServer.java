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
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
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

        port_server.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!port_server.getText().equals("eg. 3306")){

                }else {
                    port_server.setText("");
                }
                port_server.setBackground(Color.focusedField);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(port_server.getText().equals("")){
                    port_server.setText("eg. 3306");
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
                        successMessage();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error adding database server");
                    }
                }
            }
        });
    }

    private static void refreshPage() throws IOException, CsvException {
        JFrame frameRefresh = new JFrame("HomePage");
        frameRefresh.setContentPane(new HomePage().panel1);
        frameRefresh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameRefresh.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frameRefresh.pack();
        frameRefresh.setLocationRelativeTo(null);
        frameRefresh.setVisible(true);
        frameRefresh.setResizable(false);
        frameRefresh.requestFocus();

    }

    private void successMessage(){
        JFrame frame_success= new JFrame("Success");
        ImageIcon icon = new ImageIcon("src\\image\\validate\\validate-16.png");
        frame_success.setIconImage(icon.getImage());
        frame_success.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JLabel label_success = new JLabel("<html><font color='green'>Database server added successfully !</font></html>");
        JButton okBtn = new JButton("OK");
        okBtn.setBackground(Color.standardBlue);
        okBtn.setForeground(Color.white);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
                frame_success.dispose();

                try {
                    refreshPage();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (CsvException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //put okBtn in South/East frame_success
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(okBtn);
        frame_success.add(buttonPanel, BorderLayout.SOUTH);
        okBtn.setPreferredSize(new Dimension(100, 30));
        frame_success.add(label_success, BorderLayout.NORTH);


        label_success.setFont(label_success.getFont().deriveFont(14.0f));
        frame_success.add(label_success);
        label_success.setHorizontalAlignment(SwingConstants.CENTER);
        frame_success.setSize(250, 150);
        frame_success.setResizable(false);
        frame_success.setLocationRelativeTo(null);
        frame_success.setVisible(true);

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
        frame.setResizable(false);


    }
}

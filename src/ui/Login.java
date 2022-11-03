/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import service.database.*;
import ui.CreatorMenu;


public class Login {
    private JPanel panel1;
    private JLabel label1;
    private JTextField usernamefield;
    private JLabel userfield_title;
    private JLabel passwordfield_title;
    private JPasswordField passwordfield;
    private JButton connectButton;

    public static String username;
    public static String password;

    public Login(){



        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getUsername();
                getPassword();
                DTBConnection.user = username;
                DTBConnection.password = password;
                try {
                    if(DTBConnection.connect()!= null){
                        try {
                            UI.main(null);
                            JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                            frame.dispose();
                            CreatorMenu.generateUI();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        }
                } catch (SQLException ex) {
                    System.out.println("Error");
                    JFrame frame_error_login= new JFrame("Error");
                    frame_error_login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    JLabel label_error_login = new JLabel("<html><font color='red'>Incorrect username or password !</font></html>");
                    frame_error_login.add(label_error_login);
                    label_error_login.setHorizontalAlignment(SwingConstants.CENTER);
                    frame_error_login.setSize(300, 100);
                    frame_error_login.setLocationRelativeTo(null);
                    Toolkit.getDefaultToolkit().beep();
                    frame_error_login.setVisible(true);
                    throw new RuntimeException(ex);

                }
            }

        });

        usernamefield.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernamefield.setText("");
            }
        });

        //add key listener to password field to detect enter key

        passwordfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    connectButton.doClick();
                }
            }
        });

    }

    public void getUsername() {
        username = usernamefield.getText();
        CreatorMenu.username = username;
    }

    public void getPassword() {
        password = passwordfield.getText();
        CreatorMenu.password = password;
    }


    public static void main(String[] args) {
        generateUI();

    }

    static void generateUI() {
        JFrame frame = new JFrame("InvoiceO");
        ImageIcon icon = new ImageIcon("src\\image\\invoice\\invoice-16.png");
        frame.setIconImage(icon.getImage());
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();
    }


}


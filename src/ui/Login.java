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
import java.awt.event.*;
import java.sql.SQLException;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import service.database.*;


public class Login {
    JPanel panel1;
    private JLabel label1;
    private JTextField usernamefield;
    private JLabel userfield_title;
    private JLabel passwordfield_title;
    private JPasswordField passwordfield;
    private JButton connectButton;

    public static String username;
    public static String password;

    public static String url;

    public Login(){

        passwordfield.setEchoChar((char) 0);
        passwordfield.setText("Enter your password");

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getUsername();
                getPassword();
                getURL();
                DTBConnection.user = username;
                DTBConnection.password = password;
                DTBConnection.url = url;

                try {
                    if(DTBConnection.connect()!= null){
                        Idle.main(null);
                        JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                        frame.dispose();
                    }
                } catch (SQLException ex) {
                    JFrame frame_error_login= new JFrame("Error");
                    ImageIcon icon = new ImageIcon("src\\image\\error\\error-16.png");
                    frame_error_login.setIconImage(icon.getImage());
                    frame_error_login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    JLabel label_error_login = new JLabel("<html><font color='red'>Incorrect username or password !</font></html>");
                    label_error_login.setFont(label_error_login.getFont().deriveFont(14.0f));
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

        connectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                connectButton.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                connectButton.setBackground(Color.mako);
            }
        });


        usernamefield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!usernamefield.getText().equals("Enter your username")){
                }else {
                    usernamefield.setText("");
                }
                usernamefield.setBackground(Color.pickledBluewood);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(usernamefield.getText().equals("")){
                    usernamefield.setText("Enter your username");
                }
                usernamefield.setBackground(Color.defaultColor);
            }
        });

        passwordfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!passwordfield.getText().equals("Enter your password")){
                }else {
                    passwordfield.setEchoChar('*');
                    passwordfield.setText("");
                }
                passwordfield.setBackground(Color.pickledBluewood);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(passwordfield.getText().equals("")){
                    passwordfield.setEchoChar((char) 0);
                    passwordfield.setText("Enter your password");
                }
                passwordfield.setBackground(Color.defaultColor);
            }
        });
    }

    public void getUsername() {
        username = usernamefield.getText();
    }

    private void getPassword() {
        password = passwordfield.getText();
    }

    private static void getURL() {
        url="jdbc:mysql://"+HomePage.url;
    }

    public static void main(String[] args) {
        generateUI();
    }



    static void generateUI() {
        try{
            FlatOneDarkIJTheme.setup();

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        JFrame frame = new JFrame("InvoiceO");
        ImageIcon icon = new ImageIcon("src\\image\\invoice\\invoice-16.png");
        frame.setIconImage(icon.getImage());
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();
    }


}


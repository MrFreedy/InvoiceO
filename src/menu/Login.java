/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.opencsv.exceptions.CsvException;
import service.database.*;


public class Login {
    JPanel panel1;
    private JLabel label1;
    private JTextField usernamefield;
    private JLabel userfield_title;
    private JLabel passwordfield_title;
    private JPasswordField passwordfield;
    private JButton connectBtn;
    private JButton cancelBtn;

    public static String username;
    public static String password;

    public static String url;

    public Login(){

        passwordfield.setEchoChar((char) 0);
        passwordfield.setText("Enter your password");

        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getUsername();
                getPassword();
                getURL();
                DTBConnection.user = username;
                DTBConnection.password = password;
                DTBConnection.url = url;
                ZonedDateTime currentTime = ZonedDateTime.now();
                int hour = currentTime.getHour();
                int minute = currentTime.getMinute();
                int second = currentTime.getSecond();
                int day = currentTime.getDayOfMonth();
                int month = currentTime.getMonthValue();
                int year = currentTime.getYear();
                try {
                    if(DTBConnection.connect()!= null){
                        String[] cmd = {"cmd.exe", "/c", "echo", "Logged at "+hour+":"+minute+":"+second+" on "+year+"/"+month+"/"+day+" with "+username, ">", "log.txt"};
                        Process p = Runtime.getRuntime().exec(cmd);
                        p.waitFor();
                        String[] file = {"ocaml", "ocaml\\src\\main.ml"};
                        Process p2 = Runtime.getRuntime().exec(file);
                        BufferedReader in = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                        String line;
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                        }
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

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        connectBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                connectBtn.setBackground(menu.Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                connectBtn.setBackground(menu.Color.mako);
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HomePage.main(null);
                } catch (IOException | CsvException ex) {
                    throw new RuntimeException(ex);
                }
                JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
            }
        });

        cancelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                cancelBtn.setBackground(menu.Color.monza);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                cancelBtn.setBackground(menu.Color.mako);
            }
        });
        usernamefield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!usernamefield.getText().equals("Enter your username")){
                }else {
                    usernamefield.setText("");
                }
                usernamefield.setBackground(menu.Color.pickledBluewood);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(usernamefield.getText().equals("")){
                    usernamefield.setText("Enter your username");
                }
                usernamefield.setBackground(menu.Color.defaultColor);
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
                passwordfield.setBackground(menu.Color.pickledBluewood);
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


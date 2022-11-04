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


public class HomePage {
    private JPanel panel1;
    private JLabel homepage_title;
    private JButton exitButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton addButton;


    private JList<String> server_list;
    private JPanel side_menu;
    private JTextField db_name;

    public static String url;


    public static void main(String[] args) {
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
        frame.requestFocus();


    }
}

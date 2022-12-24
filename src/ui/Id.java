/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ui;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import service.database.DTBActions;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;


public class Id {
    private JPanel panel1;
    private JButton confirmButton;
    private JTextField idField;
    private JLabel title;

    public static String gettedStatus;

    private void getStatus() throws SQLException {
        DTBActions.getData();
        gettedStatus = DTBActions.test;
    }
    public Id() throws SQLException {
        getStatus();
        idField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!idField.getText().equals("Enter your invoice id")){
                }else {
                    idField.setText("");
                }
                idField.setBackground(Color.pickledBluewood);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(idField.getText().equals("")){
                    idField.setText("Enter your invoice id");
                }
                idField.setBackground(Color.defaultColor);
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Edit.id= idField.getText();
                    Edit.main(null);
                    JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                    frame.dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                confirmButton.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                confirmButton.setBackground(Color.mako);
            }
        });
    }

    public static void main (String[]args) throws IOException, SQLException {
        try {
            FlatOneDarkIJTheme.setup();

        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        JFrame frame = new JFrame("Edit Invoice");

        frame.setContentPane(new Id().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.requestFocus();

    }
}

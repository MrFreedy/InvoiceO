/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ui;

import javax.swing.*;
import java.awt.event.*;

public class HomePage {
    private JPanel panel1;
    private JLabel homepage_title;
    private JButton addButton;
    private JTextField ip_server;
    private JTextField port_server;

    private JList<String> server_list;

    DefaultListModel<String> listModel = new DefaultListModel<>();
    public HomePage() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("add");
                listModel.addElement(ip_server.getText() + ":" + port_server.getText());
                server_list.setModel(listModel);
            }
        });

        ip_server.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ip_server.setText("");
            }
        });

        port_server.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                port_server.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HomePage");
        frame.setContentPane(new HomePage().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();

    }
}

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Idle {
    private JPanel panel1;
    private JPanel leftMenu;
    private JPanel rightMenu;
    private JLabel connectedLabel;
    private JButton editBtn;
    private JButton displayBtn;
    private JButton disconnectBtn;
    private JButton createBtn;
    private JButton button1;
    private JScrollPane scrollPane;
    private JTable table;

    private static final List<String> columnNames= new ArrayList<>();
    private static final List<String> dataGet = new ArrayList<>();


    public Idle() {
        connectedLabel.setText("Connected to " + HomePage.db_name_value);
        disconnectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
            }
        });

        createBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                createBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                createBtn.setBackground(Color.mako);
            }
        });

        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatorMenu.main(null);
            }
        });

        editBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editBtn.setBackground(Color.mako);
            }
        });

        displayBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                displayBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                displayBtn.setBackground(Color.mako);
            }
        });

        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UI.main(null);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        disconnectBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                disconnectBtn.setBackground(Color.monza);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                disconnectBtn.setBackground(Color.mako);
            }
        });
    }




    public static void main(String[] args) {

        FlatOneDarkIJTheme.setup();

        JFrame frame = new JFrame("Idle");
        frame.setContentPane(new Idle().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

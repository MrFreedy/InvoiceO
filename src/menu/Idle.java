/*
 * Copyright (c) 2022-2023.
 * Lenne Arthur
 */

package menu;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
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
    private JButton searchBtn;

    private static final List<String> columnNames= new ArrayList<>();
    private static final List<String> dataGet = new ArrayList<>();


    public Idle() {
        connectedLabel.setText("Connected to " + HomePage.db_name_value);

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

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Id.main(null);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

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
                    DisplayUI.main(null);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        searchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchBtn.setBackground(Color.mako);
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search.main(null);
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
        disconnectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
                try {
                    HomePage.main(null);
                } catch (IOException | CsvException ex) {
                    throw new RuntimeException(ex);
                }
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

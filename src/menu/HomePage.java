/*
 * Copyright (c) 2022-2023.
 * Lenne Arthur
 */

package menu;

import javax.swing.*;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HomePage {
    JPanel panel1;
    public JList list1;
    private JButton addBtn;
    private JPanel sideMenu;
    private JButton settingsBtn;
    private JButton aboutBtn;

    private JButton editBtn;
    private JScrollPane scrollServerPane;
    private JButton deleteBtn;
    public static String db_name_value = null;

    public static String url;




    public HomePage() throws IOException, CsvException {

        try{
            CSVReader reader = new CSVReader(new FileReader("src\\data\\database.csv"));
            List<String[]> r = reader.readAll();
            DefaultListModel listModel = new DefaultListModel();
            for(String[] row : r){
                listModel.addElement(row[0]);//row[0] is the name of the server

            }

            list1.setModel(listModel);
            list1.setFixedCellHeight(50);
        }catch (Exception e){
            System.out.println(e);
        }


        addBtn.setIconTextGap(25);
        aboutBtn.setIconTextGap(25);
        settingsBtn.setIconTextGap(25);
        editBtn.setIconTextGap(25);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAddServer = new JFrame("Add Server");
                frameAddServer.setContentPane(new AddServer().panel1);
                frameAddServer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameAddServer.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                frameAddServer.pack();
                frameAddServer.setLocationRelativeTo(null);
                frameAddServer.setVisible(true);
                frameAddServer.setResizable(false);
                frameAddServer.requestFocus();
                JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();


            }
        });


        addBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                addBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                addBtn.setBackground(Color.mako);
            }
        });

        editBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                editBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                editBtn.setBackground(Color.mako);
            }
        });

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
                try {
                    CSVReader reader = new CSVReader(new FileReader("src\\data\\database.csv"));
                    List<String[]> r = reader.readAll();
                    String[] row = r.get(list1.getSelectedIndex());
                    EditServer.titleDatabaseStatic = row[0];
                    EditServer.ipServerStatic = row[1];
                    EditServer.portServerStatic = row[2];
                    EditServer.dbNameStatic = row[3];
                    EditServer.index = list1.getSelectedIndex();
                    EditServer.main(null);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                deleteBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                deleteBtn.setBackground(Color.mako);
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CSVReader reader = new CSVReader(new FileReader("src\\data\\database.csv"));
                    List<String[]> r = reader.readAll();
                    r.remove(list1.getSelectedIndex());
                    CSVWriter writer = new CSVWriter(new FileWriter("src\\data\\database.csv"));
                    writer.writeAll(r);
                    writer.close();
                    JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                    frame.dispose();
                    HomePage.main(null);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });


        settingsBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                settingsBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                settingsBtn.setBackground(Color.mako);
            }
        });

        aboutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                aboutBtn.setBackground(Color.azureRadiance);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                aboutBtn.setBackground(Color.mako);
            }
        });


        aboutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("About");
                frame.setContentPane(new About().panel1);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                frame.setSize(680, 440);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.requestFocus();
            }
        });

        //right click list1
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem deleteItem = new JMenuItem("Delete");
                    JMenuItem editItem = new JMenuItem("Edit");
                    popupMenu.add(deleteItem);
                    popupMenu.add(editItem);
                    popupMenu.show(list1, e.getX(), e.getY());
                    deleteItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int index = list1.getSelectedIndex();
                            DefaultListModel model = (DefaultListModel) list1.getModel();
                            model.remove(index);
                            try {
                                CSVReader reader = new CSVReader(new FileReader("src\\data\\database.csv"));
                                List<String[]> r = reader.readAll();
                                r.remove(index);
                                CSVWriter writer = new CSVWriter(new FileWriter("src\\data\\database.csv"));
                                writer.writeAll(r);
                                writer.close();
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    });

                    deleteItem.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            super.mouseEntered(e);
                            deleteItem.setBackground(Color.azureRadiance);
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            super.mouseExited(e);
                            deleteItem.setBackground(Color.mako);
                        }
                    });

                    editItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                            frame.dispose();
                            try {
                                CSVReader reader = new CSVReader(new FileReader("src\\data\\database.csv"));
                                List<String[]> r = reader.readAll();
                                String[] row = r.get(list1.getSelectedIndex());
                                EditServer.titleDatabaseStatic = row[0];
                                EditServer.ipServerStatic = row[1];
                                EditServer.portServerStatic = row[2];
                                EditServer.dbNameStatic = row[3];
                                EditServer.index = list1.getSelectedIndex();
                                EditServer.main(null);

                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    });

                    editItem.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            super.mouseEntered(e);
                            editItem.setBackground(Color.azureRadiance);
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            super.mouseExited(e);
                            editItem.setBackground(Color.mako);
                        }
                    });
                }
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    db_name_value = list1.getSelectedValue().toString();
                    int index = list1.getSelectedIndex();
                    CSVReader reader = null;
                    try {
                        reader = new CSVReader(new FileReader("src\\data\\database.csv"));
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    List<String[]> r = null;
                    try {
                        r = reader.readAll();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (CsvException ex) {
                        throw new RuntimeException(ex);
                    }
                    String[] row = r.get(index);
                    url = row[1]+":"+row[2]+"/"+row[3];
                    openLoginPage();
                    JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                    frame.dispose();

                }else if (e.getClickCount()==1){
                    editBtn.setEnabled(true);
                    deleteBtn.setEnabled(true);
                }
            }

        });
    }



    public static void main(String[] args) throws IOException, CsvException {
        try{
            FlatOneDarkIJTheme.setup();

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        JFrame frame = new JFrame("HomePage");

        frame.setContentPane(new HomePage().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.requestFocus();

    }

    public void openLoginPage(){
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.requestFocus();
    }
}

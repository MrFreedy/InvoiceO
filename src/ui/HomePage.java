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


import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import service.database.DTBConnection;

public class HomePage {
    private JPanel panel1;
    private JLabel homepage_title;
    private JButton exitButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton addButton;
    private JTextField ip_server;
    private JTextField port_server;

    private JList<String> server_list;
    private JPanel side_menu;
    private JTextField db_name;

    public static String url;


    DefaultListModel<String> listModel = new DefaultListModel<>();
    public HomePage() {

        read_server_list();


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("add");
                listModel.addElement(ip_server.getText() + ":" + port_server.getText()+"/"+db_name.getText());
                server_list.setModel(listModel);
                JSONObject server_json = new JSONObject();
                JSONObject server_Object = new JSONObject();
                JSONArray server_Array = new JSONArray();

                server_json.put("serverIP", ip_server.getText());
                server_json.put("serverPort", port_server.getText());
                server_json.put("dbName", db_name.getText());

                server_Object.put("server", server_json);

                server_Array.add(server_Object);

                try(FileWriter save_serverlist = new FileWriter("src\\data\\save_server.json")){
                    save_serverlist.write(server_Array.toString());
                    save_serverlist.flush();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        ip_server.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ip_server.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(ip_server.getText().equals("")){
                    ip_server.setText("Enter the IP Address of your Database");
                }
            }
        });

        port_server.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                port_server.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (port_server.getText().isEmpty()) {
                    if (port_server.getText().equals("")) {
                        port_server.setText("Enter the Port of your Database");
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame.dispose();
            }
        });

        server_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2){
                    String[] server = server_list.getSelectedValue().split(":");
                    String[] server2 = server[1].split("/");
                    url= "jdbc:mysql://"+server[0]+":"+server2[0]+"/"+server2[1];
                    DTBConnection.url= url;
                    Login.generateUI();
                }
            }
        });


        db_name.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                db_name.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(db_name.getText().equals("")){
                    db_name.setText("Enter the name of your Database");
                }
            }
        });
    }


    public void read_server_list(){
        JSONParser parser = new JSONParser();
        try(FileReader reader = new FileReader("src\\data\\save_server.json")){
            Object obj = parser.parse(reader);
            JSONArray serverArray = (JSONArray) obj;
            for(Object server : serverArray){
                JSONObject serverObject = (JSONObject) server;
                JSONObject serverJson = (JSONObject) serverObject.get("server");
                String serverIP = (String) serverJson.get("serverIP");
                String serverPort = (String) serverJson.get("serverPort");
                String dbName = (String) serverJson.get("dbName");
                listModel.addElement(serverIP + ":" + serverPort+"/"+dbName);
                server_list.setModel(listModel);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
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

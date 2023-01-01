/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package menu;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import service.database.DTBActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;


public class Id {
    private JPanel panel1;
    private JButton confirmButton;
    private JTextField idField;
    private JLabel title;
    public static String gettedStatus;
    private void failMessage(){
        JFrame frame_fail= new JFrame("Error");
        ImageIcon icon = new ImageIcon("src\\image\\error\\error-32.png");
        frame_fail.setIconImage(icon.getImage());
        frame_fail.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JLabel label_fail = new JLabel("<html><font color='red'>Invoice has been transmitted, cannot be edited !</font></html>");
        JButton okBtn = new JButton("OK");
        okBtn.setBackground(menu.Color.azureRadiance);
        okBtn.setForeground(menu.Color.white);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                frame_fail.dispose();
            }
        });
        //put okBtn in South/East frame_success
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(okBtn);
        frame_fail.add(buttonPanel, BorderLayout.SOUTH);
        okBtn.setPreferredSize(new Dimension(100, 30));
        frame_fail.add(label_fail, BorderLayout.NORTH);
        frame_fail.add(label_fail);
        label_fail.setHorizontalAlignment(SwingConstants.CENTER);
        frame_fail.setSize(300, 150);
        frame_fail.setResizable(false);
        frame_fail.setLocationRelativeTo(null);
        frame_fail.setVisible(true);

    }

    public Id() throws SQLException {
        idField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!idField.getText().equals("Enter your invoice id")){
                }else {
                    idField.setText("");
                }
                idField.setBackground(menu.Color.pickledBluewood);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(idField.getText().equals("")){
                    idField.setText("Enter your invoice id");
                }
                idField.setBackground(menu.Color.defaultColor);
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Edit.id= idField.getText();
                    DTBActions.getStatus();
                    System.out.println(gettedStatus);
                    if(gettedStatus.equals("Transmitted")){
                        failMessage();
                    }else{
                        Edit.main(null);
                        JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(panel1);
                        frame.dispose();
                    }
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
                confirmButton.setBackground(menu.Color.azureRadiance);
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

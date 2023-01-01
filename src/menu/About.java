/*
 * Copyright (c) 2022-2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package menu;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.net.URI;
import java.util.Map;

public class About {
    JPanel panel1;
    private JLabel titleLabel;
    private JLabel linkLabel;
    private JButton donateBtn;
    private JTextPane version100TextPane;





    public About() {



        version100TextPane.setEditable(false);
        linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        linkLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    Desktop.getDesktop().browse(new URI(linkLabel.getText()));}catch (Exception ex){
                    ex.printStackTrace();
                }}
        });

        linkLabel.addMouseListener(new MouseAdapter() {
            Font font = linkLabel.getFont();
            Map attributes = font.getAttributes();

            @Override
            public void mouseEntered(MouseEvent e) {
                //underline
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                linkLabel.setFont(font.deriveFont(attributes));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                attributes.put(TextAttribute.UNDERLINE, -1);
                linkLabel.setFont(font.deriveFont(attributes));
            }
        });
    }

    public static void main(String[] args) {
        try{
            FlatOneDarkIJTheme.setup();

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        JFrame frame = new JFrame("About");
        frame.setContentPane(new About().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setSize(680, 440);
        frame.setVisible(true);


    }
}

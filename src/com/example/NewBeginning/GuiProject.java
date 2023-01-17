package com.example.NewBeginning;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GuiProject extends JFrame{
    JLabel pic;
    Timer tm;
    int x = 0;
    String[] list = {
            "C:/Users/arush/Downloads/IMG-4161.JPG",
            "C:/Users/arush/Downloads/IMG-6389.jpg",
            "C:/Users/arush/Downloads/IMG-8667.JPG",
            "C:/Users/arush/Downloads/50BA02AB-5BEE-40BF-9B6E-76ECEAD173FE.JPG",
            "C:/Users/arush/Downloads/IMG-8774.jpg",
            "C:/Users/arush/Downloads/IMG-1225.mov"

    };
    public  GuiProject() {
           super("Java Slideslow");
           pic = new JLabel();
           pic.setBounds(40, 30, 800, 1000);
           SetImageSize(5);

           tm = new Timer(1000, new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   SetImageSize(x);
                   x += 1;
                   if(x >= list.length)
                       x = 0;
               }
           });
           add(pic);
           tm.start();
           setLayout(null);
           setSize(800, 400);
           getContentPane().setBackground(Color.decode("#bd67b"));
           setLocationRelativeTo(null);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setVisible(true);
    }
    public void SetImageSize(int i){
        ImageIcon  icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);


    }
    public static void main(String[] args){
              new GuiProject();
    }
}

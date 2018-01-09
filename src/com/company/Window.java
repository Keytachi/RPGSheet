package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
    int currentScreen = 0;
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (currentScreen == 0){
            g2d.fillOval(30,30,30,30);
        }
        else if (currentScreen == 1){
            g2d.fillOval(50,50,10,10);
        }

    }

    public void startDrawLoop(){
        new Thread(){
            public void run(){
                while (true){
                    repaint();

                    try {
                        //Delay between redraw
                        Thread.sleep(1000);
                    }
                    catch (Exception e){
                        System.out.println("Failed to sleep draw thread: "+e);
                    }
                }
            }
        }.start();
    }
}

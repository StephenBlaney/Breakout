package brickbreaker;

import javax.swing.*;

public class Breakout {

    public static void main (String [] args){
        JFrame obj = new JFrame(); //JFrame Object
        Gameplay gameplay = new Gameplay(); //Game play object

        obj.setBounds(10,10, 700,600);
        obj.setTitle("brickbreaker.Breakout");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
    }
}

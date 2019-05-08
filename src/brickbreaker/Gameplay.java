package brickbreaker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false; // Prevents game from starting by itself
    private int score = 0; //The starting off score
    private int totalbrick = 21; //  Number of bricks in game
    private Timer time; // how fast the ball moves 


    @Override
    public void actionPerformed(ActionEvent e) { //Action listener

    }

    @Override
    public void keyTyped(KeyEvent e) { //key listener

    }

    @Override
    public void keyPressed(KeyEvent e) { //key listener

    }

    @Override
    public void keyReleased(KeyEvent e) { //key listener

    }
}

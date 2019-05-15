package brickbreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false; // Prevents game from starting by itself
    private int score = 0; //The starting off score
    private int totalbrick = 21; //  Number of bricks in game
    private Timer time; // how fast the ball moves
    private  int delay = 8; // the speed for timer

    private  int playerX = 310; // Starting location of paddle

    private int ballposX = 120; // position of ball on the X axis
    private int ballposY = 350; // position of ball on the Y axis
    private int ballXdir = -1; // sets the diagonal direction of the ball x axis
    private int ballYdir = -2; // sets the diagonal direction of the ball y axis


    public Gameplay(){
        addKeyListener(this);
        setFocusable(true); //demands focus/attention of the method
        setFocusTraversalKeysEnabled(false); //allows to change focus using tabs
        time = new Timer(delay, this); // Timer object speed 8
        time.start(); //begins the execution of a thread
    }

    public void paint(Graphics g){ //Draw
        //background
        g.setColor(Color.BLACK);
        // Paint a rectangle
        g.fillRect(1,1, 692, 592);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592); //left
        g.fillRect(0,0,692,3); //top
        g.fillRect(681,0,3,592); //right

        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100,8); //location of paddle

        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20,20); //location of ball

        g.dispose(); //finnish with graphics

    }

    @Override
    public void actionPerformed(ActionEvent e) { //Action listener
        time.start(); //run
        if(play) { //if button press is true
            if (new Rectangle(ballposX, ballposY, 20,20).intersects(new Rectangle(playerX,550,100,8))){//Makes a physical rectangle
                ballYdir = -ballYdir; //when hit reverse direction
            }
            ballposX += ballXdir; // -1 + -1
            ballposY += ballYdir; // -2 + -2

            if (ballposX < 0) { //left
                ballXdir = -ballXdir; // reverse direction

            }

            if (ballposY < 0) { //Top
                ballYdir = -ballYdir; // reverse direction

            }

            if (ballposX > 670) { //right
                ballXdir = -ballXdir; // reverse direction

            }
        }

        repaint(); //creates the change
    }

    @Override
    public void keyTyped(KeyEvent e) { //key listener

    }

    @Override
    public void keyPressed(KeyEvent e) { //key listener the main one we'll be working with.
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //When right released
            if(playerX >= 600) { //false
                playerX = 600; //border control keep from going out
            }
            else{
                moveRight();//method not created yet
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) { //When left released
            if(playerX <= 10) { //false
                playerX = 10; //border control keep from going out

            }
            else{
                moveLeft(); //method not created yet
            }
        }
    }

    public void moveRight(){
        play = true; //set to false originally
        playerX += 20; //current pos + 20

    }

    public void moveLeft(){
        play = true; //set to false originally
        playerX -= 20; //current pos - 20
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

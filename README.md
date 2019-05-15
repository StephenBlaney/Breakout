# Breakout

Breakout is an arcade game developed and published by Atari and released on May 13, 1976. It was created by Nolan Bushnell and Steve Bristov who where influenced by 1972 Atari arcade game Pong and build by Steve Wozniack. Breakout was the basis and inspiration for certain aspects of the Apple II personal computer. In Breakout, a layer of bricks lines the top third of the screen and the goal is to destroy them all. A ball moves straight around the screen, bouncing off the top and two sides of the screen. When a brick is hit, the ball bounces back and the brick is destroyed. The player loses a turn when the ball touches the bottom of the screen; to prevent this from happening, the player has a horizontally movable paddle to bounce the ball upward, keeping it in play.

We will be developing this game using Java using IntelliJ as my IDE I have my folder structure and file created so we are just going to jump straight in to it. In java we need to create a main method in order for the application to run. This is common to all java projects. The first thing we need to do is to create the frame/window in which our game will be running, so we create a JFrame object. NOTE: Make sure you import the Jframe package. Now we are going to set the properties for this JFrame. The size of our object is set to 10,10 to 700, 600. Title of the frame is set to be call “Breakout” and we prevent resizing the newly created table. In order to see our frame we set srtVisable to true. Finally, we allow our player to exit by issuing the setDefaultCloseOperation to our object. 

```java
public static void main (String [] args){
    JFrame obj = new JFrame();
    obj.setBounds(10,10, 700,600);
    obj.setTitle("Breakout");
    obj.setResizable(false);
    obj.setVisible(true);
    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
```
![1](https://user-images.githubusercontent.com/22968181/57463146-21c66880-7272-11e9-8d7c-343bb83836c3.PNG)

Before we start writing more code we want to create a new java class file called game play which will store the backend logic of our game. We need to create an object of our newly created class and add it to our JFrame. We get an error initially this is because we have not extended our gameplay class to implement JPanel This means that our Gameplay object is a JPanel and can interact with it. We also need to add the required interfaces and abstract methods to the Gameplay file. Next, we want to create a few properties of the game in general. We don’t want the game to start by its self so we create a Boolean var and set it to false, the initial score is set to 0, the number of bricks in our game is set to 21 and timer which is the speed of the ball is set to 8.

PlayerX variable is the x cor of the paddle and that is set to 310 pixels. The coordinates for the ball are also set and the diagonal directions they will be moving in. A constructor is needed to hold all the variables we just set. We add the keylistener to wait for any key inputs from the user as well as enabling different focus capabilities of our components. We create a time variable and set it as the Timer object with Delay and context parameters (8, this). Next a Graphics method is need in order to draw graphics on the screen (Make sure to Import the awt package) with this package we draw a rectangle and set the background to be black. We create three borders on our screen that will act as the boundaries of the game we set the colour of this boundary to yellow and configure where it will be drawn on the screen, we also do the exact same thing to the paddle and ball. We plug in the values of our previous created variable as parameters to these objects but remember all they hold is int values.

Moving on to the next method make your way down to the keypressed methods near the end of your code there should be three methods keyTyped, keyReleased and keyPressed we don’t need the first two, but java will throw an error if we don’t have it in there. In the KeyPressed method you want to create two conditionals that will detect when the user has pressed the right and left buttons. To prevent our paddle from moving outside the compounds of out game we need to create another conditional under the previous one that will check that the paddle hasn’t  conceded (600 right 10 left pixels) and if it has set the current position to it to prevent it from going any further otherwise we move left or right receptively now we have not created them methods yet so that’s what we need to do next within these newly developed methods we need  to set the play variable to true so that our paddle can move and to create the motion all we do is get the current position of our player and add it by + 20 for right and – 20 for left. To get all this working we need to go In to our action performed listener and run the game and repaint so that we can see the changes in the game 

```java
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
```

Next, we need to create the motion of the ball. All these actions will be performed in well the actioned performed method. We start by creating a conditional that when a button is pressed we add to the current pixels of both diagonal direction by itself (-1, -2) and when the current ball exceeds the specified current position we reverse the current direction we it’s going.


![2](https://user-images.githubusercontent.com/22968181/57463213-46224500-7272-11e9-996a-852b7cef445f.PNG)


# breakout

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
Before we start writing more code we want to create a new java class file called game play which will store the backend logic of our game. We need to create an object of our newly created class and add it to our JFrame. We get an error initially this is because we have not extended our gameplay class to implement JPanel This means that our Gameplay object is a JPanel and can interact with it. We also need to add the required interfaces and abstract methods to the Gameplay file. Next, we want to create a few properties of the game in general. We don’t want the game to start by its self so we create a Boolean var and set it to false, the initial score is set to 0, the number of bricks in our game is set to 21 and timer which is the speed of the ball is set to 8.

PlayerX variable is the x cor of the paddle and that is set to 310 pixels. The coordinates for the ball are also set and the diagonal directions they will be moving in. A constructor is needed to hold all the variables we just set. We add the keylistener to wait for any key inputs from the user, 

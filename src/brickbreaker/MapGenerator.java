package brickbreaker;

import java.awt.*;

public class MapGenerator {
    public int map[][]; //contains bricks
    public int brickwidth;
    public int brickheight;

    public MapGenerator(int row, int col){
        map = new int[row][col];
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                map[i][j] = 1; //bricks are assigned 1
            }
        }
        brickwidth = 540/col;
        brickheight = 150/row;
    }

    public void draw(Graphics2D g){
        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] > 0) { //if bricks are there meaning one
                    g.setColor(Color.white);
                    g.fillRect(j * brickwidth + 80, i * brickheight + 50, brickwidth, brickheight); //positioning of bricks

                }
            }
        }

    }
}

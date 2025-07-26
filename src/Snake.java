import java.awt.*; //Needed for graphics and color classes ued in drawing
import java.awt.event.*; //Event Handling

public class Snake {
    //Arrays to store x and y coordinates of each body segment of the snake
    private final int[] x;
    private final int[] y;
    private int bodyParts = 6; //Initial number of body parts
    private char direction = 'R'; //Current direction of movement(Right)
    private final int tileSize; //size of one square tile

    //Constructor to initialsie snake arrays and tile size
    public Snake(int maxLength, int tileSize) {
        x = new int[maxLength]; //Allocate x-position array for max possible length
        y = new int[maxLength]; //Allocate y-position array for max possible length
        this.tileSize = tileSize; //Store tile size for consistent movement/drawing
    }

    //Method to update the snake's position on each timer tick
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1]; //Set x of current part = x of previous part
            y[i] = y[i - 1]; //Set y of current part = y of previous part
        }

        //Move the head in the current direction
        switch (direction) {
            case 'U': y[0] -= tileSize; break; //Move UP
            case 'D': y[0] += tileSize; break; //Move DOWN
            case 'L': x[0] -= tileSize; break; //Move LEFT
            case 'R': x[0] += tileSize; break; //Move RIGHT
        }
    }

    //Method to grow the snake (called when apple is eaten)
    public void grow() {
        bodyParts++; //Increase the length by 1 segment
    }

    //Method to update the direction of the snake based on key pressed
    public void changeDirection(int keyCode) {
        switch (keyCode) {
            //Prevent the snake from reversing directly
            case KeyEvent.VK_LEFT:
                if (direction != 'R') direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') direction = 'R';
                break;
            case KeyEvent.VK_UP:
                if (direction != 'D') direction = 'U';
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') direction = 'D';
                break;
        }
    }

    //Method to check if the head of the snake has collided with its body
    public boolean checkSelfCollision() {
        for (int i = bodyParts; i > 0; i--) {
            //if head position matches any of its body positions
            if (x[0] == x[i] && y[0] == y[i]) {
                return true; //Collision detected
            }
        }
        return false; //No collision
    }

    //Method to draw snake on screen
    public void draw(Graphics g) {
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(new Color(45, 180, 0));
            }
            g.fillRect(x[i], y[i], tileSize, tileSize); //Draw each segment
        }
    }

    //Returns x-coordinate of snake's head
    public int getHeadX() {
        return x[0];
    }

    //Returns y-coordinate of snake's head
    public int getHeadY() {
        return y[0];
    }
}

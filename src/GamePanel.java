import javax.swing.*; //For JPanel, JButton, Timer, etc.
import java.awt.*; //For graphics (Color, Dimension, Font, etc.)
import java.awt.event.*; //Event Handling (ActionEvent, KeyEvent)
import java.util.Random; //For generating random apple positions

//GamePanel handles game logic, drawing, and Keyboard input
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final int TILE_SIZE = 25; //Size of each tile in the grid
    private final int WIDTH = 25; //No. of horizontal tiles
    private final int HEIGHT = 25; //No. of vertical lines
    private final int DELAY = 150; //Delay in ms between moves
    private final int GAME_UNITS = WIDTH * HEIGHT; //Total no. of blocks(max snake length)

    private Snake snake; //Snake object that holds snake logic
    private int appleX, appleY;//Current apple's X and Y position
    private int applesEaten; //Score counter
    private Timer timer; //Swing timer to control game loop
    private boolean running = false; //Game running status
    private Random random; //Random number generator for apple
    private JButton tryAgainButton; //Button to restart game after Game Over

    //Constructor - initializes panel and game
    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE)); //Set game area size
        this.setBackground(Color.black); //Set background color
        this.setFocusable(true); //Allow keyboard input
        this.setLayout(null); //No layout manager for manual settings
        this.addKeyListener(this); //Listen for Key Events

        random = new Random(); //Initialize random object
        //Create and configure the "Try Again" button
        tryAgainButton = new JButton("Try Again");
        tryAgainButton.setBounds(WIDTH * TILE_SIZE / 2 - 75, HEIGHT * TILE_SIZE / 2 + 40, 150, 40);
        tryAgainButton.setVisible(false); //Hidden initially
        tryAgainButton.addActionListener(e -> restartGame()); //restart game on click
        this.add(tryAgainButton); //add button to panel

        startGame(); //start the game
    }

    //starts a new game
    public void startGame() {
        snake = new Snake(GAME_UNITS, TILE_SIZE); //create new snake
        applesEaten = 0; //reset score
        newApple(); //place new apple
        running = true; //set running status
        timer = new Timer(DELAY, this); //Initialize timer with delay and listener
        timer.start(); //start game loop
    }

    //Restarts game (after Game Over)
    public void restartGame() {
        startGame(); //start a fresh game
        tryAgainButton.setVisible(false); //Hide the button again
        repaint(); //Redraw the screen
    }

    //Randomly places a new apple on the grid
    public void newApple() {
        appleX = random.nextInt(WIDTH) * TILE_SIZE; //Random X position on the grid
        appleY = random.nextInt(HEIGHT) * TILE_SIZE; //Random Y position on the grid
    }

    //This method is automatically called to paint everything on the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //Clears the previous frame
        if (running) {
            //Draw apple
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, TILE_SIZE, TILE_SIZE);

            //Draw snake
            snake.draw(g);

            //Draw score
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: " + applesEaten, 10, 25); //Top-left corner
        } else {
            gameOver(g); //Show Game Over Screen
        }
    }

    //Displays the Game Over screen
    public void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Score: " + applesEaten, WIDTH * TILE_SIZE / 2 - 60, HEIGHT * TILE_SIZE / 2 - 50); //score text

        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Game Over", WIDTH * TILE_SIZE / 2 - 120, HEIGHT * TILE_SIZE / 2); //Centered Game Over

        tryAgainButton.setVisible(true); //Show the restart button
    }

    //Checks if snake ate the apple
    public void checkApple() {
        if (snake.getHeadX() == appleX && snake.getHeadY() == appleY) {
            snake.grow(); //Increase snake length
            applesEaten++; //Increase score
            newApple(); //Spawn new apple
        }
    }

    //Checks for wall or self collision
    public void checkCollisions() {
        if (snake.checkSelfCollision() ||
                snake.getHeadX() < 0 || snake.getHeadX() >= WIDTH * TILE_SIZE ||
                snake.getHeadY() < 0 || snake.getHeadY() >= HEIGHT * TILE_SIZE) {
            running = false; //stop the game
            timer.stop(); //stop the timer
        }
    }

    //Called automatically by the timer every DELAY ms
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            snake.move(); //Move the snake
            checkApple(); //check if apple eaten
            checkCollisions(); //check if game over
        }
        repaint(); //redraw the screen
    }

    //Keyboard input - changes snake direction
    @Override
    public void keyPressed(KeyEvent e) {
        snake.changeDirection(e.getKeyCode()); //pass key code to snake class
    }

    //Required by KeyListener interface (not used)
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}

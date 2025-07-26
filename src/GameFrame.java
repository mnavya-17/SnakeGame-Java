import javax.swing.*; //imports all the Swing classes needed for building GUI componenets

public class GameFrame { //enrty point of the game
    public static void main(String[] args) { //main method where the program starts execution
        JFrame frame = new JFrame("Snake Game"); //creates a new window
        GamePanel panel = new GamePanel(); //Creates an instance of GamePanel(custom JPanel where game is drawn and logic runs)

        frame.add(panel); //adds GamePanel object to JFrame(adds game contents to the window)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ensures the program exits when the window is closed
        frame.setResizable(false); //prevents the user from resizing the game window (so the game's layout won't break)
        frame.pack(); //Sizes the frame so that all its contents are at or above thier preferred sizes(calls GamePanel's getPreferredSize)
        frame.setLocationRelativeTo(null); //centers the frame on the screen
        frame.setVisible(true); //Makes the window visible
    }
}
/**
 * Class to create the application window for rendering the graphics
 */

import javax.swing.*;
import java.awt.*;

public class ApplicationWindow {

    public static  int windowHeight = 700;  //height of window
    public static int windowWidth = 1200;   //width of the window

    public static void init()
    {
        JFrame frame = new JFrame("Grapher");   //the window
        frame.setSize(new Dimension(windowWidth, windowHeight));    //initializing the window dimensions
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //making sure that top right x button ends the program
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); //make it not invisible

        frame.add(new Display());   //add a thing to draw the graphics on
    }
}

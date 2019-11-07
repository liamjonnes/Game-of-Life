import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * A class that allows for the visualisation of the game in
 * a Graphical User Interface (Java Swing).
 * 
 * @author Liam Jones
 */
public class GridDisplay extends JPanel {
  
  public Game game;

  /**
   * Initialises a new grid/game that will be displayed
   * within a JPanel; the background colour is white, and
   * thus any dead cells will also be white; any alive
   * cells will be another colour.
   * 
   * @param game  that will get visualised
   */
  public GridDisplay(Game game) {
    this.game = game;
    setBackground(Color.WHITE)
    setPreferredSize(new Dimension(400, 400));
  }
}

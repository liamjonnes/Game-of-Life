import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A class that allows for the visualisation of the game in
 * a Graphical User Interface (Java Swing).
 * 
 * @author Liam Jones
 */
public class GridDisplay extends JPanel {
  
  private Game game;

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
    game.populateGrid();
    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(400, 400));
  }
  
  /**
   * Overrides the default paintComponent for Swing;
   * this allows for a custom square to be painted in a
   * chosen position with relation to where a cell is
   * on the grid.
   */
  @Override
  public void paintComponent(Graphics g) {
    for(int x = 0; x < game.getGameSize(); x++) {
      for(int y = 0; y < game.getGameSize(); y++) {
        
        // checks if the cell is alive; if so colour it in black;
        // otherwise colour it in white
        if(game.getCell(x, y) == 1) {
          g.setColor(Color.BLACK);
          g.fillRect((x * 10), (y * 10), 10, 10);
        } else {
          g.setColor(Color.WHITE);
          g.fillRect((x * 10), (y * 10), 10, 10);
        }
      }
    }
  }
}

import java.util.Timer;
import java.util.TimerTask;

/**
 * A controller that links together the model (Game.java),
 * the view (GridDisplay.java).
 * 
 * @author Liam Jones
 *
 */
public class Controller {

  private Game game;
  private GridDisplay grid;
  private Timer timer;
  private static final int PERIOD = 150;
  
  /**
   * Initialises the controller.
   * 
   * @param game  the game to iterate through
   * @param grid  the grid to paint
   */
  public Controller(Game game, GridDisplay grid) {
    this.game = game;
    this.grid = grid;
    this.runGame();
  }
  
  /**
   * Runs the game, and changes the grid every 0.2 seconds.
   */
  public void runGame() {
    timer = new Timer();
    
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        game.iterateGrid();
        
        grid.repaint();
      }
    },0 , PERIOD);
  }
}

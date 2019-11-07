import java.util.Timer;
import java.util.TimerTask;

public class Controller {

  public Game game;
  public GridDisplay grid;
  public Timer timer;
  
  public Controller(Game game, GridDisplay grid) {
    this.game = game;
    this.grid = grid;
  }
  
  public void runGame() {
    timer = new Timer();
    
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        game.iterateGrid();
        
        grid.repaint();
      }
    }, 200);
  }
}

/**
 * A class that contains the rules of the Game of Life:
 * 
 * Scenario 0: No interactions; 
 * Scenario 1: Underpopulation;
 * Scenario 2: Overcrowding; 
 * Scenario 3: Survival;
 * Scenario 4: Creation of Life; 
 * Scenario 5: Grid with no live cells;
 * Scenario 6: Expected game outcome for seeded grid
 * 
 * @author Liam Jones
 */
public class Game {

  public int gameSize;
  public int[][] grid;
  
  /**
   * Initialises a grid (array of N x N elements) where
   * cells will be displayed.
   * 
   * @param size  the size that the grid would be
   */
  public Game(int size) {
    this.gameSize = size;
    this.grid = new int[gameSize][gameSize];
  }
  
  /**
   * Obtains the size of the grid.
   * 
   * @return  the size of the grid
   */
  public int getGameSize() {
    return this.gameSize;
  }
  
  /**
   * Obtains the grid.
   * 
   * @return  the grid
   */
  public int[][] getBoard() {
    return this.grid;
  }
}

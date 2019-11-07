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

  private int gameSize;
  private int[][] grid;
  private static final int CELLALIVE = 1;
  private static final int CELLDEAD = 0;
  
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
  
  /**
   * Obtains the value of a cell (whether it's alive or 
   * dead).
   * 
   * @param x the X axis position of a cell
   * @param y the Y axis position of a cell
   * @return  the value of a cell (1 - alive; 0 - dead)
   */
  public int getCell(int x, int y) {
    if(grid[x][y] == CELLALIVE) {
      return CELLALIVE;
    } else {
      return CELLDEAD;
    }
  }
  
  /**
   * Creates Scenario Six of the PDF on the grid (1x3 row
   * of cells)
   */
  public void createScenarioSix() {
    int middleOfGrid = 0;
    
    // if gameSize is even, do...; else if odd, do...
    if(gameSize % 2 == 0) {
      middleOfGrid = (gameSize / 2);
    } else {
      middleOfGrid = ((gameSize / 2 ) + 1); // + 1 as Java rounds down
    }
    
    grid[middleOfGrid-1][middleOfGrid-2] = 1;   // middle position - 1
    grid[middleOfGrid-1][middleOfGrid -1] = 1;  // middle position
    grid[middleOfGrid-1][middleOfGrid] = 1;     // middle position + 1
  }
  
  /**
   * Fills the grid randomly with alive or dead cells.
   */
  public void populateGrid() {
    double randomValue = 0;
    
    for(int x = 0; x < gameSize; x++) {
      for(int y = 0; y < gameSize; y++) {
        randomValue = Math.random();  // different value is determined
                                      // for each grid position
        if(randomValue > 0.8) {
          grid[x][y] = CELLALIVE;
        } else {
          grid[x][y] = CELLDEAD;
        }
      }
    }
  }
  
  /**
   * Obtains the number of neighbours that a cell has
   * (horizontally, vertically, or diagonally adjacent)
   * 
   * @param   x the X axis position of a cell
   * @param   y the Y axis position of a cell
   * @return  the number of neighbours that the cell has
   */
  public int getNumberOfNeighbours(int x, int y) {
    int numberOfNeighbours = 0;
    
    for(int i = x - 1; i <= x + 1; i++) {
      for(int j = y - 1; j <= y + 1; j++) {
        if(grid[i][j] == 1) {
          if(x != i || y != j) {
            numberOfNeighbours++;
          }
        }
      }
    }
    return numberOfNeighbours;
  }
  
  /**
   * Iterates the grid, then saves the new iteration as a new state
   * when complete.
   * 
   * @return  an updated grid with a new state
   */
  public int[][] iterateGrid() {
    int[][] copyOfGrid = new int[grid.length][grid.length];
    
    for(int x = 1; x < gameSize - 1; x++) {
      for(int y = 1; y < gameSize - 1; y++) {
        int numberOfNeighbours = getNumberOfNeighbours(x, y);
        
        if(grid[x][y] == CELLALIVE) {
          if((numberOfNeighbours < 2) || (numberOfNeighbours > 3)) {
            copyOfGrid[x][y] = CELLDEAD;
          }
          if((numberOfNeighbours == 2) || (numberOfNeighbours == 3)) {
            copyOfGrid[x][y] = CELLALIVE;
          }
        }
        if((grid[x][y] == CELLDEAD) && (numberOfNeighbours == 3)) {
          copyOfGrid[x][y] = CELLALIVE;
        }
      }
    }
    
    grid = copyOfGrid;
    
    return grid;
  }
  
  /**
   * Prints the grid to the console for each state.
   * 
   * @param numberOfTimes that the grid should be printed in the console
   */
  public void printGrid(int numberOfTimes) {
    populateGrid();
    
    for(int i = 0; i < numberOfTimes; i++) {
      for(int j = 0; j < grid.length; j++) {
        for(int k = 0; k < grid.length; k++) {
          System.out.print(grid[j][k] + " ");
        }
        System.out.println();
      }
      
      System.out.println(); // used to separate each state
      
      iterateGrid();
    }
  }
}

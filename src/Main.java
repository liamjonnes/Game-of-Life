import java.util.Scanner;

import javax.swing.JFrame;

/**
 * A class that allows the Game of Life to be run with the users preferred type of interface
 * (command line, or a graphical user interface).
 * 
 * @author Liam Jones
 */
public class Main {
  
  private static Scanner scanner = new Scanner(System.in);
  private static final int WIDTH = 740;
  private static final int HEIGHT = 715;

  /**
   * The code that is run when starting the program.
   * 
   * @param args  any possible command line arguments
   */
  public static void main(String[] args) {
    chooseUIDialog();
  }
  
  /**
   * Allows the user to choose which UI they want to use; loops until the user
   * chooses one of the three options.
   */
  public static void chooseUIDialog() {
    while(true) {
      System.out.println("How would you like to run the program?");
      System.out.println("(c) for via the command line, (g) for the graphical user interface, or (q) to quit.");
      String runVia = scanner.next();
      char userInput = runVia.charAt(0);  // converts the user input to a character
      
      if((userInput == 'c') || (userInput == 'C')) {
        commandLineUI();
        break;
      } else if((userInput == 'g') || (userInput == 'G')) {
        graphicalUI();
        break;
      } else if((userInput == 'q') || (userInput == 'Q')) {
        System.exit(0);
      }
    }
  }
  
  /**
   * Initialises the Command Line User Interface.
   */
  public static void commandLineUI() {
    System.out.println("How big should the grid be? ");
    int gridSize = scanner.nextInt();
    System.out.println("How many states should be printed?");
    int numberOfStates = scanner.nextInt();
    
    Game game = new Game(gridSize);
    
    game.printGrid(numberOfStates);
  }
  
  /**
   * Initialises the Graphical User Interface (GUI).
   */
  public static void graphicalUI() {
    JFrame frame = new JFrame("Game of Life");
    
    Game game = new Game(70);
    GridDisplay grid = new GridDisplay(game);
    Controller controller = new Controller(game, grid);
    
    frame.setSize(HEIGHT, WIDTH);
    frame.add(grid);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setVisible(true);
  }
}

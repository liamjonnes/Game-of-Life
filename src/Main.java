import java.util.Scanner;

import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    while(true) {
      System.out.println("How would you like to run the program?");
      System.out.println("(c) for via the command line, (g) for the graphical user interface, or (q) to quit.");
      String runVia = scanner.next();
      char userInput = runVia.charAt(0);  // converts the user input to a character
      
      if((userInput == 'c') || (userInput == 'C')) {
        System.out.println("How big should the grid be? ");
        int gridSize = scanner.nextInt();
        System.out.println("How many states should be printed?");
        int numberOfStates = scanner.nextInt();
        
        Game game = new Game(gridSize);
        
        game.printGrid(numberOfStates);
        break;
      } else if((userInput == 'g') || (userInput == 'G')) {
        JFrame frame = new JFrame("Game of Life");
        
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        break;
      } else if((userInput == 'q') || (userInput == 'Q')) {
        System.exit(0);
      }
    }
  }
}

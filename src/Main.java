import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("How big should the grid be? ");
    int gridSize = scanner.nextInt();
    System.out.println("How many states should be printed?");
    int numberOfStates = scanner.nextInt();
    
    Game game = new Game(gridSize);
    
    game.printGrid(numberOfStates);
  }

}

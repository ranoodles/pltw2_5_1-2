/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;
  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    boolean isPlayer1 = true;
    Player playerCurrent = player1;

    Scanner input = new Scanner(System.in);
    
    while (!solved) 
    {
      /* your code here - game logic */
      System.out.println("\n" + player1.getName() + " Score: " + player1.getPoints());
      System.out.println(player2.getName() + " Score: " + player2.getPoints() + "\n");

      System.out.println("It is " + playerCurrent.getName() + "\'s turn");
      System.out.println(board.getSolvedPhrase());
      System.out.print("Type a phrase or letter to guess: ");
      String userGuess = input.nextLine();

      if (board.guessLetter(userGuess)) {
        System.out.println("That was a good guess!");
        playerCurrent.addToPoints(board.getLetterValue());
      } else if (board.isSolved(userGuess)) {
        solved = true;
        playerCurrent.addToPoints(board.getLetterValue());
      } else {
        System.out.println("Nope, that was incorrect!");
      }

      isPlayer1 = !isPlayer1;
      playerCurrent = isPlayer1 ? player1 : player2;
    }

    System.out.println("Congrats, the correct phrase was " + board.getPhrase());
    if (player1.getPoints() > player2.getPoints()) {
      System.out.println(player1.getName() + " won with " + player1.getPoints());
    } else if (player2.getPoints() > player1.getPoints()) {
      System.out.println(player2.getName() + " won with " + player2.getPoints());
    } else {
      System.out.println("Both players tied!");
    }
  }
}
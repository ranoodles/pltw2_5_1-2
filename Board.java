/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board() {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
    System.out.println("Phrase: " + phrase);
  }
  /* your code here - accessor(s) */
  public String getSolvedPhrase() {
    return solvedPhrase;
  }
  public String getPhrase() {
    return phrase;
  }
  public int getCurrentValue() {
    return currentLetterValue;
  }
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }

  /*
   * Takes a guessed letter as an input and checked if it was even in the word.
   * The method changes the solvedPhrase based on the input of the program.
   * Precondition:
   *  User must guess a letter and it needs to be the word
   * Postcondition:
   *  Returns a boolean of whether or not the letter is in the word
   *  The solvedPhrase String is modified based on the guess
   */
  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false;
    String newSolvedPhrase = "";  
    //loops through all characters in a String
    for (int i = 0; i < phrase.length(); i++)
    {
      //compares each letter to guess
      if (phrase.substring(i, i + 1).equals(guess)) {
        //add letter to newSolvedPhrase to show it filled out
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      //The guessed letter is not in the phrase so copy current underscore and space to new solved phrase.
      //i*2 is used because solvedPhrase is double in length due to added spaces
      else {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    //solvedPhrase is assigned the new phrase
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  } 
} 
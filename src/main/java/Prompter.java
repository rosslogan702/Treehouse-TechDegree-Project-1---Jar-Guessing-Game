import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompter {
  private Game mGame;
  private int numberOfGuesses;
  private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  public Prompter(Game game){
   this.mGame = game; 
  }
  
  public void administratorSetup(){
    try {
      System.out.print("Pleae enter the item name: ");
      String itemName = br.readLine();
      System.out.print("What is the maximum number of " 
                        + itemName + " that can fit in the jar " + ": ");
      String maxItems = br.readLine();
      mGame.setup(itemName, maxItems);
      
    } catch (IOException ioe){
      System.out.println("Error when reading input from console! Exiting!");
      System.exit(-1);
    }
    
  }
  
 public int promptForGuess(){
  System.out.println("How many " + mGame.getJar().getItemName() + "s" 
                     + " are in the jar?" + " Pick a number between 1 and " +
                     mGame.getJar().getMaxItems() + ": ");
   String guessAsString="";
   try {
   guessAsString = br.readLine();
  } catch (IOException ioe){
    System.out.println("Error reading in data from the console! Exiting!");
    System.exit(-1);
   }
    int guess = Integer.parseInt(guessAsString);
    return guess;
 }
  
  public void checkGuess(int guess){
      if(mGame.isGuessOverMaxLimit(guess)){
        System.out.println("Your guess must be less than or equal to " + mGame.getJar().getMaxItems());
      } else if (mGame.isTooLow(guess)){
        numberOfGuesses++;
        System.out.println("Your guess is too low!");
      } else if (mGame.isTooHigh(guess)){
        numberOfGuesses++;
        System.out.println("Your guess is too high!");
      } else if (mGame.isGuessedCorrectly(guess)){
        numberOfGuesses++;
        System.out.println("You got it in " + numberOfGuesses + " attempt(s)");
      }
  }
  
  public void play(){
    administratorSetup();
    while(!mGame.guessedCorrectly()){
      checkGuess(promptForGuess());
    }
  }
  
  public void shutdown(){
      if(br !=null){
        try {
          br.close();
        } catch (IOException ioe){
          ioe.printStackTrace();
          System.exit(-1);
        }
    }
   
  }
}
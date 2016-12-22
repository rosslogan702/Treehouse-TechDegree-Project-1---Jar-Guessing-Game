import java.io.Console;

public class Game {
  
  private Console console = System.console();
  private Jar mJar;
  boolean mGuessedCorrectly = false;
  private int mNumberOfGuesses=0;
  
  public void setup(String itemName, String maxItems) {
    mJar = new Jar(itemName, Integer.parseInt(maxItems));
    mJar.fill(Integer.parseInt(maxItems));
  }
  
  public boolean applyGuess(int guess){
    if(guess > mJar.getMaxItems()){
      /**I understand that I have deviated from the spec here in terms of the message printed out
      however I think that this is the correct message to display as the correct number of items
      could be the max value in which case the guess would not be less than the max value **/
      System.out.println("Your guess must be less than or equal to " + mJar.getMaxItems());
      return mGuessedCorrectly;
    }
    if(guess == mJar.getItemsInJar()){
      mGuessedCorrectly = true;
      } else if (guess > mJar.getItemsInJar()){
        System.out.println("Your guess is too high!");
    } else {
        System.out.println("Your guess is too low!");
    }
      mNumberOfGuesses++;
      return mGuessedCorrectly;
    }
  
  public boolean guessedCorrectly() {
    return mGuessedCorrectly;
  }
  
  public Jar getJar(){
   return mJar; 
  }
  
  public int getNumberOfGuesses(){
    return mNumberOfGuesses;
  }
}

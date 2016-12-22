import java.util.Scanner;

public class Prompter {
  private Game mGame;
  private int numberOfGuesses;
  private Scanner scanner = new Scanner(System.in);
  
  public Prompter(Game game){
   this.mGame = game; 
  }
  
  public void administratorSetup(){
      System.out.println("Pleae enter the item name: ");
      String itemName = scanner.nextLine();
      System.out.println("What is the maximum number of " 
                        + itemName + "s" + " that can fit in the jar " + ": ");
      String maxItems = scanner.nextLine();
      mGame.setup(itemName, maxItems);
    
  }
  
 public boolean promptForGuess(){
    System.out.println("How many " + mGame.getJar().getItemName() + "s" 
                            + " are in the jar?" + " Pick a number between 1 and " +
                                            mGame.getJar().getMaxItems() + ": ");
    String guessAsString = scanner.nextLine();
    int guess = Integer.parseInt(guessAsString);
    return mGame.applyGuess(guess);
  }
  
  public void play(){
    administratorSetup();
    while(!mGame.guessedCorrectly()){
      promptForGuess();
      numberOfGuesses++;
    }
    System.out.println("You got it in " + mGame.getNumberOfGuesses() + " attempt(s)");
  }
  
  public static void main (String [] args){
    Game game = new Game();
    Prompter gamePrompter = new Prompter(game);
    gamePrompter.play();
  }
}
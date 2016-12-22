public class Game {
  
  private Jar mJar;
  boolean mGuessedCorrectly = false;
  
  public void setup(String itemName, String maxItems) {
    mJar = new Jar(itemName, Integer.parseInt(maxItems));
    mJar.fill(Integer.parseInt(maxItems));
  }
  
  public boolean isGuessOverMaxLimit(int guess) {
    return (guess > mJar.getMaxItems());
  }
  
  public boolean isTooHigh(int guess){
    return (guess > mJar.getItemsInJar());
  }
  
  public boolean isTooLow(int guess){
    return (guess < mJar.getItemsInJar());
  }
  
  public boolean isGuessedCorrectly(int guess){
    if(guess == mJar.getItemsInJar()){
      mGuessedCorrectly=true;
    }
    return mGuessedCorrectly;
  }
  
  public boolean guessedCorrectly() {
    return mGuessedCorrectly;
  }
  
  public Jar getJar(){
   return mJar; 
  }
  
  public static void main (String [] args){
    Game game = new Game();
    Prompter gamePrompter = new Prompter(game);
    gamePrompter.play();
    gamePrompter.shutdown();
  }
}

import java.util.Random;

public class Jar {
  
  private String mItemName;
  private int mMaxItems;
  private int mItemsInJar;
  
  public Jar(String itemName, int maxItems) {
    mItemName = itemName;
    mMaxItems = maxItems;
  }
  
  public String getItemName() {
    return mItemName;
  }
  
  public int getMaxItems() {
    return mMaxItems; 
  }
  
  public int getItemsInJar() {
    return mItemsInJar;
  }
  
  public void fill(int maxItems){
    Random random = new Random();
    mItemsInJar = random.nextInt(maxItems);
  }
  
}
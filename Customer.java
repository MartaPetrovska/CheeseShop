import java.util.ArrayList;

public class Customer{
  private String name;
  private int balance;
  private ArrayList<Cheese> itemsOwned;

  public Customer (String name, int balance) {
    this.name = name;
    this.balance = balance;
    this.itemsOwned = new ArrayList<Cheese>();
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getBalance() {
      return balance;
  }

  public void setBalance(int balance) {
      this.balance = balance;
  }

  public ArrayList<Cheese> getItemsOwned() {
      return itemsOwned;
  }

  public void setItemsOwned(ArrayList<Cheese> itemsOwned) {
      this.itemsOwned = itemsOwned;
  }

  

}

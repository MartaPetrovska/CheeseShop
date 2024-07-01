import java.util.ArrayList;

//Item service functionality in different class
// adding items
// remove items
// update items
// get items

public class CheeseService{

  public static ArrayList<Cheese> cheeses = new ArrayList<Cheese>(); //can only contain objects of the Cheese class (ArrayList<Cheese>).

  public void addCheese(Cheese cheese) {
    cheeses.add(cheese);
  }

  public void removeCheese(int id) {
    for (var cheese : cheeses) {
      if (cheese.getId() == id) {
        cheeses.remove(cheese);
        return;
      }
    }
  }

  public void updateCheese(int id, String name, String type, String location, int price) {
    for (var cheese : cheeses) {
      if (cheese.getId() == id) {
        cheese.setName(name);
        cheese.setType(type);
        cheese.setLocation(location);
        cheese.setPrice(price);
        return;
      }
    }
  }

  public ArrayList<Cheese> getCheese() {
    return cheeses;
  }

  
}

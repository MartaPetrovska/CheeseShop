public class Cheese {
  private int id;
  private String name;
  private String type;
  private String location;
  private int price; //can add quantity

  public Cheese(int id, String name, String type, String location, int price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.location = location;
    this.price = price;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public int getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }
}

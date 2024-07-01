import java.util.ArrayList;

public class CheeseShop {
    public ArrayList<Cheese> cart = new ArrayList<Cheese>();
    private static CheeseService cheeseService = new CheeseService(); //static because all instances should be the same. Without static, every time we call cheeseService, it creates another separate instance, therefore when updating one, other ones stays the same. 


    public void addToCart(String name) { //can add -> if quantity (this should be parameter added by customer) >0, then add corresponding quantity to cart. When addind to cart, update quantity as needed (quantity in shop and quantity in cart should differ).
        for (Cheese cheese : cheeseService.getCheese()) {
            if (cheese.getName().equals(name)) {
                cart.add(cheese);
                System.out.println("Added " + name + " to cart."); 
                return;
            }
        }
        System.out.println("Cheese " + name + " not found."); 
    }

    public void removeFromCart(String name) {
        for (var cheese : cart) {
            if (cheese.getName().equals(name)) {
                cart.remove(cheese);
                return;
            }
        }
        System.out.println("Cheese " + name + " not found in cart.");
    }

    public ArrayList<Cheese> getCart() {
        return cart;
    }

    public int checkout() {
        int sum = 0;
        for (var cheese : cart) {
            sum += cheese.getPrice();
        }
        cart.clear();
        return sum;
    }
}

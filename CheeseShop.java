import java.util.ArrayList;

public class CheeseShop {
    public ArrayList<Cheese> cart = new ArrayList<Cheese>();
    private static CheeseService cheeseService = new CheeseService(); //static because all instances should be the same. Without static, every time we call cheeseService, it creates another separate instance, therefore when updating one, other ones stays the same. 
    private static CustomerService customerService = new CustomerService();


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

    
    public int checkout(String customerName) {
        Customer customer = findCustomerByName(customerName);
        if (customer == null) {
            System.out.println("Customer " + customerName + " not found.");
            return -1;
        }

        int totalCost = 0;
        for (var cheese : cart) {
            totalCost += cheese.getPrice();
        }

        if (totalCost > customer.getBalance()) {
            System.out.println("Insufficient balance for customer " + customerName + ".");
            return -1;
        }

        customer.setBalance(customer.getBalance() - totalCost);
        customer.getItemsOwned().addAll(cart);
        cart.clear();
        System.out.println("Checkout successful. Total amount: " + totalCost + ". Remaining balance: " + customer.getBalance());
        System.out.println("Thank you for using our shop! See you next time!");
        return totalCost;
    }
  /*public int checkout(String name) { //search this name in customer list
        int sum = 0; // check if total sum is larger than customers balace and substract it. Add items to itemsOwned
        for (var cheese : cart) {
            sum += cheese.getPrice();
        }
        cart.clear();
        return sum;
    }*/

    private Customer findCustomerByName(String name) {
        for (Customer customer : CustomerService.customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}

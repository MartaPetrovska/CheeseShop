import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CheeseService cheeseService = new CheeseService();
    private static CheeseShop cheeseShop = new CheeseShop();
    private static CustomerService customerService = new CustomerService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to cheese shop! Please select access type: ");
            System.out.println("1 - admin;");
            System.out.println("2 - customer;");
            System.out.println("3 - exit.");

            var accessType = scanner.nextLine();

            if (accessType.equals("1")) {
                // Admin actions loop
                while (true) {
                    System.out.println("Please choose an action:");
                    System.out.println("1 - add item;");
                    System.out.println("2 - update item;");
                    System.out.println("3 - remove item;");
                    System.out.println("4 - change access type;");
                    System.out.println("5 - exit.");

                    var adminAction = scanner.nextLine();

                    if (adminAction.equals("1")) {
                        addCheese();
                        printCheese();
                    } else if (adminAction.equals("2")) {
                        updateCheese();
                        printCheese();
                    } else if (adminAction.equals("3")) {
                        System.out.println("Items ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cheeseService.removeCheese(id);
                        printCheese();
                    } else if (adminAction.equals("4")) {
                        break; // Exit admin actions loop to return to access type selection
                    } else if (adminAction.equals("5")) {
                        System.out.println("See you next time!");
                        return; // Exit the entire program
                    }
                }

            } else if (accessType.equals("2")) {
                // Customer actions loop
                while (true) {
                    System.out.println("Please choose an action:");
                    System.out.println("1 - add item to cart;");
                    System.out.println("2 - remove item from cart;");
                    System.out.println("3 - show cart;");
                    System.out.println("4 - change access type;");
                    System.out.println("5 - checkout;");
                    System.out.println("6 - register new customer.");

                    var customerAction = scanner.nextLine();

                    if (customerAction.equals("1")) {
                        addCheeseToCart();
                        showCart();
                    } else if (customerAction.equals("2")) {
                        removeCheeseToCart();
                        showCart();
                    } else if (customerAction.equals("3")) {
                        showCart();
                    } else if (customerAction.equals("4")) {
                        break; // Exit customer actions loop to return to access type selection
                    } else if (customerAction.equals("5")) {
                        System.out.println("Add your name:");
                        String name = scanner.nextLine();
                        int totalAmount = cheeseShop.checkout(name);
                        break; // Exit the customer actions loop
                    } else if (customerAction.equals("6")) {
                        addCustomer();
                    }
                }
            } else if (accessType.equals("3")) {
                break;
            }
        }
    }

    public static void addCheese() {
        System.out.println("Provide an item id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Provide an item name");
        String name = scanner.nextLine();
        System.out.println("Provide an item type");
        String type = scanner.nextLine();
        System.out.println("Provide an item location");
        String location = scanner.nextLine();
        System.out.println("Provide an item price");
        int price = scanner.nextInt();
        scanner.nextLine();
        var cheese = new Cheese(id, name, type, location, price);
        cheeseService.addCheese(cheese);
    }

    public static void updateCheese() {
        System.out.println("Provide an item id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("name");
        String name = scanner.nextLine();
        System.out.println("type");
        String type = scanner.nextLine();
        System.out.println("location");
        String location = scanner.nextLine();
        System.out.println("price");
        int price = scanner.nextInt();
        scanner.nextLine();
        cheeseService.updateCheese(id, name, type, location, price);
    }

    public static void printCheese() {
        System.out.println("These are the cheeses in the storage");
        var cheeses = cheeseService.getCheese();
        for (var cheese : cheeses) {
            System.out.println(cheese.getId() + " " + cheese.getName() + " " + cheese.getType() + " " + cheese.getLocation() + " " + cheese.getPrice());
        }
    }

    public static void showCart() {
        System.out.println("These are the cheeses in the cart");
        var cart = cheeseShop.getCart();
        for (var cheese : cart) {
            System.out.println(cheese.getId() + " " + cheese.getName() + " " + cheese.getType() + " " + cheese.getLocation() + " " + cheese.getPrice());
        }
    }

    public static void addCheeseToCart() {
        System.out.println("Provide an item name");
        String name = scanner.nextLine();
        cheeseShop.addToCart(name);
    }

    public static void removeCheeseToCart() {
        System.out.println("Provide an item name");
        String name = scanner.nextLine();
        cheeseShop.removeFromCart(name);
    }

    public static void addCustomer() {
        System.out.println("Write your name:");
        String name = scanner.nextLine();
        System.out.println("Add you balance:");
        int balance = scanner.nextInt();
        scanner.nextLine();
        var customer = new Customer(name, balance);
        customerService.addCustomer(customer);
    }
}

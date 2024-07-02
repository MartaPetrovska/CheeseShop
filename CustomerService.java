import java.util.ArrayList;


public class CustomerService{

  public static ArrayList<Customer> customers = new ArrayList<Customer>();

  public void addCustomer(Customer customer) {
    customers.add(customer);
  }
}

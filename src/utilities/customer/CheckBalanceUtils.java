package utilities.customer;

import model.Customer;
import model.Product;

import java.util.List;

public class CheckBalanceUtils {
    public static void checkBalance(List<Customer> customers, Customer customer, List<Product> products) {
        System.out.println(String.format("\nTrenutno stanje računa: %.2f\n", customer.getBalance()));
        CustomerFirstChooserUtils.customerFirstChooser(customers, customer, products);
    }
}

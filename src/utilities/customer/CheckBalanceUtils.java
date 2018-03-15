package utilities.customer;

import model.Customer;
import model.Product;

import java.util.List;

public class CheckBalanceUtils {
    public static void checkBalance(List<Customer> customers, Customer customer,  List<Product> products) {
        System.out.println("\nTrenutno na računu " + customer.getBalance() + "\n");
        CustomerFirstChooserUtils.customerFirstChooser(customers, customer, products);
    }
}

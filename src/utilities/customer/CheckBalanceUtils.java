package utilities.customer;

import model.Customer;
import utilities.Choosers;

public class CheckBalanceUtils {
    public static void checkBalance(Customer customer) {
        System.out.println("\nTrenutno na računu " + customer.getBalance() + "\n");
        CustomerFirstChooserUtils.customerFirstChooser(customer);
    }
}

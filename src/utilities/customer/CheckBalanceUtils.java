package utilities.customer;

import model.Customer;

public class CheckBalanceUtils {
    public static void checkBalance(Customer customer) {
        System.out.println(String.format("\nTrenutno stanje računa: %.2f\n", customer.getBalance()));
        CustomerFirstChooserUtils.customerFirstChooser(customer);
    }
}

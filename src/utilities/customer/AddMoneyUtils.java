package utilities.customer;

import model.Customer;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class AddMoneyUtils {
    public static void addMoney(List<Customer> customers, Customer customer, List<Product> products) {
        double availableBalance = customer.getBalance();
        Scanner scanner = new Scanner(System.in);
        double inputvalue;

        System.out.println("Unesi iznos koji uplaćuješ: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputvalue = scanner.nextDouble();

        customer.setBalance(inputvalue + availableBalance);
        System.out.println("\nUplaćeno: " + inputvalue + "\nUkupno stanje računa: " + customer.getBalance() + "\n");
        CustomerFirstChooserUtils.customerFirstChooser(customers, customer, products);
    }
}

package utilities.customer;

import model.Customer;

import java.util.Scanner;

public class AddMoneyUtils {
    public static void addMoney(Customer customer) {
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
        CustomerFirstChooserUtils.customerFirstChooser(customer);
    }
}

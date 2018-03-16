package utilities.customer;

import model.Customer;

import java.util.Scanner;

public class AddMoneyUtils {
    public static void addMoney(Customer customer) {

        double availableBalance = customer.getBalance();
        Scanner scanner = new Scanner(System.in);
        double inputValue;

        System.out.println("Unesi iznos koji uplaćuješ: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputValue = scanner.nextDouble();

        customer.setBalance(inputValue + availableBalance);
        System.out.println(String.format("\nUplaćeno: %.2f \nUkupno stanje računa: %.2f \n", inputValue, customer.getBalance()));
        CustomerFirstChooserUtils.customerFirstChooser(customer);
    }
}

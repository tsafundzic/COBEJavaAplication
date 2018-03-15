package utilities.customer;

import model.Customer;
import model.Product;

import java.util.List;
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
        System.out.println(String.format("\nUplaćeno: %.2f \nUkupno stanje računa: %.2f \n", inputvalue, customer.getBalance()));
        CustomerFirstChooserUtils.customerFirstChooser();
    }
}

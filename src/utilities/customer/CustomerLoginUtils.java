package utilities.customer;

import data.DataHolder;
import model.Customer;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;
import java.util.Scanner;


public class CustomerLoginUtils {

    public static void customerLogin() {
        int inputValue;
        int numberOfTry = 0;
        String inputData;
        List<Customer> customers = DataHolder.getInstance().getCustomers();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesi svoj ID:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }

        inputValue = scanner.nextInt();
        while (inputValue > customers.size()) {
            if (numberOfTry == 4) {
                System.out.println("Pogrešan unos puno puta\n");
                ShowHomeScreenUtils.showHomeScreen();
            }
            numberOfTry++;
            System.out.println("Pogrešan ID");
            inputValue = scanner.nextInt();
        }

        for (Customer customer : customers) {
            if (inputValue == customer.getId()) {
                System.out.println("Unesi lozinku: ");
                inputData = scanner.next();
                if (inputData.equals(customer.getPassword())) {
                    System.out.println("Uspješno logiranje!\n");
                    CustomerFirstChooserUtils.customerFirstChooser(customer);
                } else {
                    System.out.println("Pogrešna lozinka");
                    ShowHomeScreenUtils.showHomeScreen();
                }
            }
        }
    }
}

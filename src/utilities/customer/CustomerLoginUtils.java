package utilities.customer;

import model.Customer;
import model.Product;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;
import java.util.Scanner;


public class CustomerLoginUtils {
    public static Customer customerLogin(List<Customer> customers, List<Product> products) {
        String inputdata;
        int inputvalue;
        int numOfTry = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner scannerPass = new Scanner(System.in);
        //todo logedCustomer!!!
        Customer logedCustomer = customers.get(0);

        System.out.println("Unesi svoj ID:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }

        inputvalue = scanner.nextInt();
        while (inputvalue > customers.size()) {
            if (numOfTry == 4) {
                System.out.println("Pogrešan unos puno puta\n");
                ShowHomeScreenUtils.showHomeScreen();
            }
            numOfTry++;
            System.out.println("Pogrešan ID");
            inputvalue = scanner.nextInt();
        }

        for (Customer customer : customers) {
            if (inputvalue == customer.getId()) {
                System.out.println("Unesi lozinku: ");
                inputdata = scannerPass.nextLine();
                if (inputdata.equals(customer.getPassword())) {
                    System.out.println("Uspješno logiranje!\n");
                    CustomerFirstChooserUtils.customerFirstChooser(customers, customer, products);
                } else {
                    System.out.println("Pogrešna lozinka");
                    ShowHomeScreenUtils.showHomeScreen();
                }
            }
            logedCustomer = customer;
        }
        return logedCustomer;
    }
}

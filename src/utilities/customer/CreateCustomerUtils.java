package utilities.customer;

import data.DataHolder;
import model.Customer;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;
import java.util.Scanner;


public class CreateCustomerUtils {

    public static Customer createNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        String inputName;
        String inputSurname;
        String inputPassword;

        int customerID = DataHolder.getInstance().getCustomers().size() + 1;
        System.out.println("ID novog korisnika: " + customerID);

        System.out.println("Unesi ime: ");
        inputName = scanner.nextLine();

        System.out.println("Unesi prezime");
        inputSurname = scanner.nextLine();

        System.out.println("Unesi lozinku:");
        inputPassword = scanner.nextLine();

        Customer customer = new Customer(customerID, inputName, inputSurname, inputPassword, 0);

        System.out.println(String.format("Dodan je novi korisnik: \n\tID: %d \n\tIme: %s \n\tPrezime: %s \n\tLozinka: %s \n\tStanje računa: %.2f\n", customer.getId(), customer.getName(), customer.getSurname(), customer.getPassword(), customer.getBalance()));
        ShowHomeScreenUtils.showHomeScreen();

        return customer;
    }
}

package utilities.customer;

import model.Customer;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;
import java.util.Scanner;


public class CreateCustomerUtils {
    public static void createNewCustomer(List<Customer> customers) {
        Scanner scanner = new Scanner(System.in);
        String inputName;
        String inputSurname;
        String inputPassword;

        int customerID = customers.size() + 1;
        System.out.println("ID novog korisnika: " + customerID);

        System.out.println("Unesi ime: ");
        inputName = scanner.nextLine();

        System.out.println("Unesi prezime");
        inputSurname = scanner.nextLine();

        System.out.println("Unesi lozinku:");
        inputPassword = scanner.nextLine();

        Customer customer = new Customer(customerID, inputName, inputSurname, inputPassword, 0);
        customers.add(customer);

        System.out.println("Dodan novi korisnik: \n\tID:" + customer.getId() + "\n\tIme: " + customer.getName() + "\n\tPrezime: " + customer.getSurname() + "\n\tLozinka: " + customer.getPassword() + "\n\tStanje računa : " + customer.getBalance());
        ShowHomeScreenUtils.showHomeScreen();
    }


}

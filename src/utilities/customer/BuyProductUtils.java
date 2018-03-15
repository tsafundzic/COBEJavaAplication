package utilities.customer;

import model.Customer;
import model.Product;

import java.util.Scanner;


public class BuyProductUtils {
    public static void buyProduct(Product product, Customer customer) {
        Scanner scanner = new Scanner(System.in);
        int inputvalue;

        System.out.println("Unesi količinu proizvoda:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputvalue = scanner.nextInt();

        double customerBalance = customer.getBalance();
        double productPrice = product.getProductPrice() * inputvalue;
        double newBalance = customerBalance - productPrice;

        if (newBalance >= 0) {
            customer.setBalance(newBalance);
            System.out.println(product.getProductName() + " " + product.getProductID() + customer.getName());
            System.out.println(" \nKupnja uspješno obavljena! \n \t" + product.getProductName() + " \t" + product.getProductPrice() + "\t" + inputvalue + "\t" + productPrice + "\n\tNovo stanje na računu: " + customer.getBalance() + " \n");
            CustomerFirstChooserUtils.customerFirstChooser(customer);
        } else {
            System.out.println("Nedovoljno sredstava na računu!\n");
            CustomerFirstChooserUtils.customerFirstChooser(customer);
        }
    }
}

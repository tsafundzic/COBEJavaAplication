package utilities.customer;

import model.Customer;
import model.Product;
import model.ProductAmount;
import utilities.PrintUtils;
import utilities.menu.MenuSelectorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyProductUtils {

    static List<ProductAmount> productAmounts = new ArrayList<>();

    public static void buyProduct(Product product, Customer customer) {
        Scanner scanner = new Scanner(System.in);
        double bill = 0;

        System.out.println("Unesi količinu proizvoda:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        int inputAmount = scanner.nextInt();

        double customerBalance = customer.getBalance();

        productAmounts.add(new ProductAmount(product.getProductID(), product.getProductName(), product.getProductPrice(), inputAmount));

        System.out.println("Odaberi: \n 1. Nastavi kupnju \n 2. Završi kupnju");
        int inputValue = MenuSelectorUtils.menuSelector(2);

        if (inputValue == 1) {
            PrintUtils.showAvailableProducts(customer);
        } else if (inputValue == 2) {
            customer.setBalance(customerBalance);
            for (ProductAmount productAmount : productAmounts) {
                System.out.println(String.format("%s \t %d \t %.2f", productAmount.getProductName(), productAmount.getAmount(), productAmount.getAmount() * productAmount.getProductPrice()));
                double productPrice = productAmount.getProductPrice() * productAmount.getAmount();
                customerBalance = customerBalance - productPrice;
                bill += productPrice;
            }
            if (customerBalance >= 0) {
                System.out.println(String.format("Ukupno %.2f \nNovo stanje: %.2f", bill, customerBalance));
                customer.setBalance(customerBalance);
                productAmounts.clear();
                CustomerFirstChooserUtils.customerFirstChooser(customer);
            } else {
                System.out.println("Nedovoljno sredstava na računu!\n");
                productAmounts.clear();
                CustomerFirstChooserUtils.customerFirstChooser(customer);
            }
        }
    }
}

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

    public static void buyProduct(Product product, Customer customer, List<Customer> customers, List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        int inputAmount;
        int inputValue;

        System.out.println("Unesi količinu proizvoda:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputAmount = scanner.nextInt();

        double customerBalance = customer.getBalance();

        productAmounts.add(new ProductAmount(product.getProductID(), product.getProductName(), product.getProductPrice(), inputAmount));

        System.out.println("Odaberi: \n 1. Nastavi kupnju \n 2. Završi kupnju");
        inputValue = MenuSelectorUtils.menuSelector(2);

        if (inputValue == 1) {
            PrintUtils.showAvailableProducts(customers, products, customer);
        } else if (inputValue == 2) {
            customer.setBalance(customerBalance);
            for (ProductAmount productAmount : productAmounts) {
                System.out.println(productAmount.getProductName() + "\t" + productAmount.getAmount() + "\t" + productAmount.getAmount() * productAmount.getProductPrice());
                double productPrice = productAmount.getProductPrice() * productAmount.getAmount();
                customerBalance = customerBalance - productPrice;
            }
            if (customerBalance >= 0) {
                System.out.println("Novo stanje: " + customerBalance);
                customer.setBalance(customerBalance);
                productAmounts.clear();
                CustomerFirstChooserUtils.customerFirstChooser(customers, customer, products);
            } else {
                System.out.println("Nedovoljno sredstava na računu!\n");
                CustomerFirstChooserUtils.customerFirstChooser(customers, customer, products);
            }
        }
    }
}

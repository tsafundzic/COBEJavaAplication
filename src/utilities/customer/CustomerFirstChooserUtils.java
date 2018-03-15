package utilities.customer;

import model.Customer;
import model.Product;
import utilities.PrintUtils;
import utilities.product.ProductUtils;
import utilities.menu.MenuSelectorUtils;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;

public class CustomerFirstChooserUtils {
    private static List<Product> products = ProductUtils.createProducts();
    private static List<Customer> customers = ProductUtils.createCustomers();

    public static void customerFirstChooser(Customer customer) {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Provjera stanja računa \n 3. Uplata na račun \n 4. Kupnja proizovda \n 5. Kreiranje novog računa");
        int inputvalue = MenuSelectorUtils.menuSelector(5);
        switch (inputvalue) {
            case 1:
                ShowHomeScreenUtils.showHomeScreen();
                break;
            case 2:
                CheckBalanceUtils.checkBalance(customer);
                break;
            case 3:
                AddMoneyUtils.addMoney(customer);
                break;
            case 4:
                PrintUtils.showAvailableProducts(products, customer);
                break;
            case 5:
                CreateCustomerUtils.createNewCustomer(customers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }
}

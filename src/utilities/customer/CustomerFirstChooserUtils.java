package utilities.customer;

import model.Customer;
import model.Product;
import utilities.PrintUtils;
import utilities.product.ProductUtils;
import utilities.menu.MenuSelectorUtils;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;

public class CustomerFirstChooserUtils {

    public static void customerFirstChooser(List<Customer> customers, Customer customer, List<Product> products) {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Provjera stanja računa \n 3. Uplata na račun \n 4. Kupnja proizovda \n 5. Kreiranje novog računa");
        int inputvalue = MenuSelectorUtils.menuSelector(5);
        switch (inputvalue) {
            case 1:
                ShowHomeScreenUtils.showHomeScreen();
                break;
            case 2:
                CheckBalanceUtils.checkBalance(customers, customer, products);
                break;
            case 3:
                AddMoneyUtils.addMoney(customers, customer, products);
                break;
            case 4:
                PrintUtils.showAvailableProducts(customers, products, customer);
                break;
            case 5:
                CreateCustomerUtils.createNewCustomer(customers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }
}

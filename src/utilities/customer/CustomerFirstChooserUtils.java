package utilities.customer;

import model.Customer;
import utilities.PrintUtils;
import utilities.menu.MenuSelectorUtils;
import utilities.menu.ShowHomeScreenUtils;

public class CustomerFirstChooserUtils {

    public static void customerFirstChooser(Customer customer) {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Provjera stanja računa \n 3. Uplata na račun \n 4. Kupnja proizovda");
        int inputValue = MenuSelectorUtils.menuSelector(4);

        switch (inputValue) {
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
                PrintUtils.showAvailableProducts(customer);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }
}

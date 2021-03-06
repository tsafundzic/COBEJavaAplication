package utilities.menu;

import data.DataHolder;
import model.Customer;
import utilities.customer.CreateCustomerUtils;
import utilities.customer.CustomerLoginUtils;
import utilities.worker.WorkerLoginUtils;

import static utilities.menu.MenuSelectorUtils.menuSelector;

public class ShowHomeScreenUtils {
    public static void showHomeScreen() {
        System.out.println("Odaberi: \n 1. Postojeći kupac \n 2. Novi kupac \n 3. Radnik");
        int value = menuSelector(3);

        switch (value) {
            case 1:
                CustomerLoginUtils.customerLogin();
                break;
            case 2:
                Customer customer = CreateCustomerUtils.createNewCustomer();
                DataHolder.getInstance().addNewCustomer(customer);
                ShowHomeScreenUtils.showHomeScreen();
                break;
            case 3:
                WorkerLoginUtils.workerLogin();
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }
}

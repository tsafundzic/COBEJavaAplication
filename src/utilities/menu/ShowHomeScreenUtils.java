package utilities.menu;

import model.Customer;
import model.Worker;
import utilities.product.ProductUtils;
import utilities.customer.CreateCustomerUtils;
import utilities.customer.CustomerLoginUtils;
import utilities.worker.WorkerLoginUtils;

import java.util.List;

import static utilities.menu.MenuSelectorUtils.menuSelector;

public class ShowHomeScreenUtils {
    private static List<Worker> workers = ProductUtils.createWorkers();
    private static List<Customer> customers = ProductUtils.createCustomers();

    public static void showHomeScreen() {
        System.out.println("Odaberi: \n 1. Postojeći kupac \n 2. Novi kupac \n 3. Radnik");
        int value = menuSelector(3);

        switch (value) {
            case 1:
                CustomerLoginUtils.customerLogin(customers);
                break;
            case 2:
                CreateCustomerUtils.createNewCustomer(customers);
                break;
            case 3:
                WorkerLoginUtils.workerLogin(workers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }
}

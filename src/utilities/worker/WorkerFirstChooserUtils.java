package utilities.worker;

import data.DataHolder;
import model.Worker;
import utilities.customer.CreateCustomerUtils;
import utilities.menu.MenuSelectorUtils;
import utilities.menu.ShowHomeScreenUtils;
import utilities.product.AddNewProductUtils;
import utilities.product.DeleteProductUtils;

public class WorkerFirstChooserUtils {

    public static void workerFirstChooser() {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Dodavanje novog proizvoda \n 3. Brisanje proizvoda \n 4. Dodavanje novog radnika");
        int inputValue = MenuSelectorUtils.menuSelector(4);
        switch (inputValue) {
            case 1:
                ShowHomeScreenUtils.showHomeScreen();
                break;
            case 2:
                DataHolder.getInstance().addProduct(AddNewProductUtils.addNewProduct());
                WorkerFirstChooserUtils.workerFirstChooser();
                break;
            case 3:
                DataHolder.getInstance().removeProduct(DeleteProductUtils.deleteProduct());
                WorkerFirstChooserUtils.workerFirstChooser();
                break;
            case 4:
                DataHolder.getInstance().addNewWorker(CreateWorkerUtils.createNewWorker());
                ShowHomeScreenUtils.showHomeScreen();
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }
}

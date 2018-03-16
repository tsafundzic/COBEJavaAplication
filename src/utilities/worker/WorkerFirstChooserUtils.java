package utilities.worker;

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
                AddNewProductUtils.addNewProduct();
                break;
            case 3:
                DeleteProductUtils.deleteProduct();
                break;
            case 4:
                CreateWorkerUtils.addNewWorker(); //todo return the new worker and add it to the data holder
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }
}

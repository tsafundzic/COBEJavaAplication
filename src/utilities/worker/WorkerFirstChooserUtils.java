package utilities.worker;

import model.Product;
import model.Worker;
import utilities.menu.MenuSelectorUtils;
import utilities.menu.ShowHomeScreenUtils;
import utilities.product.AddNewProductUtils;
import utilities.product.DeleteProductUtils;

import java.util.List;

public class WorkerFirstChooserUtils {

    public static void workerFirstChooser(List<Worker> workers, Worker worker, List<Product> products) {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Dodavanje novog proizvoda \n 3. Brisanje proizvoda \n 4. Dodavanje novog radnika");
        int inputvalue = MenuSelectorUtils.menuSelector(4);
        switch (inputvalue) {
            case 1:
                ShowHomeScreenUtils.showHomeScreen();
                break;
            case 2:
                AddNewProductUtils.addNewProduct(products, workers, worker);
                break;
            case 3:
                DeleteProductUtils.deleteProduct(products, workers, worker);
                break;
            case 4:
                CreateWorkerUtils.addNewWorker(workers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }
}

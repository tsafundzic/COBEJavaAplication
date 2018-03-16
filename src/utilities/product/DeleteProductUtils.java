package utilities.product;

import data.DataHolder;
import model.Product;
import utilities.CheckIfInputIsIntUtils;
import utilities.PrintUtils;
import utilities.worker.WorkerFirstChooserUtils;

import java.util.List;


public class DeleteProductUtils {
    public static void deleteProduct() {
        List<Product> products = DataHolder.getInstance().getProducts();
        int inputID;

        System.out.println("Odaberi ID proizvoda kojeg želiš obrisati");
        PrintUtils.showProducts();
        inputID = CheckIfInputIsIntUtils.checkIfInputisInt(products);

        Product product = products.get(inputID - 1);
        DataHolder.getInstance().removeProduct(product);
        System.out.println("Proizvod obrisan!");

        PrintUtils.showProducts();
        WorkerFirstChooserUtils.workerFirstChooser();
    }
}

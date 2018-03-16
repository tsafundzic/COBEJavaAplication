package utilities.product;

import data.DataHolder;
import model.Product;
import utilities.CheckIfInputIsIntUtils;
import utilities.PrintUtils;
import utilities.worker.WorkerFirstChooserUtils;

import java.util.List;


public class DeleteProductUtils {
    public static Product deleteProduct() {
        List<Product> products = DataHolder.getInstance().getProducts();

        System.out.println("Odaberi ID proizvoda kojeg želiš obrisati");
        PrintUtils.showProducts();

        int inputID = CheckIfInputIsIntUtils.checkIfInputisInt(products);
        Product product = products.get(inputID - 1);
        System.out.println("Proizvod obrisan!");

        PrintUtils.showProducts();
        return product;
    }
}

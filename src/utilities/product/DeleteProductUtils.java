package utilities.product;

import model.Product;
import utilities.CheckIfInputIsIntUtils;
import utilities.PrintUtils;
import utilities.worker.WorkerFirstChooserUtils;

import java.util.List;
import java.util.Scanner;


public class DeleteProductUtils {
    public static void deleteProduct(List<Product> products) {
        int inputID;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Odaberi ID proizvoda kojeg želiš obrisati");
        PrintUtils.showProducts(products);
        inputID = CheckIfInputIsIntUtils.checkIfInputisInt(products);

        Product product = products.get(inputID - 1);
        products.remove(product);
        System.out.println("Proizvod obrisan!");

        PrintUtils.showProducts(products);
        UpdateProductListUtils.updateProductsList(products);
        WorkerFirstChooserUtils.workerFirstChooser();
    }
}

package utilities.product;

import data.DataHolder;
import model.Product;
import model.Worker;
import utilities.CheckIfInputIsIntUtils;
import utilities.PrintUtils;
import utilities.worker.WorkerFirstChooserUtils;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;


public class DeleteProductUtils {
    public static void deleteProduct() {
        List<Product> products = DataHolder.getInstance().getProducts();

        int inputID;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Odaberi ID proizvoda kojeg želiš obrisati");
        PrintUtils.showProducts(products);
        inputID = CheckIfInputIsIntUtils.checkIfInputisInt(products);

        Product product = products.get(inputID - 1);
        DataHolder.getInstance().removeProduct(product);
        System.out.println("Proizvod obrisan!");

        PrintUtils.showProducts(products);
        WorkerFirstChooserUtils.workerFirstChooser();
    }
}

package utilities.product;

import data.DataHolder;
import model.Product;
import model.Worker;
import utilities.worker.WorkerFirstChooserUtils;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class AddNewProductUtils {

    public static void addNewProduct() {
        Scanner scanner = new Scanner(System.in);
        String productName;
        List<Product> products = DataHolder.getInstance().getProducts();


        double inputPrice = 0;

        int max = DataHolder.getInstance().getProducts().size();
        for (Product product1 : products) {
            if (product1.getProductID() > max) {
                max = product1.getProductID();
            }
        }

        int productID = max + 1;

        System.out.println("ID novog proizvoda " + productID);

        System.out.println("Unesi naziv novog proizvoda");
        productName = scanner.nextLine();

        System.out.println("Unesi cijenu novog proizvoda");

        while (!scanner.hasNextDouble()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }

        inputPrice = scanner.nextDouble();

        Product product = new Product(productID, productName, inputPrice);

        System.out.println(String.format("Proizvod je uspješno dodan! \n\tNaziv: %s \n\tCijena: %.2f \n", product.getProductName(), product.getProductPrice()));
        products.add(product);

        WorkerFirstChooserUtils.workerFirstChooser();
    }
}

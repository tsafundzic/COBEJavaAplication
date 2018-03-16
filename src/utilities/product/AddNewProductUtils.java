package utilities.product;

import data.DataHolder;
import model.Product;
import utilities.worker.WorkerFirstChooserUtils;

import java.util.List;
import java.util.Scanner;

public class AddNewProductUtils {

    public static Product addNewProduct() {
        Scanner scanner = new Scanner(System.in);
        String productName;
        List<Product> products = DataHolder.getInstance().getProducts();
        double inputPrice = 0;

        int lastId = DataHolder.getInstance().getProducts().size();
        for (Product product1 : products) {
            if (product1.getProductID() > lastId) {
                lastId = product1.getProductID();
            }
        }

        int productID = lastId + 1;

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

        return product;
    }
}

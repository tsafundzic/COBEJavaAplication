package utilities.product;

import model.Product;
import utilities.worker.WorkerFirstChooserUtils;

import java.util.List;
import java.util.Scanner;

public class AddNewProductUtils {
    public static void addNewProduct(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        String inputword;
        int inputvalue;
        double inputprice = 0;
        Product product = new Product();

        int max = products.size();
        for (Product product1 : products) {
            if (product1.getProductID() > max) {
                max = product1.getProductID();
            }
        }

        int productID = max + 1;

        System.out.println("ID novog proizvoda " + productID);
        product.setProductID(productID);

        System.out.println("Unesi naziv novog proizvoda");
        inputword = scanner.nextLine();
        product.setProductName(inputword);

        System.out.println("Unesi cijenu novog proizvoda");

        while (!scanner.hasNextDouble()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }

        inputprice = scanner.nextDouble();
        product.setProductPrice(inputprice);
        System.out.println("Proizvod uspješno dodan! \n\tID: " + product.getProductID() + "\n\tNaziv: " + product.getProductName() + "\n\tCijena: " + product.getProductPrice() + "\n");
        products.add(product);

        WorkerFirstChooserUtils.workerFirstChooser();
    }
}

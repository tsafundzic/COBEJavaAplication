package utilities;

import data.DataHolder;
import model.Customer;
import model.Product;
import utilities.customer.BuyProductUtils;
import utilities.menu.MenuSelectorUtils;

import java.util.List;

public class PrintUtils {

    public static void showProducts() {
        int index = 1;
        List<Product> products = DataHolder.getInstance().getProducts();

        for (Product product : products) {
            System.out.println(" " + index + ". " + product.getProductName());
            index++;
        }
    }

    public static void showAvailableProducts() {
        int index = 1;
        List<Product> products = DataHolder.getInstance().getProducts();

        for (Product product : products) {
            System.out.println(" " + index + ". " + product.getProductName() + " \t" + product.getProductPrice());
            index++;
        }

        int inputvalue = MenuSelectorUtils.menuSelector(index - 1);
        Product product = products.get(inputvalue - 1);

        BuyProductUtils.buyProduct(product, customer);
    }
}

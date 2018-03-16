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
            System.out.println(String.format(" %d. %s", index, product.getProductName()));
            index++;
        }
    }

    public static void showAvailableProducts(Customer customer) {
        int index = 1;
        List<Product> products = DataHolder.getInstance().getProducts();

        for (Product product : products) {
            System.out.println(String.format(" %d. %s \t %.2f", index, product.getProductName(), product.getProductPrice()));
            index++;
        }

        int inputValue = MenuSelectorUtils.menuSelector(index - 1);
        Product product = products.get(inputValue - 1);

        BuyProductUtils.buyProduct(product, customer);
    }
}

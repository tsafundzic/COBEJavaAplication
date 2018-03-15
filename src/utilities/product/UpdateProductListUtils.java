package utilities.product;

import model.Product;

import java.util.List;

public class UpdateProductListUtils {

    static List<Product> productList;

    public static List<Product> updateProductsList(List<Product> products){
        productList=products;
        return products;
    }

    public static List<Product> returnUpdatedProductsList(){
        return productList;
    }
}

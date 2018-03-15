package utilities;

import model.Customer;
import model.Product;
import model.ProductAmount;
import model.Worker;
import utilities.product.ProductUtils;

import java.util.ArrayList;
import java.util.List;

public class Choosers {

    private static List<Product> products = ProductUtils.createProducts();
    private static List<Worker> workers = ProductUtils.createWorkers();
    private static List<Customer> customers = ProductUtils.createCustomers();
    private static List<ProductAmount> productAmounts = new ArrayList<>();


}

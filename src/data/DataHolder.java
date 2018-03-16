package data;

import model.Customer;
import model.Product;
import model.Worker;
import utilities.product.ProductUtils;

import java.util.List;

public class DataHolder {

    //singleton istance
    private static final DataHolder instance = new DataHolder();

    private DataHolder() {
    }

    //data
    private static final List<Product> products = ProductUtils.createProducts();
    private static final List<Worker> workers = ProductUtils.createWorkers();
    private static final List<Customer> customers = ProductUtils.createCustomers();

    public static DataHolder getInstance() {
        return instance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addNewCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getProductsSize() {
        return products.size();
    }
}

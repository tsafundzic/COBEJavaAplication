package utilities;

import model.Customer;
import model.Product;
import model.Worker;

import java.util.ArrayList;
import java.util.List;

public class ProductUtilit {
    public static List<Product> createProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Hamburger", 14));
        products.add(new Product(2, "Cebab", 15));
        products.add(new Product(3, "Cheeseburger", 14));
        products.add(new Product(4, "Sendwich", 10));

        return products;
    }

    public static List<Worker> createWorkers() {
        List<Worker> workers = new ArrayList<>();

        workers.add(new Worker(1, "Dragan", "Dragic", "123"));
        workers.add(new Worker(2, "Joško", "Lokas", "123"));

        return workers;
    }

    public static List<Customer> createCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"Franjo", "Lucić", 56));
        return customers;
    }
}

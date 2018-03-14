package utilities;

import model.Customer;
import model.Product;
import model.Worker;

import java.util.List;
import java.util.Scanner;

import static model.Customer.*;
import static model.Worker.*;

public class Choosers {


    static List<Product> products = ProductUtilit.createProducts();
    static List<Worker> workers = ProductUtilit.createWorkers();
    static List<Customer> customers = ProductUtilit.createCustomers();

    private static int menuSelector(int numberOfItems) {

        Scanner scanner = new Scanner(System.in);
        int inputvalue;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Pogrešan unos!");
                scanner.next();
            }
            inputvalue = scanner.nextInt();
            if (inputvalue < 1 || inputvalue > numberOfItems) {
                System.out.println("Pogrešan unos!");
            }
        } while (inputvalue < 1 || inputvalue > numberOfItems);

        return inputvalue;
    }

    public static void homeScreen() {
        System.out.println("Odaberi: \n 1. Postojeći kupac \n 2. Novi kupac \n 3. Radnik");
        int value = menuSelector(3);
        switch (value) {
            case 1:
                customerLogin(customers);
                break;
            case 2:
                createNewCustomer(customers);
                break;
            case 3:
                workerLogin(workers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }

    public static void workerFirstChooser() {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Dodavanje novog proizvoda \n 3. Brisanje proizvoda \n 4. Dodavanje novog radnika");
        int inputvalue = menuSelector(4);
        switch (inputvalue) {
            case 1:
                homeScreen();
                break;
            case 2:
                addNewProduct(products);
                break;
            case 3:
                deleteProduct(products);
                break;
            case 4:
                addNewWorker(workers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }

    public static void customerFirstChooser(Customer customer) {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Provjera stanja računa \n 3. Uplata na račun \n 4. Kupnja proizovda \n 5. Kreiranje novog računa");
        int inputvalue = menuSelector(5);
        switch (inputvalue) {
            case 1:
                homeScreen();
                break;
            case 2:
                checkBalance(customer);
                break;
            case 3:
                addMoney(customer);
                break;
            case 4:
                showAvailableProducts(products, customer);
                break;
            case 5:
                Customer.createNewCustomer(customers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }

    public static void showAvailableProducts(List<Product> products, Customer customer) {
        int index = 1;

        for (Product product : products) {
            System.out.println(" " + index + ". " + product.getProductName() + " \t" + product.getProductPrice());
            index++;
        }

        int inputvalue = menuSelector(index - 1);

        for (Product product : products) {
            if (product.getProductID() == (inputvalue)) {
                buyProduct(product, customer);
            }
        }
    }
}

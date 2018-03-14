package utilities;

import model.Customer;
import model.Product;
import model.Worker;

import java.util.List;
import java.util.Scanner;

import static model.Customer.customerFirst;
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
        System.out.println("Odaberi: \n 1. Kupac \n 2. Radnik");
        int value = menuSelector(2);
        switch (value) {
            case 1:
                customerFirst();
                break;
            case 2:
                workerLogin(workers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }

    public static void workerFirstChooser() {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Dodavanje novog proizvoda \n 3. Brisanje proizvoda \n 4. Dodavanje novog radnika");
        int value = menuSelector(4);
        switch (value) {
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
            default:
                System.out.println("Pogrešan unos");
        }

    }
}

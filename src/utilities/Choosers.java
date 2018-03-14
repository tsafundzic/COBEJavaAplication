package utilities;

import model.Product;
import model.Worker;

import java.util.List;
import java.util.Scanner;

import static model.Worker.addNewProduct;
import static model.Worker.deleteProduct;
import static model.Worker.workerLogin;

public class Choosers {


    static List<Product> products = ProductUtilit.createProducts();
    static List<Worker> workers = ProductUtilit.createWorkers();

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
                System.out.println("jedan!");
                break;
            case 2:
                workerLogin(workers);
                break;
            default:
                System.out.println("Pogrešan unos");
        }
    }

    public static void workerFirstChooser() {
        System.out.println("Odaberi: \n 1. Povratak na početni zaslon \n 2. Dodavanje novog proizvoda \n 3. Brisanje proizvoda");
        int value = menuSelector(3);
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
            default:
                System.out.println("Pogrešan unos");
        }

    }
}

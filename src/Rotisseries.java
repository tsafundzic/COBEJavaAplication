import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Worker;
import utilities.ProductUtilit;


import static model.Worker.workerLogin;

public class Rotisseries {

    List<Product> products = ProductUtilit.createProducts();
    static List<Worker> workers = ProductUtilit.createWorkers();


    public static void main(String[] args) {

        homeScreen();

    }

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

    private static void homeScreen() {
        System.out.println("Odaberi: \n 1. Kupac \n 2. Radnik");
        int value = menuSelector(2);
        switch (value) {
            case 1:
                System.out.println("jedan!");
                break;
            case 2:
                workerLogin(workers);
        }
    }


}

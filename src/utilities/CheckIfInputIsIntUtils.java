package utilities;

import model.Product;

import java.util.List;
import java.util.Scanner;

public class CheckIfInputIsIntUtils {
    public static int checkIfInputisInt(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        int inputvalue;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Pogrešan unos!");
                scanner.next();
            }
            inputvalue = scanner.nextInt();
            if (inputvalue < 1 || inputvalue > products.size()) {
                System.out.println("Pogrešan unos!");
            }
        } while (inputvalue < 1 || inputvalue > products.size());
        return inputvalue;
    }
}

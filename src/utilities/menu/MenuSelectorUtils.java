package utilities.menu;

import java.util.Scanner;


public class MenuSelectorUtils {

    public static int menuSelector(int numberOfItems) {
        Scanner scanner = new Scanner(System.in);
        int inputValue;
        int numberOfTry = 0;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Pogrešan unos!");
                scanner.next();
            }
            inputValue = scanner.nextInt();
            if (inputValue < 1 || inputValue > numberOfItems) {
                if (numberOfTry == 4) {
                    System.out.println("Pogrešan unos puno puta!\n");
                    ShowHomeScreenUtils.showHomeScreen();
                }
                numberOfTry++;
                System.out.println("Pogrešan unos!");
            }

        } while (inputValue < 1 || inputValue > numberOfItems);

        return inputValue;
    }
}

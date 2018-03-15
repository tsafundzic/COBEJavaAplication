package utilities.menu;

import java.util.Scanner;


public class MenuSelectorUtils {

    public static int menuSelector(int numberOfItems) {

        Scanner scanner = new Scanner(System.in);
        int inputvalue; //todo sve prodji sunce ti jebem
        int numOfTry = 0;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Pogrešan unos!");
                scanner.next();
            }
            inputvalue = scanner.nextInt();
            if (inputvalue < 1 || inputvalue > numberOfItems) {
                if (numOfTry == 4) {
                    System.out.println("Pogrešan unos puno puta!\n");
                    ShowHomeScreenUtils.showHomeScreen();
                }
                numOfTry++;
                System.out.println("Pogrešan unos!");
            }

        } while (inputvalue < 1 || inputvalue > numberOfItems);

        return inputvalue;
    }
}

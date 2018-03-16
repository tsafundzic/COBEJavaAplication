package utilities.worker;

import data.DataHolder;
import model.Worker;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;
import java.util.Scanner;

public class WorkerLoginUtils {

    public static void workerLogin() {
        List<Worker> workers = DataHolder.getInstance().getWorkers();
        String inputData;
        int inputValue;
        int numberOfTry = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesi svoj ID:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }

        inputValue = scanner.nextInt();

        while (inputValue > workers.size()) {
            if (numberOfTry == 4) {
                System.out.println("Pogrešan unos puno puta\n");
                ShowHomeScreenUtils.showHomeScreen();
            }

            numberOfTry++;
            System.out.println("Pogrešan ID");
            inputValue = scanner.nextInt();
        }

        for (Worker worker : workers) {
            if (inputValue == worker.getId()) {
                System.out.println("Unesi lozinku: ");
                inputData = scanner.next();
                if (inputData.equals(worker.getPassword())) {
                    System.out.println("Uspješno logiranje!\n");
                    WorkerFirstChooserUtils.workerFirstChooser();
                } else {
                    System.out.println("Pogrešna lozinka");
                    ShowHomeScreenUtils.showHomeScreen();
                }
            }
        }
    }
}

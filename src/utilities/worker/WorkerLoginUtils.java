package utilities.worker;

import model.Worker;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;
import java.util.Scanner;

public class WorkerLoginUtils {
    public static void workerLogin(List<Worker> workers) {
        String inputdata;
        int inputvalue;
        int numOfTry = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner scannerPass = new Scanner(System.in);

        System.out.println("Unesi svoj ID:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputvalue = scanner.nextInt();
        while (inputvalue > workers.size()) {
            if (numOfTry == 4) {
                System.out.println("Pogrešan unos puno puta\n");
                ShowHomeScreenUtils.showHomeScreen();
            }
            numOfTry++;
            System.out.println("Pogrešan ID");
            inputvalue = scanner.nextInt();
        }

        for (Worker worker : workers) {
            if (inputvalue == worker.getId()) {
                System.out.println("Unesi lozinku: ");
                inputdata = scannerPass.nextLine();
                if (inputdata.equals(worker.getPassword())) {
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

package utilities.worker;

import data.DataHolder;
import model.Worker;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;
import java.util.Scanner;


public class CreateWorkerUtils {

    public static void addNewWorker() {
        List<Worker> workers = DataHolder.getInstance().getWorkers();
        Scanner scanner = new Scanner(System.in);
        String inputName;
        String inputSurname;
        String inputPassword;
        double inputSalary;

        int workerID = workers.size() + 1;
        System.out.println("ID novog radnika: " + workerID);

        System.out.println("Unesi ime: ");
        inputName = scanner.nextLine();

        System.out.println("Unesi prezime");
        inputSurname = scanner.nextLine();

        System.out.println("Unesi lozinku:");
        inputPassword = scanner.nextLine();

        System.out.println("Unesi plaću:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputSalary = scanner.nextDouble();

        Worker worker = new Worker(workerID, inputName, inputSurname, inputPassword, inputSalary);
        workers.add(worker);

        System.out.println(String.format("Dodan je novi radnik: \n\tID: %d \n\tIme: %s \n\tPrezime: %s \n\tLozinka: %s \n\tPlaća: %.2f", worker.getId(), worker.getName(), worker.getSurname(), worker.getPassword(), worker.getSalary()));
        ShowHomeScreenUtils.showHomeScreen();
    }
}

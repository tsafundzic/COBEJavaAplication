package utilities.worker;

import model.Worker;
import utilities.menu.ShowHomeScreenUtils;

import java.util.List;
import java.util.Scanner;


public class CreateWorkerUtils {

    public static void addNewWorker(List<Worker> workers) {
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
        inputSalary = scanner.nextDouble();

        Worker worker = new Worker(workerID, inputName, inputSurname, inputPassword, inputSalary);
        workers.add(worker);

        System.out.println("Dodan novi radnik: \n\tID:" + worker.getId() + "\n\tIme: " + worker.getName() + "\n\tPrezime: " + worker.getSurname() + "\n\tLozinka: " + worker.getPassword() + "\n");
        ShowHomeScreenUtils.showHomeScreen();
    }
}

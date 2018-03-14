package model;

import utilities.Choosers;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static utilities.Choosers.homeScreen;
import static utilities.Choosers.workerFirstChooser;

public class Worker extends Person {
    private double salary;

    public Worker(int id, String name, String surname, String password, double salary) {
        super(id, name, surname, password);
        this.salary = salary;
    }

    public Worker() {

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

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

    public static void deleteProduct(List<Product> products) {
        int inputID;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Odaberi ID proizvoda kojeg želiš obrisati");
        Product.showProducts(products);
        inputID = checkIfInputisInt(products);

        for (Product product : products) {
            if (inputID == product.getProductID()) {
                products.remove(product);
                System.out.println("Proizvod obrisan!");
            }
        }
        Product.showProducts(products);
        workerFirstChooser();
    }

    public static void addNewProduct(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        String inputword;
        int inputvalue;
        double inputprice = 0;
        Product product = new Product();

        int productID = products.size() + 1;
        System.out.println("ID novog proizvoda " + productID);
        product.setProductID(productID);

        System.out.println("Unesi naziv novog proizvoda");
        inputword = scanner.nextLine();
        product.setProductName(inputword);

        System.out.println("Unesi cijenu novog proizvoda");

        while (!scanner.hasNextDouble()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputprice = scanner.nextDouble();
        product.setProductPrice(inputprice);
        System.out.println("Proizvod uspješno dodan! \n\tID: " + product.getProductID() + "\n\tNaziv: " + product.getProductName() + "\n\tCijena: " + product.getProductPrice() + "\n");
        products.add(product);

        workerFirstChooser();
    }

    public static void addNewWorker(List<Worker> workers) {
        Scanner scanner = new Scanner(System.in);
        String inputword;
        Worker worker = new Worker();

        int workerID = workers.size() + 1;
        System.out.println("ID novog radnika: " + workerID);
        worker.setId(workerID);

        System.out.println("Unesi ime: ");
        inputword = scanner.nextLine();
        worker.setName(inputword);

        System.out.println("Unesi prezime");
        inputword = scanner.nextLine();
        worker.setSurname(inputword);

        System.out.println("Unesi lozinku:");
        inputword = scanner.nextLine();
        worker.setPassword(inputword);

        workers.add(worker);
        System.out.println("Dodan novi radnik: \n\tID:" + worker.getId() + "\n\tIme: " + worker.getName() + "\n\tPrezime: " + worker.getSurname() + "\n\tLozinka: " + worker.getPassword());
        homeScreen();
    }

    public static void workerLogin(List<Worker> workers) {
        String inputdata;
        int inputvalue;
        Scanner scanner = new Scanner(System.in);
        Scanner scannerPass = new Scanner(System.in);

        System.out.println("Unesi svoj ID:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputvalue = scanner.nextInt();
        while (inputvalue > workers.size()) {
            System.out.println("Pogrešan ID");
            inputvalue = scanner.nextInt();
        }

        for (Worker worker : workers) {
            if (inputvalue == worker.getId()) {
                System.out.println("Unesi lozinku: ");
                inputdata = scannerPass.nextLine();
                if (inputdata.equals(worker.getPassword())) {
                    System.out.println("Uspješno logiranje!");
                    workerFirstChooser();
                } else {
                    System.out.println("Pogrešna lozinka");

                    Choosers.homeScreen();
                }
            }
        }
    }


}

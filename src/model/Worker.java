package model;

import utilities.Choosers;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static utilities.Choosers.workerFirstChooser;

public class Worker extends Person {
    private String password;

    public Worker(int id, String name, String surname, String password) {
        super(id, name, surname);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        String inputID;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Odaberi ID proizvoda kojeg želiš obrisati");
        //printProducts(products);
        inputID = scanner.nextLine();

        for (Iterator<Product> iterator = products.listIterator(); iterator.hasNext(); ) {
            Product product = iterator.next();
            if (inputID.equals(product.getProductID())) {
                iterator.remove();
            }
        }
        System.out.println("Prozivod obrisan!");
        //printProducts(products);
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
            System.out.println("Pogrešan id");
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

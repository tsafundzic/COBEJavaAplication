package model;

import utilities.Choosers;

import java.util.List;
import java.util.Scanner;

import static utilities.Choosers.customerFirstChooser;
import static utilities.Choosers.homeScreen;

public class Customer extends Person {
    private double balance;

    public Customer(int id, String name, String surname, String password, double balance) {
        super(id, name, surname, password);
        this.balance = balance;
    }

    public Customer() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static Customer customerLogin(List<Customer> customers) {
        String inputdata;
        int inputvalue;
        Scanner scanner = new Scanner(System.in);
        Scanner scannerPass = new Scanner(System.in);
        Customer logedCustomer = new Customer();

        System.out.println("Unesi svoj ID:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }

        inputvalue = scanner.nextInt();
        while (inputvalue > customers.size()) {
            System.out.println("Pogrešan ID");
            inputvalue = scanner.nextInt();
        }

        for (Customer customer : customers) {
            if (inputvalue == customer.getId()) {
                System.out.println("Unesi lozinku: ");
                inputdata = scannerPass.nextLine();
                if (inputdata.equals(customer.getPassword())) {
                    System.out.println("Uspješno logiranje!");
                    customerFirstChooser(customer);
                } else {
                    System.out.println("Pogrešna lozinka");
                    Choosers.homeScreen();
                }
            }
            logedCustomer = customer;
        }
        return logedCustomer;
    }

    public static void checkBalance(Customer customer) {
        System.out.println("\nTrenutno na računu " + customer.getBalance() + "\n");
        Choosers.customerFirstChooser(customer);
    }

    public static void addMoney(Customer customer) {
        double availableBalance = customer.getBalance();
        Scanner scanner = new Scanner(System.in);
        double inputvalue;

        System.out.println("Unesi iznos koji uplaćuješ: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputvalue = scanner.nextDouble();

        customer.setBalance(inputvalue + availableBalance);
        System.out.println("\nUplaćeno: " + inputvalue + "\nUkupno stanje računa: " + customer.getBalance() + "\n");
        customerFirstChooser(customer);
    }

    public static void createNewCustomer(List<Customer> customers) {
        Scanner scanner = new Scanner(System.in);
        String inputword;
        Customer customer = new Customer();

        int customerID = customers.size() + 1;
        System.out.println("ID novog korisnika: " + customerID);
        customer.setId(customerID);

        System.out.println("Unesi ime: ");
        inputword = scanner.nextLine();
        customer.setName(inputword);

        System.out.println("Unesi prezime");
        inputword = scanner.nextLine();
        customer.setSurname(inputword);

        System.out.println("Unesi lozinku:");
        inputword = scanner.nextLine();
        customer.setPassword(inputword);

        customer.setBalance(0);

        customers.add(customer);
        System.out.println("Dodan novi korisnik: \n\tID:" + customer.getId() + "\n\tIme: " + customer.getName() + "\n\tPrezime: " + customer.getSurname() + "\n\tLozinka: " + customer.getPassword() + "\n\tStanje računa : " + customer.getBalance());
        homeScreen();
    }

    public static void buyProduct(Product product, Customer customer) {
        Scanner scanner = new Scanner(System.in);
        int inputvalue;

        System.out.println("Unesi količinu proizvoda:");

        while (!scanner.hasNextInt()) {
            System.out.println("Pogrešan unos!");
            scanner.next();
        }
        inputvalue = scanner.nextInt();

        double customerBalance = customer.getBalance();
        double productPrice = product.getProductPrice() * inputvalue;
        double newBalance = customerBalance - productPrice;

        if (newBalance > 0) {
            customer.setBalance(newBalance);
            System.out.println(product.getProductName() + " " + product.getProductID() + customer.getName());
            System.out.println(" \nKupnja uspješno obavljena! \n \t" + product.getProductName() + " \t" + product.getProductPrice() + "\t" + inputvalue + "\t" + productPrice + "\n\tNovo stanje na računu: " + customer.getBalance() + " \n");
            customerFirstChooser(customer);
        } else {
            System.out.println("Nedovoljno sredstava na računu!\n");
            customerFirstChooser(customer);
        }
    }

}

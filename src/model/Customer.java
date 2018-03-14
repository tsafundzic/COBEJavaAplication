package model;

public class Customer extends Person {
    private double balance;

    public Customer(int id, String name, String surname, double balance) {
        super(id, name, surname);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void customerFirst(){

    }
}

package model;

public class Customer extends Person {
    private double balance;

    public Customer(int id, String name, String surname, String password, double balance) {
        super(id, name, surname, password);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("ID: %d \n\tIme: %s \n\tPrezime: %s \n\tLozinka: %s \n\tStanje računa: %.2f", id, name, surname, password, balance);
    }
}

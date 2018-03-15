package model;

public class Worker extends Person {
    private double salary;

    public Worker(int id, String name, String surname, String password, double salary) {
        super(id, name, surname, password);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

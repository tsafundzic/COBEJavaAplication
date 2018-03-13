package model;

public class ProductAmount extends Product {
    private int amount;

    public ProductAmount(int productID, String productName, double productPrice, int amount) {
        super(productID, productName, productPrice);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

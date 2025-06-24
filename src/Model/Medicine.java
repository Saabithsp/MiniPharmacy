package Model;

import java.time.LocalDate;

public class Medicine {
    private String id;
    private String name;
    private int quantity;
    private double price;
    private LocalDate expiryDate;

    public Medicine(String id, String name, int quantity, double price, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    // Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Setters
    
    public void setName(String name) {
        this.name = name;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // Additional helpful method
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format(
            "Medicine ID: %s\nName: %s\nQuantity: %d\nPrice: LKR %.2f\nExpiry Date: %s\n",
            id, name, quantity, price, expiryDate.toString()
        );
    }

}

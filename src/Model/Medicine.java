package Model;

import java.time.LocalDate;
import java.util.Objects;

public final class Medicine {
    private String id;
    private String name;
    private int quantity;
    private double price;
    private LocalDate expiryDate;

    public Medicine(String id, String name, int quantity, double price, LocalDate expiryDate) {
        if (id == null || name == null || expiryDate == null) {
            throw new IllegalArgumentException("ID, name, and expiry date cannot be null.");
        }
        if (quantity < 0 || price < 0) {
            throw new IllegalArgumentException("Quantity and price must be non-negative.");
        }

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
        if (expiryDate == null || expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date must be in the future.");
        }
        this.expiryDate = expiryDate;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format(
            "Medicine ID: %s\nName: %s\nQuantity: %d\nPrice: LKR %.2f\nExpiry Date: %s\n",
            id, name, quantity, price, expiryDate
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;
        Medicine medicine = (Medicine) o;
        return id.equals(medicine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

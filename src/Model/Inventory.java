package Model;

import Observer.InventoryObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private HashMap<String, Medicine> medicines;
    private List<InventoryObserver> observers;

    public Inventory() {
        medicines = new HashMap<>();
        observers = new ArrayList<>();
    }

    // Add observer
    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    // Notifying observers
    private void notifyObservers(String message) {
        for (InventoryObserver observer : observers) {
            observer.onInventoryChanged(message);
        }
    }
    
    // Getting medicine by ID
    public Medicine getMedicine(String id) {
        return medicines.get(id);
    }
    

    // Adding a new medicine or update existing one
    public void addMedicine(Medicine medicine) {
        medicines.put(medicine.getId(), medicine);
        notifyObservers("Added: " + medicine.getName());
    }

    // Removing medicine by ID
    public boolean removeMedicine(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Medicine ID cannot be null");
        }

        Medicine removed = medicines.remove(id);
        if (removed != null) {
            notifyObservers("Removed: " + removed.getName());
            return true;
        }
        return false;
    }

    
 // Update medicine name
    public boolean updateName(String id, String newName) {
        Medicine med = medicines.get(id);
        if (med != null) {
            med.setName(newName);
            notifyObservers("Updated name for: " + med.getId() + " to " + newName);
            return true;
        }
        return false;
    }

    // Update medicine quantity
    public boolean updateQuantity(String id, int newQuantity) {
        Medicine med = medicines.get(id);
        if (med != null) {
            med.setQuantity(newQuantity);
            notifyObservers("Updated quantity for: " + med.getName() + " to " + newQuantity);
            return true;
        }
        return false;
    }

    // Update medicine price
    public boolean updatePrice(String id, double newPrice) {
        Medicine med = medicines.get(id);
        if (med != null) {
            med.setPrice(newPrice);
            notifyObservers("Updated price for: " + med.getName() + " to LKR " + String.format("%.2f", newPrice));
            return true;
        }
        return false;
    }

    // Update medicine expiry date
    public boolean updateExpiryDate(String id, LocalDate newDate) {
        Medicine med = medicines.get(id);
        if (med != null) {
            med.setExpiryDate(newDate);
            notifyObservers("Updated expiry date for: " + med.getName() + " to " + newDate);
            return true;
        }
        return false;
    }

    // Listing all medicines 
    public void listMedicines() {
        if (medicines.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Medicine med : medicines.values()) {
                System.out.println(med);
            }
        }
    }

    // Returning all medicines
    public Collection<Medicine> getAllMedicines() {
        return medicines.values();
    }
}

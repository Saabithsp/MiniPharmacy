package Model;

import Observer.InventoryObserver;

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

    // Adding a new medicine or update existing one
    public void addMedicine(Medicine medicine) {
        medicines.put(medicine.getId(), medicine);
        notifyObservers("Added: " + medicine.getName());
    }

    // Removing medicine by ID
    public boolean removeMedicine(String id) {
        Medicine removed = medicines.remove(id);
        if (removed != null) {
            notifyObservers("Removed: " + removed.getName());
            return true;
        }
        return false;
    }

    // Getting medicine by ID
    public Medicine getMedicine(String id) {
        return medicines.get(id);
    }

    // Updating quantity for a medicine
    public boolean updateQuantity(String id, int newQuantity) {
        Medicine med = medicines.get(id);
        if (med != null) {
            med.setQuantity(newQuantity);
            notifyObservers("Updated quantity for: " + med.getName() + " to " + newQuantity);
            return true;
        }
        return false;
    }

    // Listing all medicines (for direct console output)
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

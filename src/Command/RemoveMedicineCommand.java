package Command;

import Model.Inventory;
import Model.Medicine;
import java.util.Scanner;

public class RemoveMedicineCommand implements Command {
    private Inventory inventory;
    private Scanner scanner;

    public RemoveMedicineCommand(Inventory inventory, Scanner scanner) {
        this.inventory = inventory;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        String id = promptMedicineId();
        Medicine med = inventory.getMedicine(id);
        boolean removed = false;
        if (med != null) {
            removed = removeMedicineById(id);
        }
        printResult(id, med, removed);
    }

    private String promptMedicineId() {
        System.out.print("Enter the Medicine ID to remove: ");
        return scanner.nextLine().trim();
    }

    private boolean removeMedicineById(String id) {
        if (id.isEmpty()) {
            System.out.println("Invalid ID entered. Please try again.");
            return false;
        }
        return inventory.removeMedicine(id);
    }

    private void printResult(String id, Medicine med, boolean removed) {
        if (removed) {
            System.out.println("\nMedicine with ID " + id + " '" + med.getName() + "' removed successfully.");
        } else {
            if (med == null) {
                System.out.println("\nMedicine with ID " + id + " not found.");
            } else {
                System.out.println("\nFailed to remove medicine with ID " + id + " (" + med.getName() + ").");
            }
        }
    }
}

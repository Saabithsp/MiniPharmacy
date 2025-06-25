package Command;

import Model.Inventory;
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
        System.out.print("Enter the Medicine ID to remove: ");
        String id = scanner.nextLine();

        boolean removed = inventory.removeMedicine(id);
        if (removed) {
            System.out.println("Medicine with ID " + id + " removed successfully.");
        } else {
            System.out.println("Medicine with ID " + id + " not found.");
        }
    }
}

package Command;

import Model.Inventory;
import java.util.Scanner;

public class RemoveMedicineCommand implements Command {
    private Inventory inventory;

    public RemoveMedicineCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
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

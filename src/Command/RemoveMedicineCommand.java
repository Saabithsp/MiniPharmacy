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
        String name = scanner.nextLine();
        inventory.removeMedicine(name);
    }
}

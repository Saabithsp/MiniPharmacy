package Command.Functional;

import Command.Command;
import Model.Inventory;
import Model.Medicine;

import java.util.List;
import java.util.stream.Collectors;

public class ShowLowStockCommand implements Command {
    private Inventory inventory;

    public ShowLowStockCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        List<Medicine> lowStockMeds = inventory.getAllMedicines().stream()
                .filter(med -> med.getQuantity() < 5)
                .collect(Collectors.toList());

        if (lowStockMeds.isEmpty()) {
            System.out.println("No medicines are currently low in stock.");
        } else {
            System.out.println("\n******************************* Low Stock Medicines (Less than 5 units) *******************************\n");
            lowStockMeds.forEach(med -> System.out.printf("ID: %s | Name: %s | Qty: %d | Exp: %s%n",
                    med.getId(), med.getName(), med.getQuantity(), med.getExpiryDate()));
        }
        System.out.println();
    }
}

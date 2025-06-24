package Command.Functional;

import Command.Command;
import Model.Inventory;
import Model.Medicine;

public class ShowLowStockCommand implements Command {
    private Inventory inventory;

    public ShowLowStockCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        boolean found = false;
        for (Medicine med : inventory.getAllMedicines()) {
            if (med.getQuantity() < 5) {
            	System.out.println("\n=== Low Stock Medicines (Less than 5 units) ===");
                System.out.println(med.getName() + " | Qty: " + med.getQuantity()+ "| Exp: "+med.getExpiryDate());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No medicines are currently low in stock.");
        }
        System.out.println();
    }
}

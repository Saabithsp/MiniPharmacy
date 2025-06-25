package Command;

import Model.Inventory;

public class ViewMedicineCommand implements Command {
    private Inventory inventory;

    public ViewMedicineCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    public void execute() {
        System.out.println("\n******************************* Inventory Items *******************************\n");
        if (inventory.getAllMedicines().isEmpty()) {
            System.out.println("No medicines available in inventory.\n");
        } else {
        	inventory.getAllMedicines().forEach(med -> 
            System.out.printf("ID: %s | Name: %s | Qty: %d | Price: %.2f | Expiry: %s%n",
                med.getId(), med.getName(), med.getQuantity(), med.getPrice(), med.getExpiryDate()));
        }
        System.out.println("\n**********************************************************************************");
    }
}

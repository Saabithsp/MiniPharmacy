
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
            inventory.getAllMedicines().forEach(System.out::println);
        }
        System.out.println("\n**********************************************************************************");
    }
}

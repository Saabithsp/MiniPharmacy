package Command.Functional;

import Command.Command;
import Model.Inventory;

public class ShowExpiredCommand implements Command {
    private Inventory inventory;

    public ShowExpiredCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        System.out.println("Expired Medicines:");
        inventory.filterAndDisplay(m -> m.isExpired());
    }
}

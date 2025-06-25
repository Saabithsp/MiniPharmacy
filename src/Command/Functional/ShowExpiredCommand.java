package Command.Functional;

import Command.Command;
import Model.Inventory;
import Model.Medicine;

import java.util.List;
import java.util.stream.Collectors;

public class ShowExpiredCommand implements Command {
    private Inventory inventory;

    public ShowExpiredCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        List<Medicine> expiredMeds = inventory.getAllMedicines().stream()
                .filter(Medicine::isExpired)
                .collect(Collectors.toList());

        if (expiredMeds.isEmpty()) {
            System.out.println("✅ No expired medicines in stock.\n");
        } else {
            System.out.println("⚠️ Expired Medicines:");
            expiredMeds.forEach(med -> 
                System.out.printf("ID: %s | Name: %s | Qty: %d | Price: %.2f | Expiry: %s%n",
                    med.getId(), med.getName(), med.getQuantity(), med.getPrice(), med.getExpiryDate()));
            System.out.println();
        }
    }
}

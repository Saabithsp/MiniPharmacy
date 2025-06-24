package Command;

import Model.Inventory;
import Model.Medicine;

import java.time.LocalDate;
import java.util.Scanner;

public class AddMedicineCommand implements Command {
    private Inventory inventory;

    public AddMedicineCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter medicine ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter medicine name: ");
        String name = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // clear buffer

        System.out.print("Enter expiry date (YYYY-MM-DD): ");
        String expiryInput = scanner.nextLine();
        LocalDate expiryDate = LocalDate.parse(expiryInput);

        Medicine medicine = new Medicine(id, name, quantity, price, expiryDate);
        inventory.addMedicine(medicine);

        System.out.println("\nMedicine added successfully!");
    }
}

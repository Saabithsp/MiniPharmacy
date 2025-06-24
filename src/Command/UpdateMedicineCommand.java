package Command;

import Model.Inventory;
import Model.Medicine;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UpdateMedicineCommand implements Command {
    private Inventory inventory;

    public UpdateMedicineCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Medicine ID to update: ");
        String id = scanner.nextLine();

        Medicine med = inventory.getMedicine(id);
        if (med == null) {
            System.out.println("Medicine with ID " + id + " not found.");
            return;
        }

        boolean done = false;
        while (!done) {
            System.out.println("\nSelect what to update:(Enter the number)");
            System.out.println("1. Name");
            System.out.println("2. Quantity");
            System.out.println("3. Price");
            System.out.println("4. Expiry Date (YYYY-MM-DD)");
            System.out.println("5. Exit update");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("\nEnter new name: ");
                    String newName = scanner.nextLine();
                    med.setName(newName);
                    System.out.println("Name updated.");
                    break;

                case "2":
                    System.out.print("\nEnter new quantity: ");
                    try {
                        int newQuantity = Integer.parseInt(scanner.nextLine());
                        med.setQuantity(newQuantity);
                        System.out.println("Quantity updated.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity.");
                    }
                    break;

                case "3":
                    System.out.print("\nEnter new price: ");
                    try {
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        med.setPrice(newPrice);
                        System.out.println("Price updated.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price.");
                    }
                    break;

                case "4":
                    System.out.print("\nEnter new expiry date (YYYY-MM-DD): ");
                    try {
                        LocalDate newDate = LocalDate.parse(scanner.nextLine());
                        med.setExpiryDate(newDate);
                        System.out.println("Expiry date updated.");
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format.");
                    }
                    break;

                case "5":
                    done = true;
                    System.out.println("\n******************************* Exited update menu. *******************************");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

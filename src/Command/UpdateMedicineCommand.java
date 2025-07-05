package Command;

import Model.Inventory;
import Model.Medicine;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UpdateMedicineCommand implements Command {
    private Inventory inventory;
    private Scanner scanner;

    public UpdateMedicineCommand(Inventory inventory, Scanner scanner) {
        this.inventory = inventory;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter Medicine ID to update: ");
        String id = scanner.nextLine().trim();

        Medicine med = inventory.getMedicine(id);
        if (med == null) {
            System.out.println("Medicine with ID " + id + " not found.");
            return;
        }

        boolean done = false;
        while (!done) {
            System.out.print("\nSelect what to update (Enter the number):\n"
                + "1. Name\n"
                + "2. Quantity\n"
                + "3. Price\n"
                + "4. Expiry Date (YYYY-MM-DD)\n"
                + "5. Exit update\n"
                + "Choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("\nEnter new name: ");
                    String newName = scanner.nextLine().trim();
                    inventory.updateName(id, newName);
                    System.out.println("Name updated.");
                    break;

                case "2":
                    while (true) {
                        System.out.print("\nEnter new quantity: ");
                        String input = scanner.nextLine().trim();
                        try {
                            int newQuantity = Integer.parseInt(input);
                            if (newQuantity < 0) {
                                System.out.println("Quantity cannot be negative. Try again.");
                                continue;
                            }
                            inventory.updateQuantity(id, newQuantity);
                            System.out.println("Quantity updated.");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid quantity. Please enter a valid integer.");
                        }
                    }
                    break;

                case "3":
                    while (true) {
                        System.out.print("\nEnter new price: ");
                        String input = scanner.nextLine().trim();
                        try {
                            double newPrice = Double.parseDouble(input);
                            if (newPrice < 0) {
                                System.out.println("Price cannot be negative. Try again.");
                                continue;
                            }
                            inventory.updatePrice(id, newPrice);
                            System.out.println("Price updated.");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price. Please enter a valid number.");
                        }
                    }
                    break;

                case "4":
                    while (true) {
                        System.out.print("\nEnter new expiry date (YYYY-MM-DD): ");
                        String dateInput = scanner.nextLine().trim();
                        try {
                            LocalDate newDate = LocalDate.parse(dateInput);
                            if (newDate.isBefore(LocalDate.now())) {
                                System.out.println("Expiry date cannot be in the past. Please enter a valid date.");
                                continue;
                            }
                            inventory.updateExpiryDate(id, newDate);
                            System.out.println("Expiry date updated.");
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                        }
                    }
                    break;

                case "5":
                    done = true;
                    System.out.println("\n******************************* Exited update menu. *******************************");
                    break;

                default:
                    System.out.println("Invalid choice. Please select from 1 to 5.");
            }
        }
    }
}




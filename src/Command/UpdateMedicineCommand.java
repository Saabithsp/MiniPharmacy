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
            System.out.println("\nSelect what to update (Enter the number):");
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
                    while (true) {
                        System.out.print("\nEnter new quantity: ");
                        String input = scanner.nextLine();
                        try {
                            int newQuantity = Integer.parseInt(input);
                            if (newQuantity < 0) {
                                System.out.println("Quantity cannot be negative. Try again.");
                                continue;
                            }
                            med.setQuantity(newQuantity);
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
                        String input = scanner.nextLine();
                        try {
                            double newPrice = Double.parseDouble(input);
                            if (newPrice < 0) {
                                System.out.println("Price cannot be negative. Try again.");
                                continue;
                            }
                            med.setPrice(newPrice);
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
                        String dateInput = scanner.nextLine();
                        try {
                            LocalDate newDate = LocalDate.parse(dateInput);
                            if (newDate.isBefore(LocalDate.now())) {
                                System.out.println("Expiry date cannot be in the past. Please enter a valid date.");
                                continue;
                            }
                            med.setExpiryDate(newDate);
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

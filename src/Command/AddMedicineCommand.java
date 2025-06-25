package Command;

import java.time.LocalDate;
import java.util.Scanner;

import Model.Inventory;
import Model.Medicine;

public class AddMedicineCommand implements Command {
    private Inventory inventory;
    private Scanner scanner;

    public AddMedicineCommand(Inventory inventory,Scanner scanner) {
        this.inventory = inventory;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
    	
        System.out.print("Enter medicine ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter medicine name: ");
        String name = scanner.nextLine();

        int quantity = 0;
        while (true) {
            System.out.print("Enter quantity: ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative. Please try again.");
                    scanner.nextLine();
                    continue;
                }
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer value for quantity.");
                scanner.nextLine(); 
            }
        }

        double price = 0.0;
        while (true) {
            System.out.print("Enter price: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("Price cannot be negative. Please try again.");
                    scanner.nextLine(); 
                    continue;
                }
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for price.");
                scanner.nextLine();
            }
        }

        LocalDate expiryDate = null;
        while (true) {
            System.out.print("Enter expiry date (YYYY-MM-DD): ");
            String expiryInput = scanner.nextLine();
            try {
                expiryDate = LocalDate.parse(expiryInput);
                if (expiryDate.isBefore(LocalDate.now())) {
                    System.out.println("Expiry date cannot be in the past. Please enter a valid date.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        Medicine medicine = new Medicine(id, name, quantity, price, expiryDate);
        inventory.addMedicine(medicine);

        System.out.println("\nMedicine added successfully!");
    }
}

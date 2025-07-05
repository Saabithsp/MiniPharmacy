package View;

import java.util.Scanner;

import Command.AddMedicineCommand;
import Command.RemoveMedicineCommand;
import Command.UpdateMedicineCommand;
import Command.ViewMedicineCommand;
import Command.Functional.ShowExpiredCommand;
import Command.Functional.ShowLowStockCommand;

import Controller.PharmacyController;
import Controller.ReflectionUtil;

import Model.Inventory;
import Observer.ConsoleLogger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Using a single scanner throughout the application
        Inventory inventory = new Inventory();
        PharmacyController controller = new PharmacyController();

        // Registering core CRUD commands
        controller.registerCommand("add", new AddMedicineCommand(inventory, scanner));
        controller.registerCommand("remove", new RemoveMedicineCommand(inventory, scanner));
        controller.registerCommand("view", new ViewMedicineCommand(inventory));
        controller.registerCommand("update", new UpdateMedicineCommand(inventory, scanner));

        // Registering functional/analytic commands
        controller.registerCommand("stock", new ShowLowStockCommand(inventory));
        controller.registerCommand("expired", new ShowExpiredCommand(inventory));

        // Adding observer (Observer Pattern)
        ConsoleLogger logger = new ConsoleLogger();
        inventory.addObserver(logger);

        // Displaying available commands using reflection
        ReflectionUtil.listCommandClasses();

        // Starting the system
        System.out.println("\n\t ********** 💊 Welcome to CureLens Mini Pharmacy System 💊 ********** ");
        controller.start(scanner);

        // Closing the scanner after system exits...
        scanner.close();
    }
}

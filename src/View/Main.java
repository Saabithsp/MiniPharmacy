package View;

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
        Inventory inventory = new Inventory(); 
        PharmacyController controller = new PharmacyController(); 

        // Register commands
        controller.registerCommand("add", new AddMedicineCommand(inventory));
        controller.registerCommand("remove", new RemoveMedicineCommand(inventory));
        controller.registerCommand("view", new ViewMedicineCommand(inventory));
        controller.registerCommand("update", new UpdateMedicineCommand(inventory));
        
        // Register commands for Command.Functional
        controller.registerCommand("stock", new ShowLowStockCommand(inventory));
        controller.registerCommand("expired", new ShowExpiredCommand(inventory));

        
        ReflectionUtil.listCommandClasses("Command");

        ConsoleLogger logger = new ConsoleLogger();
        inventory.addObserver(logger);
        
        // Start the system
        controller.start();
    }
}

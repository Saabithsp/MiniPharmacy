package Controller;

import Command.Command;
import java.util.HashMap;
import java.util.Scanner;

public class PharmacyController {
    private HashMap<String, Command> commands;
    private Scanner scanner;

    public PharmacyController() {
        commands = new HashMap<>();
    }

    // Method to register commands
    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    // Main loop to take user input and execute commands
    public void start(Scanner scanner) {
        String input = "";

        while (!input.equalsIgnoreCase("exit")) {
        	System.out.println(
        		    "\nSelect an option:\n" +
        		    "  view    - View details of an item\n" +
        		    "  stock   - View items currently in stock\n" +
        		    "  expired - List expired items\n" +
        		    "  add     - Add a new item\n" +
        		    "  update  - Update an existing item\n" +
        		    "  remove  - Remove an item\n" +
        		    "  exit    - Exit the application\n" +
        		    "Your choice: "
        		);

            input = scanner.nextLine();

            Command command = commands.get(input.toLowerCase());
            if (command != null) {
                command.execute();
            } else if (!input.equalsIgnoreCase("exit")) {
                System.out.println("Unknown command. Try again.");
            }
        }

        System.out.println("###################### THANK YOU FOR USING THE PHARMACY SYSTEM. GOODBYE! ######################");
    }
}

package Controller;

import Command.Command;
import java.util.HashMap;
import java.util.Scanner;

public class PharmacyController {
    private HashMap<String, Command> commands;
    private Scanner scanner;

    public PharmacyController() {
        commands = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Method to register commands
    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    // Main loop to take user input and execute commands
    public void start() {
        String input = "";

        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("\nEnter command (add, view, update, remove, exit):");
            input = scanner.nextLine();

            Command command = commands.get(input.toLowerCase());
            if (command != null) {
                command.execute();
            } else if (!input.equalsIgnoreCase("exit")) {
                System.out.println("Unknown command. Try again.");
            }
        }

        System.out.println("###################### THANK YOU FOR USING THE PHARMACY SYSTEM. GOODBYE! ######################");
        scanner.close();
    }
}

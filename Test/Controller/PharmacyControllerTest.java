package Controller;

import Command.Command;

import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PharmacyControllerTest {

    private PharmacyController controller;

    @BeforeEach
    public void setup() {
        controller = new PharmacyController();
    }

    @Test
    public void testRegisterCommandStoresCommand() throws Exception {
 
        Command dummyCommand = new Command() {
            @Override
            public void execute() {
                System.out.println("Test Command Executed");
            }
        };

        controller.registerCommand("test", dummyCommand);

        // Access private field via reflection
        Field field = PharmacyController.class.getDeclaredField("commands");
        field.setAccessible(true);
        HashMap<String, Command> commands = (HashMap<String, Command>) field.get(controller);

        assertTrue(commands.containsKey("test"));
        assertEquals(dummyCommand, commands.get("test"));
    }
    
    @AfterEach
    public void tearDown() {
        controller = null;
    }
}

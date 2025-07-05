
package Controller;

import org.reflections.Reflections;
import java.lang.reflect.Modifier;
import java.util.Set;
import Command.Command;

public class ReflectionUtil {
    public static void listCommandClasses() {
        System.out.println("🧠 Available Command Classes (Reflection):");

        // Scanning all classes under the "Command" package
        Reflections reflections = new Reflections("Command");

        // Get all subclasses of Command interface
        Set<Class<? extends Command>> commandClasses = reflections.getSubTypesOf(Command.class);

        for (Class<?> cls : commandClasses) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                System.out.print("\t-> " + cls.getSimpleName());
                if (Command.class.isAssignableFrom(cls)) {
                    System.out.println(" ✅ (implements Command)");
                } else {
                    System.out.println(" ❌ (does NOT implement Command)");
                }
            }
        }
    }
}


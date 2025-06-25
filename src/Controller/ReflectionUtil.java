package Controller;

import java.lang.reflect.*;

public class ReflectionUtil {
    public static void listCommandClasses() {
        System.out.println("🧠 Available Command Classes (Reflection):");

        Class<?>[] commands = {
            Command.AddMedicineCommand.class,
            Command.RemoveMedicineCommand.class,
            Command.ViewMedicineCommand.class,
            Command.UpdateMedicineCommand.class
        };

        for (Class<?> cls : commands) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                System.out.print("\t-> " + cls.getSimpleName());
                if (Command.Command.class.isAssignableFrom(cls)) {
                    System.out.println(" ✅ (implements Command)");
                } else {
                    System.out.println(" ❌ (does NOT implement Command)");
                }
            }
        }
    }
}

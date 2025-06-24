package Controller;

import java.lang.reflect.Modifier;

public class ReflectionUtil {
    public static void listCommandClasses(String packageName) {
        System.out.println("Listing available commands in package: " + packageName);

        Class<?>[] commands = {
            Command.AddMedicineCommand.class,
            Command.RemoveMedicineCommand.class,
            Command.ViewMedicineCommand.class,
            Command.UpdateMedicineCommand.class
        };

        for (Class<?> cls : commands) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                System.out.print("- " + cls.getSimpleName());
                if (Command.Command.class.isAssignableFrom(cls)) {
                    System.out.println(" ✅ (implements Command)");
                } else {
                    System.out.println(" ❌ (does NOT implement Command)");
                }
            }
        }
    }
}

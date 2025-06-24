package Model;

@FunctionalInterface
public interface MedicineFilter {
    boolean test(Medicine medicine);
}


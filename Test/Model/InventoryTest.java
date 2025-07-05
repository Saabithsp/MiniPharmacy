package Model;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    public void setup() {
        inventory = new Inventory();
    }

    @Test
    public void testAddAndRetrieveMedicine() {
        Medicine m1 = new Medicine("M01", "Paracetamol", 10, 50.0, LocalDate.now().plusDays(10));
        inventory.addMedicine(m1);
        Medicine found = inventory.getMedicine("M01");
        assertNotNull(found);
        assertEquals("Paracetamol", found.getName());
    }

    @Test
    public void testRemoveMedicine() {
        Medicine m2 = new Medicine("M02", "Cetrizine", 5, 30.0, LocalDate.now().plusDays(20));
        inventory.addMedicine(m2);
        inventory.removeMedicine("M02");
        assertNull(inventory.getMedicine("M02"));
    }

    @Test
    public void testGetAllMedicines() {
        inventory.addMedicine(new Medicine("M03", "Ibuprofen", 15, 60.0, LocalDate.now().plusDays(30)));
        Collection<Medicine> all = inventory.getAllMedicines();
        assertEquals(1, all.size());
    }
    
    @Test
    public void testGetNonExistentMedicine() {
        assertNull(inventory.getMedicine("NON_EXISTENT"));
    }
    
    @Test
    public void testRemoveMedicineThrowsExceptionWhenIdNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inventory.removeMedicine(null);
        });
        assertEquals("Medicine ID cannot be null", exception.getMessage());
    }
    
    @AfterEach
    public void tearDown() {
        inventory = null;
    }
}

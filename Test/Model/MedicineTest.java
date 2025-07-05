package Model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class MedicineTest {

    private Medicine expiredMed;
    private Medicine freshMed;
    private Medicine normalMed;

    @BeforeEach
    public void setup() {
        expiredMed = new Medicine("001", "Paracetamol", 10, 20.0, LocalDate.now().minusDays(1));
        freshMed = new Medicine("002", "Amoxicillin", 5, 30.0, LocalDate.now().plusDays(5));
        normalMed = new Medicine("003", "Vitamin C", 12, 15.0, LocalDate.now());
    }

    @Test
    public void testIsExpired() {
        assertTrue(expiredMed.isExpired());
    }

    @Test
    public void testIsNotExpired() {
        assertFalse(freshMed.isExpired());
    }

    @Test
    public void testGetNameAndPrice() {
        assertEquals("Vitamin C", normalMed.getName());
        assertEquals(15.0, normalMed.getPrice());
    }
    
    @AfterEach
    public void tearDown() {
        expiredMed = null;
        freshMed = null;
        normalMed = null;
    }

}

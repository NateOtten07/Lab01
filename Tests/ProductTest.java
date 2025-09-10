import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for Product.
 * Tests constructors, setters, and special methods (toCSV, toJSON, toXML).
 */
class ProductTest {

    private Product p;

    @BeforeEach
    void setUp() {

        p = new Product("123456", "Lightsaber", "An elegant weapon for a more civilized age", 1200.00);
    }

    @Test
    void testConstructorAndToCSV() {
        // Test CSV output
        String csv = p.toCSV();
        assertTrue(csv.contains("123456"));
        assertTrue(csv.contains("Lightsaber"));
        assertTrue(csv.contains("An elegant weapon for a more civilized age"));
        assertTrue(csv.contains("1200.0"));
    }

    @Test
    void testSettersAndSpecialMethods() {
        // Modify the Product object
        p.setID("123457");
        p.setName("Blaster");
        p.setDescription("A reliable blaster for galactic adventures");
        p.setCost(750.00);

        // Test CSV output
        String csv = p.toCSV();
        assertTrue(csv.contains("123457"));
        assertTrue(csv.contains("Blaster"));
        assertTrue(csv.contains("A reliable blaster for galactic adventures"));
        assertTrue(csv.contains("750.0"));

        // Test JSON output
        String json = p.toJSON();
        assertTrue(json.contains("\"ID\":\"123457\""));
        assertTrue(json.contains("\"name\":\"Blaster\""));
        assertTrue(json.contains("\"description\":\"A reliable blaster for galactic adventures\""));
        assertTrue(json.contains("\"cost\":750.0"));

        // Test XML output
        String xml = p.toXML();
        assertTrue(xml.contains("<Product>"));
        assertTrue(xml.contains("<ID>123457</ID>"));
        assertTrue(xml.contains("<name>Blaster</name>"));
        assertTrue(xml.contains("<description>A reliable blaster for galactic adventures</description>"));
        assertTrue(xml.contains("<cost>750.0</cost>"));
    }

    @Test
    void testEqualsMethod() {
        // Test equals with another identical object
        Product copy = new Product("123456", "Lightsaber", "An elegant weapon for a more civilized age", 1200.00);
        assertEquals(p, copy);

        // Test equals with different object
        Product different = new Product("123458", "Droid", "Helpful astromech droid", 500.00);
        assertNotEquals(p, different);
    }
}

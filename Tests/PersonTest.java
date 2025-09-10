import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for Person.
 * Tests constructors, setters, and special methods (fullName, formalName, age, CSV, JSON, XML).
 */
class PersonTest {

    private Person p;

    @BeforeEach
    void setUp() {
        // Construct a Person object for testing
        p = new Person("123456", "Nathan", "Otten", "Mr.", 2007);
    }

    @Test
    void testConstructorAndFullName() {
        // Test fullName method
        assertEquals("Nathan Otten", p.fullName());
    }

    @Test
    void testFormalName() {
        // Test formalName method
        assertEquals("Mr. Nathan Otten", p.formalName());
    }

    @Test
    void testSettersAndSpecialMethods() {
        // Modify the Person object
        p.setFirstName("Bob");
        p.setLastName("Tester1");
        p.setTitle("Mr.");
        p.setID("123457");
        p.setYOB(1990);

        // Test CSV output
        String csv = p.toCSV();
        assertTrue(csv.contains("Bob"));
        assertTrue(csv.contains("Tester1"));
        assertTrue(csv.contains("Mr."));
        assertTrue(csv.contains("123457"));
        assertTrue(csv.contains("1990"));

        // Test JSON output
        String json = p.toJSON();
        assertTrue(json.contains("\"ID\":\"123457\""));
        assertTrue(json.contains("\"firstName\":\"Bob\""));
        assertTrue(json.contains("\"lastName\":\"Tester1\""));
        assertTrue(json.contains("\"title\":\"Mr.\""));
        assertTrue(json.contains("\"YOB\":1990"));

        // Test XML output
        String xml = p.toXML();
        assertTrue(xml.contains("<Person>"));
        assertTrue(xml.contains("<ID>123457</ID>"));
        assertTrue(xml.contains("<firstName>Bob</firstName>"));
        assertTrue(xml.contains("<lastName>Tester1</lastName>"));
        assertTrue(xml.contains("<title>Mr.</title>"));
        assertTrue(xml.contains("<YOB>1990</YOB>"));
    }

    @Test
    void testGetAgeMethods() {
        // Test age calculation for specific year
        assertEquals(18, p.getAge(2025));

        // Test age calculation for current year (should match calendar calculation)
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(currentYear - 2007, p.getAge());
    }

    @Test
    void testEqualsMethod() {
        // Test equals with another identical object
        Person copy = new Person("123456", "Nathan", "Otten", "Mr.", 2007);
        assertEquals(p, copy);

        // Test equals with different object
        Person different = new Person("123457", "Bob", "Tester1", "Mr.", 1990);
        assertNotEquals(p, different);
    }
}

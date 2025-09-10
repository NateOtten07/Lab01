import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

    /**
     * JUnit tests for SafeInputObject.
     * Tests constructors and interactive methods using simulated input.
     */
    class SafeInputObjTest {

        private SafeInputObject safeInput;

        @BeforeEach
        void setUp() {
            safeInput = new SafeInputObject(new Scanner(System.in));
        }

        @Test
        void testConstructorWithDefaultScanner() {
            SafeInputObject obj = new SafeInputObject();
            assertNotNull(obj);
        }

        @Test
        void testConstructorWithInjectedScanner() {
            Scanner sc = new Scanner("test\n");
            SafeInputObject obj = new SafeInputObject(sc);
            assertNotNull(obj);
        }

        @Test
        void testGetNonZeroLenString() {
            Scanner sc = new Scanner("Hello\n");
            String result = SafeInputObject.getNonZeroLenString(sc, "Enter a string");
            assertEquals("Hello", result);
        }

        @Test
        void testGetRangedIntValid() {
            Scanner sc = new Scanner("5\n");
            SafeInputObject obj = new SafeInputObject(sc);
            int result = obj.getRangedInt("Enter number", 1, 10);
            assertEquals(5, result);
        }

        @Test
        void testGetIntValid() {
            Scanner sc = new Scanner("42\n");
            SafeInputObject obj = new SafeInputObject(sc);
            int result = obj.getInt("Enter number");
            assertEquals(42, result);
        }

        @Test
        void testGetRangedDoubleValid() {
            Scanner sc = new Scanner("7.5\n");
            SafeInputObject obj = new SafeInputObject(sc);
            double result = obj.getRangedDouble("Enter number", 1, 10);
            assertEquals(7.5, result);
        }

        @Test
        void testGetDoubleValid() {
            Scanner sc = new Scanner("3.14\n");
            SafeInputObject obj = new SafeInputObject(sc);
            double result = obj.getDouble("Enter double");
            assertEquals(3.14, result);
        }

        @Test
        void testGetYNConfirmYes() {
            Scanner sc = new Scanner("Y\n");
            SafeInputObject obj = new SafeInputObject(sc);
            assertTrue(obj.getYNConfirm("Continue?"));
        }

        @Test
        void testGetYNConfirmNo() {
            Scanner sc = new Scanner("N\n");
            SafeInputObject obj = new SafeInputObject(sc);
            assertFalse(obj.getYNConfirm("Continue?"));
        }

        @Test
        void testGetRegExStringValid() {
            Scanner sc = new Scanner("abc123\n");
            SafeInputObject obj = new SafeInputObject(sc);
            String result = obj.getRegExString("Enter value", "[a-z]+[0-9]+");
            assertEquals("abc123", result);
        }
    }


import java.util.Scanner;

/**
 * Tests all methods for SafeInputObject to make sure they work
 */
public class ObjInputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SafeInputObject sio = new SafeInputObject(scanner);


        String nonZeroString = SafeInputObject.getNonZeroLenString(scanner, "Enter a non-empty string");
        System.out.println("You entered: " + nonZeroString);

        int rangedInt = sio.getRangedInt("Enter an int between 1 and 10", 1, 10);
        System.out.println("You entered valid ranged int: " + rangedInt);

        int anyInt = sio.getInt("Enter any integer");
        System.out.println("You entered int: " + anyInt);


        double rangedDouble = sio.getRangedDouble("Enter a double between 0.0 and 100.0", 0, 100);
        System.out.println("You entered valid ranged double: " + rangedDouble);


        double anyDouble = sio.getDouble("Enter any double");
        System.out.println("You entered double: " + anyDouble);


        boolean confirm = sio.getYNConfirm("Do you want to continue?");
        System.out.println("You answered: " + (confirm ? "Yes" : "No"));


        String regexString = sio.getRegExString("Enter letters and digits 1-9", "[a-z]+[0-9]+");
        System.out.println("You entered valid regex string: " + regexString);
    }
}

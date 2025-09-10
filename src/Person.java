import java.util.Calendar;
import java.util.Objects;

/**
 * Represents a person with identifying information.
 * Includes ID, first name, last name, title, and year of birth.
 * Provides CSV, JSON, and XML representations.
 *
 * @author Nathan
 */
public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    /**
     * Constructor for Person
     * @param ID unique ID
     * @param firstName first name
     * @param lastName last name
     * @param title prefix such as Mr., Ms., Dr.
     * @param YOB year of birth (1940–2010)
     */
    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYOB() { return YOB; }
    public void setYOB(int YOB) { this.YOB = YOB; }

    /**
     * @return full name
     * */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * @return formal name
     * */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * @return age from current year
     * */
    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    /**
     * Calculate age for a year
     * @param year
     * @return age
     */
    public int getAge(int year) {
        return year - YOB;
    }

    /**
     * @return CSV format for person
     * */
    public String toCSV() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    /**
     *  @return JSON format for person
     * */
    public String toJSON() {
        return "{ \"ID\":\"" + ID + "\", " +
                "\"firstName\":\"" + firstName + "\", " +
                "\"lastName\":\"" + lastName + "\", " +
                "\"title\":\"" + title + "\", " +
                "\"YOB\":" + YOB + " }";
    }

    /**
     * @return XML format for person
     * */
    public String toXML() {
        return "<Person>" +
                "<ID>" + ID + "</ID>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }

    @Override
    public String toString() {
        return formalName() + " (" + ID + "), YOB: " + YOB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                Objects.equals(ID, person.ID) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(title, person.title);
    }
}

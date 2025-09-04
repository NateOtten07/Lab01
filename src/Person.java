import java.util.Objects;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YearOfBirth;
    private int age;

    public Person(String ID, String firstName, String lastName, String title, int age) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        YearOfBirth = yearOfBirth;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    public String fullName()
        {
        return firstName + " " + lastName;
        }


        public String formalName()
        {
            return title + " " + firstName + " " + lastName;
        }

        public int getAge(int YearOfBirth, int Year)
        {
            int Age = Year - YearOfBirth;
            return Age;
        }

}


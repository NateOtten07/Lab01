import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Recieves data about a person from the user and writes it to a file
 */
public class PersonGenerator
{
    /**
     * Runs the program: writes it in csv format to a file called "PersonTestData"
     * @param args
     */
    public static void main(String[] args)
    {

        String ID = "";
        String firstname = "";
        String lastname = "";
        String title = "";
        String CSVPersonRec = "";
        int YearofBirth = 0;

        Scanner in = new Scanner(System.in);
        ArrayList<String> Persons = new ArrayList<>();


        boolean done = false;

        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter ID");
            firstname = SafeInput.getNonZeroLenString(in, "Enter First Name");
            lastname = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            title = SafeInput.getNonZeroLenString(in, "Enter Title");
            YearofBirth = SafeInput.getRangedInt(in, "Enter your Year of Birth", 1000, 9999);

            CSVPersonRec = ID + ", " + firstname + ", " + lastname + ", " + title + ", " + YearofBirth + "\n";

            Persons.add(CSVPersonRec);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        }while(!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.toString(), "\\src\\PersonTestData.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec: Persons)
            {
                writer.write(rec,0,rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file Written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
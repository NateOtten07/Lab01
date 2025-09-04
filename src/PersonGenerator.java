import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Calendar;

public class PersonGenerator
{

    public static void main(String[] args)
    {

            String ID = "";
            String firstname = "";
            String lastname = "";
            String title = "";
            String CSVPersonRec = "";
            int YearofBirth = 0;

            Scanner in = new Scanner(System.in);
            ArrayList<String> csvPersons = new ArrayList<>();



            boolean done = false;

            do{
                ID = SafeInput.getNonZeroLenString(in, "Enter ID");
                firstname = SafeInput.getNonZeroLenString(in, "Enter First Name");
                lastname = SafeInput.getNonZeroLenString(in, "Enter Last Name");
                title = SafeInput.getNonZeroLenString(in, "Enter Title");
                YearofBirth = SafeInput.getRangedInt(in, "Enter your Year of Birth", 1940, 2010);

                CSVPersonRec = ID + ", " + firstname + ", " + lastname + ", " + title + ", " + YearofBirth + "\n";

                csvPersons.add(CSVPersonRec);

                done = SafeInput.getYNConfirm(in, "Are you done?");

                Person p = new Person(ID, firstname, lastname, title, YearofBirth);
                CSVPersonRec = p.getID() + ", " + p.fullName() + ", " + p.getTitle() + ", " + p.getYearOfBirth();
                csvPersons.add(CSVPersonRec);

            }while(!done);

            File workingDirectory = new File(System.getProperty("user.dir"));
            Path file = Paths.get(workingDirectory.toString(), "\\src\\PersonTestData.txt");

            try
            {
                OutputStream out =
                        new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                BufferedWriter writer =
                        new BufferedWriter(new OutputStreamWriter(out));

                for(String rec: csvPersons)
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
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProductWriter
{
    public static void main(String[] args)
    {

        String ID = "";
        String Name = "";
        String Description = "";
        String CSVPersonRec = "";
        Double Cost = (double) 0;

        Scanner in = new Scanner(System.in);
        ArrayList<String> csvPersons = new ArrayList<>();


        boolean done = false;

        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter ID");
            Name = SafeInput.getNonZeroLenString(in, "Enter Name");
            Description = SafeInput.getNonZeroLenString(in, "Enter Description (short sentence)");
            Cost = SafeInput.getRangedDouble(in, "Enter Cost", 0, 9999);

            CSVPersonRec = ID + ", " + Name + ", " + Description + ", " + Cost + "\n";

            csvPersons.add(CSVPersonRec);

            done = SafeInput.getYNConfirm(in, "Are you done?");

        }while(!done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.toString(), "\\src\\ProductTestData.txt");

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
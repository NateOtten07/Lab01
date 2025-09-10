import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Recieves input from a user on data about a product
 */
public class ProductWriter
{
    /**
     * Runs the program: Writes the data to a file called "ProductTestData"
     * @param args
     */
    public static void main(String[] args)
    {

        String ID = "";
        String Name = "";
        String Description = "";
        String Product = "";
        double Cost = 0;

        Scanner in = new Scanner(System.in);
        ArrayList<String> Products = new ArrayList<>();


        boolean done = false;

        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter ID");
            Name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            Description = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            Cost = SafeInput.getRangedInt(in, "Enter Product Cost", 0, 9999);

            Product = ID + ", " + Name + ", " + Description + ", " + Cost + "\n";

            Products.add(Product);

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

            for(String rec: Products)
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
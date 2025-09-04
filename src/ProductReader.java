import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 *
 * @author ottennr
 *
 */
public class ProductReader
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                String line;



                System.out.println(String.format("%-10s %-15s %-30s %-15s",
                        "ID#", "Name", "Description", "Cost"));
                System.out.println("==============================================================");

                while ((line = reader.readLine()) != null) {

                    if (line.trim().isEmpty()) continue;


                    String[] parts = line.split(",");


                    if (parts.length == 4) {
                        String id = parts[0].trim();
                        String Name = parts[1].trim();
                        String Desc= parts[2].trim();
                        String Cost = parts[3].trim();


                        System.out.println(String.format("%-10s %-15s %-30s %-15s", id, Name, Desc, Cost));
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}

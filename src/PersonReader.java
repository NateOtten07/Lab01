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
public class PersonReader
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



                System.out.println(String.format("%-10s %-15s %-15s %-10s %-5s",
                        "ID#", "Firstname", "Lastname", "Title", "YOB"));
                System.out.println("==============================================================");

                while ((line = reader.readLine()) != null) {

                    if (line.trim().isEmpty()) continue;


                    String[] parts = line.split(",");


                    if (parts.length == 5) {
                        String id = parts[0].trim();
                        String first = parts[1].trim();
                        String last = parts[2].trim();
                        String title = parts[3].trim();
                        String yob = parts[4].trim();


                        System.out.println(String.format("%-10s %-15s %-15s %-10s %-5s",
                                id, first, last, title, yob));
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

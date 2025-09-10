import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * Reads Person records from a CSV file and prints them in a table,
 * JSON, and XML formats.
 */
public class PersonReader {

    /**
     * Runs the program: prompts for a file, reads Person data, prints table, JSON, and XML.
     * @param args
     */
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                ArrayList<Person> people = new ArrayList<>();

                try (BufferedReader reader = Files.newBufferedReader(file)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.trim().isEmpty()) continue;

                        String[] parts = line.split(",");
                        if (parts.length == 5) {   // expecting CSV format: ID, first, last, title, YOB
                            String id = parts[0].trim();
                            String first = parts[1].trim();
                            String last = parts[2].trim();
                            String title = parts[3].trim();
                            int yob = Integer.parseInt(parts[4].trim());

                            people.add(new Person(id, first, last, title, yob));
                        }
                    }
                }

                //CSV
                System.out.println("CSV:");
                for (Person p : people)
                {
                    System.out.println(p.toCSV());
                }
                System.out.println("\n");

                //JSON
                System.out.println("JSON: [");
                for (Person p : people)
                {
                    System.out.println(p.toJSON());
                }
                System.out.println("]");
                System.out.println("\n");

                //XML
                System.out.println("XML:");
                System.out.println("<Persons>");
                for (Person p : people)
                {
                System.out.println(p.toXML());
                }
                System.out.println("</Persons>");
                System.out.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

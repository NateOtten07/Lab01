import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * Reads Product records from a CSV file into an ArrayList and prints them.
 */
public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                ArrayList<Product> products = new ArrayList<>();

                try (BufferedReader reader = Files.newBufferedReader(file)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.trim().isEmpty()) continue;

                        String[] parts = line.split(",");
                        if (parts.length == 4) {
                            String ID = parts[0].trim();
                            String name = parts[1].trim();
                            String desc = parts[2].trim();
                            double cost = Double.parseDouble(parts[3].trim());

                            products.add(new Product(ID, name, desc, cost));
                        }
                    }
                }

                //CSV
                System.out.println("CSV:");
                for (Product p : products)
                {
                    System.out.println(p.toCSV());
                }
                System.out.println("\n");

                //JSON
                System.out.println("JSON: [");
                for (Product p : products)
                {
                    System.out.println(p.toJSON());
                }
                System.out.println("]");
                System.out.println("\n");

                //XML
                System.out.println("XML:");
                System.out.println("<Products>");
                for (Product p: products)
                {
                    System.out.println(p.toXML());
                }
                System.out.println("</Products>");
                System.out.println("\n");
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.util.Objects;

/**
 * Represents a product with identifying information, including a unique ID,
 * name, description, and cost.
 * Author: Nathan Otten
 */
public class Product {
    private String ID;
    private String Name;
    private String Description;
    private double Cost;

    /**
     * Full constructor for Product
     * @param ID unique identifier
     * @param Name product name
     * @param Description product description
     * @param Cost product cost
     */
    public Product(String ID, String Name, String Description, double Cost) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Cost = Cost;
    }

    @Override
    public String toString() {
        return ID + ", " + Name + ", " + Description + ", " + Cost;
    }

    // Getters and Setters
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }

    public String getDescription() { return Description; }
    public void setDescription(String Description) { this.Description = Description; }

    public double getCost() { return Cost; }
    public void setCost(double cost) { this.Cost = cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.Cost, Cost) == 0 &&
                Objects.equals(ID, product.ID) &&
                Objects.equals(Name, product.Name) &&
                Objects.equals(Description, product.Description);
    }

    /**
     * Returns a CSV string of the product
     */
    public String toCSV() {
        return ID + "," + Name + "," + Description + "," + Cost;
    }

    /**
     * Returns a JSON string of the product
     */
    public String toJSON() {
        return "{" +
                "\"ID\":\"" + ID + "\"," +
                "\"name\":\"" + Name + "\"," +
                "\"description\":\"" + Description + "\"," +
                "\"cost\":" + Cost +
                "}";
    }

    /**
     * Returns an XML string of the product
     */
    public String toXML() {
        return "<Product>" +
                "<ID>" + ID + "</ID>" +
                "<name>" + Name + "</name>" +
                "<description>" + Description + "</description>" +
                "<cost>" + Cost + "</cost>" +
                "</Product>";
    }
}

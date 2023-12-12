import java.util.ArrayList;
import java.util.Objects;

public class GardenCenterEmployee extends User{
    private int employeeID;

    private ArrayList<Product> productInventory;

    public GardenCenterEmployee(String firstName, String lastName, String phoneNumber, String emailAddress) {
        super(firstName, lastName, phoneNumber, emailAddress);
        this.employeeID = getId();
        productInventory = new ArrayList<>();
    }

    public Product productSearch(String productName) {

        Product productToFind;

        for (Product p : productInventory) {
            if (Objects.equals(productName, p.getName())) {
                productToFind = p;
                return productToFind;
            }
        }

        return null;
    }

    public ArrayList<Product> getProductInventory() {
        return productInventory;
    }

    @Override
    public String toString() {
        return "GardenCenterEmployee{" +
                "employeeID=" + employeeID +
                ", productInventory=" + productInventory +
                "} " + super.toString();
    }
}

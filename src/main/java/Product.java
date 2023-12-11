public class Product {

    private int productID;
    private String name;
    private String description;
    private String category;
    private double price;
    private int quantity;

    public Product(int productID, String name, String description, String category, double price, int quantity) {
        this.productID = productID;
        this.name = name.toLowerCase();
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productID + ", name: " + name + ", description: " + description + ", category: " + category + ", price: " + price + ", quantity: " + quantity;
    }
}

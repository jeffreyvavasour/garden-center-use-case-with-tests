import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager extends GardenCenterEmployee {

    private Product currentProduct;
    public Manager(String firstName, String lastName, String phoneNumber, String emailAddress) {
        super(firstName, lastName, phoneNumber, emailAddress);
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public String addProduct(int productID, String name, String description, String category, double price, int quantity) {

        Product newProduct = new Product(productID, name, description, category, price, quantity);
        String resultMsg;

        Product resultProduct = super.productSearch(name);
        if (resultProduct == null) {
            super.getProductInventory().add(newProduct);
            resultMsg = "Product added to inventory";
            System.out.println(resultMsg);
            System.out.println(getProductInventory());
            return resultMsg;
        }

        resultMsg = "Product already exists";
        System.out.println(resultMsg);
        return resultMsg;
    }

    public void removeProduct(Product product) {
        super.getProductInventory().remove(product);
    }

    public String orderProduct() {
        String msg = "You have successfully placed your order!";
        System.out.println(msg);
        System.out.println();

        return msg;
    }

    public void editProduct(int userInput2, Product currentProduct) {

        Scanner sc = new Scanner(System.in);

        // edit name
        if (userInput2 == 1) {
            System.out.println("Enter new product name");
            currentProduct.setName(sc.nextLine().toLowerCase());
            System.out.println("Name updated successfully!");
            System.out.println();
        }
        // edit desc
        if (userInput2 == 2) {
            System.out.println("Enter new product description");
            currentProduct.setDescription(sc.nextLine().toLowerCase());
            System.out.println("Description updated successfully!");
            System.out.println();
        }
        // edit category
        if (userInput2 == 3) {
            System.out.println("Enter new product category");
            currentProduct.setCategory(sc.nextLine().toLowerCase());
            System.out.println("Category updated successfully!");
            System.out.println();
        }
        // edit price
        if (userInput2 == 4) {
            // guarantee number is an int
            double price;
            price = checkPrice();
            currentProduct.setPrice(price);
            System.out.println("Price updated successfully!");
            System.out.println();
        }
        // edit quantity
        if (userInput2 == 5) {
            // guarantee number is a positive int
            int quantity;
            quantity = checkQuantity();
            currentProduct.setQuantity(quantity);
            System.out.println("Quantity updated successfully!");
            System.out.println();
        }
    }

    public void manageProducts() {

        Scanner sc = new Scanner(System.in);

        // get product name from user
        System.out.print("Search product name: ");
        String productName = sc.nextLine();

        // sets current product to the product found or null
        currentProduct = productSearch(productName);
        System.out.println(currentProduct);

        // if product is found
        if (currentProduct != null) {

            // get input to edit, remove, order product or quit
            int userInput;
            userInput = checkUserInput();

            // user wants to edit
            if (userInput == 1) {

                boolean flag = true;
                while (flag) {

                    // get input to edit name, desc, category, price or quantity
                    int userInput2;
                    userInput2 = checkUserInput2();

                    // give option based on user input
                    // and edit product
                    editProduct(userInput2, currentProduct);

                    // quit editing
                    if (userInput2 == 6) {
                        flag = false;
                    }
                }
            }

            // remove product
            if (userInput == 2) {
                System.out.println("Product removed from inventory");
                removeProduct(currentProduct);
            }

            // order product
            if (userInput == 3) {
                orderProduct();
            }

            // quit product management
            if (userInput == 4) {
                System.out.println("Quitting project management");
                return;
            }
        }

        // if product is not found
        if (currentProduct == null) {

            // get input to add product or quit product management
            System.out.println("Product was not found...");
            int userInputAfterNull;
            userInputAfterNull = checkUserInputAfterNull();

            // add product
            if (userInputAfterNull == 1) {

                int id = 0;
                String name;
                String description;
                String category;
                double price = 0;
                int quantity = -1;

                // get user input on product info
                // product ID
                id = checkID();

                // name
                System.out.println("Enter product name");
                name = sc.nextLine();

                // description
                System.out.println("Enter product description");
                description = sc.nextLine();

                // category
                System.out.println("Enter product category");
                category = sc.nextLine();

                // price
                price = checkPrice();

                // quantity
                quantity = checkQuantity();

                // add product to inventory
                addProduct(id, name, description, category, price, quantity);
            }

            // quit product management
            if (userInputAfterNull == 2) {
                System.out.println("Quitting project management");
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "currentProduct=" + currentProduct +
                "} " + super.toString();
    }

    public void printManageMessage() {
        System.out.println("Please choose a number for what to do");
        System.out.println("1 = edit product");
        System.out.println("2 = remove product");
        System.out.println("3 = order product");
        System.out.println("4 = quit product management");
    }

    public void printEditMessage() {
        System.out.println("Please choose a number for what to do");
        System.out.println("1 = edit product name");
        System.out.println("2 = edit product description");
        System.out.println("3 = edit product category");
        System.out.println("4 = edit product price");
        System.out.println("5 = edit product quantity");
        System.out.println("6 = quit editing product");
    }

    public int checkUserInput() {

        Scanner sc = new Scanner(System.in);
        int userInput = 0;

        // guarantee number is an int between 1 and 4
        do {
            try {
                // Get input
                printManageMessage();
                userInput = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            sc.nextLine(); // clears the buffer
        } while (userInput <= 0 || userInput > 4);

        return userInput;
    }

    public int checkUserInput2() {

        Scanner sc = new Scanner(System.in);
        int userInput2 = 0;

        // guarantee number is an int between 1 and 6
        do {
            try {
                // Get input
                printEditMessage();
                userInput2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            sc.nextLine(); // clears the buffer
        } while (userInput2 <= 0 || userInput2 > 6);

        return userInput2;
    }

    public int checkUserInputAfterNull() {

        Scanner sc = new Scanner(System.in);
        int userInputAfterNull = 0;

        // guarantee number 1 or 2 is selected
        do {
            try {
                // Get input
                System.out.println("Please choose a number for what to do");
                System.out.println("1. add product");
                System.out.println("2. quit product management");
                userInputAfterNull = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input ");
            }
            sc.nextLine(); // clears the buffer
        } while (userInputAfterNull <= 0 || userInputAfterNull > 2);

        return userInputAfterNull;
    }

    public int checkID() {

        Scanner sc = new Scanner(System.in);
        int id = 0;

        // guarantee number is a positive int
        do {
            try {
                // Get input
                System.out.println("Create product ID (a positive integer)");
                id = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            sc.nextLine(); // clears the buffer
        } while (id <= 0);

        return id;
    }

    public double checkPrice() {

        Scanner sc = new Scanner(System.in);
        double price = 0;

        // guarantee number is an int
        do {
            try {
                // Get input
                System.out.println("Enter product price (to 2 decimal places)");
                price = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            sc.nextLine(); // clears the buffer
        } while (price <= 0);

        return price;
    }

    public int checkQuantity() {

        Scanner sc = new Scanner(System.in);
        int quantity = -1;

        // guarantee number is an int
        do {
            try {
                // Get input
                System.out.println("Enter product quantity");
                quantity = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            sc.nextLine(); // clears the buffer
        } while (quantity < 0);

        return quantity;
    }

}


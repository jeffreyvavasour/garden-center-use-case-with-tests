import java.util.Scanner;

public class Manager extends GardenCenterEmployee {

    private Product currentProduct;
    public Manager(String firstName, String lastName, String phoneNumber, String emailAddress) {
        super(firstName, lastName, phoneNumber, emailAddress);
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

//        if (!super.getProductInventory().contains(newProduct)) {
//            super.getProductInventory().add(newProduct);
//            resultMsg = "Product added to inventory";
//            System.out.println(resultMsg);
//            System.out.println(getProductInventory());
//            return resultMsg;
//        }

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

    @Override
    public String toString() {
        return "Manager{" +
                "currentProduct=" + currentProduct +
                "} " + super.toString();
    }

    public void manageProducts() {

        // get product name from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Search product name: ");
        String productName = sc.nextLine();

        // sets current product to the product found or null
        currentProduct = productSearch(productName);
        System.out.println(currentProduct);

        // if product is found get input to either edit, remove or order product
        if (currentProduct != null) {
            int userInput = 0;
            System.out.println("Please choose a number for what to do");
            System.out.println("1 = edit product");
            System.out.println("2 = remove product");
            System.out.println("3 = order product");
            System.out.println("4 = quit product management");
            userInput = sc.nextInt();
            sc.nextLine();

            // get input to either edit name, desc, category, price or quantity
            if (userInput == 1) {

                boolean flag = true;
                while (flag) {
                    int userInput2;
                    System.out.println("Please choose a number for what to do");
                    System.out.println("1 = edit product name");
                    System.out.println("2 = edit product description");
                    System.out.println("3 = edit product category");
                    System.out.println("4 = edit product price");
                    System.out.println("5 = edit product quantity");
                    System.out.println("6 = quit editing product");
                    userInput2 = sc.nextInt();
                    sc.nextLine();

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
                        System.out.println("Enter new product price to 2 decimal places (eg. 2.74)");
                        currentProduct.setPrice(sc.nextDouble());
                        System.out.println("Price updated successfully!");
                        System.out.println();
                    }
                    // edit quantity
                    if (userInput2 == 5) {
                        System.out.println("Enter new product quantity");
                        currentProduct.setQuantity(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Quantity updated successfully!");
                        System.out.println();
                    }
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

        // if product is not found get input to either add product or quit product management
        if (currentProduct == null) {
            int userInput;
            System.out.println("Product was not found...");
            System.out.println("Please choose a number for what to do");
            System.out.println("1. add product");
            System.out.println("2. quit product management");
            userInput = sc.nextInt();
            sc.nextLine();

            // add product
            if (userInput == 1) {
                //get user input on product info
                System.out.println("Create product ID (an integer)");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter product name");
                String name = sc.nextLine();
                System.out.println("Enter product description");
                String description = sc.nextLine();
                System.out.println("Enter product category");
                String category = sc.nextLine();
                System.out.println("Enter product price (to 2 decimal places)");
                double price = sc.nextDouble();
                System.out.println("Enter product quantity");
                int quantity = sc.nextInt();
                sc.nextLine();

                // add product to inventory
                addProduct(id, name, description, category, price, quantity);
            }

            // quit product management
            if (userInput == 2) {
                System.out.println("Quitting project management");
                return;
            }
        }
    }
}


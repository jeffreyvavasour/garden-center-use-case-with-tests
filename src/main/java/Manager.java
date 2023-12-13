import java.util.InputMismatchException;
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
            double price = 0;
            do {
                try {
                    // Get input
                    System.out.println("Enter new product price to 2 decimal places (eg. 2.74)");
                    price = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input");
                }
                sc.nextLine(); // clears the buffer
            } while (price < 0.01);

            currentProduct.setPrice(price);
            System.out.println("Price updated successfully!");
            System.out.println();
        }
        // edit quantity
        if (userInput2 == 5) {
            // guarantee number is a positive int
            int quantity = -1;
            do {
                try {
                    // Get input
                    System.out.println("Enter new product quantity");
                    quantity = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input");
                }
                sc.nextLine(); // clears the buffer
            } while (quantity < 0);

            currentProduct.setQuantity(quantity);
            System.out.println("Quantity updated successfully!");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "currentProduct=" + currentProduct +
                "} " + super.toString();
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
            int userInput = 0;

            // get input to edit, remove, order product or quit
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

            // user wants to edit
            if (userInput == 1) {

                boolean flag = true;
                while (flag) {
                    int userInput2 = 0;

                    // get input to edit name, desc, category, price or quantity
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
                    } while (userInput <= 0 || userInput > 6);

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
            int userInput = 0;

            // guarantee number 1 or 2 is selected
            do {
                try {
                    // Get input
                    System.out.println("Please choose a number for what to do");
                    System.out.println("1. add product");
                    System.out.println("2. quit product management");
                    userInput = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input ");
                }
                sc.nextLine(); // clears the buffer
            } while (userInput <= 0);


            // add product
            if (userInput == 1) {

                int id = 0;
                String name;
                String description;
                String category;
                double price = 0;
                int quantity = -1;

                // get user input on product info
                // product ID
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
                } while (price < 0.01);

                // quantity
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


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Manager bob = new Manager("Bob", "Doe", "0831856498", "bobdoe@gmail.com");

        bob.addProduct(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 8);
        bob.addProduct(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 8);

        // give user option to manage products until they say no to it
        boolean flag = true;
        while (flag) {

            System.out.println("Do you want to continue managing products?");
            System.out.println("1 = Yes");
            System.out.println("2 = No");
            int userInput = sc.nextInt();
            sc.nextLine();

            if (userInput == 1) {
                bob.manageProducts();
            }
            if (userInput == 2) {
                System.out.println("Goodbye");
                flag = false;
            }

        }
    }
}


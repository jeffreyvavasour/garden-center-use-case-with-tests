import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTests {

//    Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");


    @Test
    void orderIsPlaced() {

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        String expected = "You have successfully placed your order!";
        String actual = managerUnderTest.orderProduct();

        assertEquals(expected, actual);
    }

    @Test
    void productIsAdded() {

        // create manager object
        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");
        // create array
        ArrayList<Product> productArray = managerUnderTest.getProductInventory();
        // add product to array
        managerUnderTest.addProduct(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 8);
        // check if product was added
        Product productToFind = null;

        for (Product p : productArray) {
            if (Objects.equals("hose blaster 3000", p.getName())) {
                productToFind = p;
            }
        }

        assertNotNull(productToFind);
    }

    @Test
    void duplicateProductIsNotAdded() {

        // create manager object
        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");
        // create array
        ArrayList<Product> productArray = managerUnderTest.getProductInventory();
        // add product to array
        managerUnderTest.addProduct(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 8);
        // try to add same product to array
        String actual = managerUnderTest.addProduct(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 8);
        // check if product was not added
        String expected = "Product already exists";
        assertEquals(expected, actual);
    }


    @Test
    void productIsRemoved() {

        // create manager object
        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");
        // create product array
        ArrayList<Product> productArray = managerUnderTest.getProductInventory();
        // create products to be added
        Product product1 = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        Product product2 = new Product(2, "chainsaw 505", "heavy duty chainsaw", "chainsaws", 68.95, 4);
        Product product3 = new Product(3, "summer seeds", "tulip seeds for summer", "seeds", 7.95, 22);
        //add products
        productArray.add(product1);
        productArray.add(product2);
        productArray.add(product3);

        // remove product
        managerUnderTest.removeProduct(product1);
        System.out.println(productArray);
        // check if product was removed
        assertTrue(!productArray.contains(product1));
    }

    @Test
    void testCheckUserInput_validInput() {
        String input = "3\n"; // simulate user input "3"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(3, managerUnderTest.checkUserInput());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckUserInput_invalidNonIntegerInputThenValidInput() {
        String input = "invalid\n2\n"; // simulate user input "invalid" followed by "2"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(2, managerUnderTest.checkUserInput());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckUserInput_invalidOutOfRangeInputThenValidInput() {
        String input = "5\n3\n"; // simulate user input "5" followed by "3"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(3, managerUnderTest.checkUserInput());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckUserInput2_validInput() {

        // create manager object
        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        String input = "3\n"; // simulate user input "3"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(3, managerUnderTest.checkUserInput2());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckUserInput2_invalidInputFirst() {
        String input = "invalid\n5\n"; // simulate user input "invalid" followed by "5"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(5, managerUnderTest.checkUserInput2());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckUserInput2_invalidOutOfRangeInputThenValidInput() {
        String input = "0\n3\n"; // simulate user input "0" followed by "3"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(3, managerUnderTest.checkUserInput2());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckUserInputAfterNull_validInput() {
        String input = "2\n"; // simulate user input "2"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(2, managerUnderTest.checkUserInputAfterNull());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckUserInputAfterNull_invalidNonIntegerInputThenValidInput() {
        String input = "invalid\n1\n"; // simulate user input "invalid" followed by "1"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(1, managerUnderTest.checkUserInputAfterNull());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckUserInputAfterNull_invalidOutOfRangeInputThenValidInput() {
        String input = "3\n2\n"; // simulate user input "3" followed by "2"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(2, managerUnderTest.checkUserInputAfterNull());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckID_validInput() {
        String input = "123\n"; // simulate user input "123"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(123, managerUnderTest.checkID());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckID_invalidNonIntegerInputThenValidInput() {
        String input = "invalid\n456\n"; // simulate user input "invalid" followed by "456"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(456, managerUnderTest.checkID());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckID_invalidNegativeInputThenValidInput() {
        String input = "-789\n123\n"; // simulate user input "-789" followed by "123"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(123, managerUnderTest.checkID());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckPrice_validInput() {
        String input = "25.50\n"; // simulate user input "25.50"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(25.50, managerUnderTest.checkPrice(), 0.001);

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckPrice_invalidNonNumericInputThenValidInput() {
        String input = "invalid\n15.75\n"; // simulate user input "invalid" followed by "15.75"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(15.75, managerUnderTest.checkPrice(), 0.001);

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckPrice_invalidNegativeInputThenValidInput() {
        String input = "-10.25\n20.30\n"; // simulate user input "-10.25" followed by "20.30"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(20.30, managerUnderTest.checkPrice(), 0.001);

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckQuantity_validInput() {
        String input = "10\n"; // simulate user input "10"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(10, managerUnderTest.checkQuantity());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckQuantity_invalidNonNumericInputThenValidInput() {
        String input = "invalid\n8\n"; // simulate user input "invalid" followed by "8"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(8, managerUnderTest.checkQuantity());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckQuantity_invalidDoubleInputThenValidInput() {
        String input = "8.50\n8\n"; // simulate user input "8.50" followed by "8"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(8, managerUnderTest.checkQuantity());

        System.setIn(System.in); // reset System.in to its original value
    }

    @Test
    void testCheckQuantity_invalidNegativeInputThenValidInput() {
        String input = "-5\n3\n"; // simulate user input "-5" followed by "3"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Manager managerUnderTest = new Manager("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");

        assertEquals(3, managerUnderTest.checkQuantity());

        System.setIn(System.in); // reset System.in to its original value
    }
}

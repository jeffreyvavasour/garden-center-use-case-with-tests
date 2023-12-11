import org.junit.jupiter.api.Test;

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
}

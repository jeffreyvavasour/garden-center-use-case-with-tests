import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GardenCenterEmployeeTest {

    @ParameterizedTest
    @ValueSource(strings = { "chainsaw 505" })
    void productIsFound(String productName) {

        // create manager object
        GardenCenterEmployee gardenCenterEmployeeUnderTest = new GardenCenterEmployee("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");
        // create product array
        ArrayList<Product> productArray = gardenCenterEmployeeUnderTest.getProductInventory();
        // create products to be added
        Product product1 = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        Product product2 = new Product(2, "chainsaw 505", "heavy duty chainsaw", "chainsaws", 68.95, 4);
        Product product3 = new Product(3, "summer seeds", "tulip seeds for summer", "seeds", 7.95, 22);
        //add products
        productArray.add(product1);
        productArray.add(product2);
        productArray.add(product3);
        // search for product that is in array
        Product productFound = gardenCenterEmployeeUnderTest.productSearch(productName);
        // check if the product was found
        assertEquals(product2, productFound);
    }

    @ParameterizedTest
    @ValueSource(strings = { "hammer 2005" })
    void productIsNotFound(String productName) {

        // create manager object
        GardenCenterEmployee gardenCenterEmployeeUnderTest = new GardenCenterEmployee("jeff", "vava", "0831856498","jeffreyvavasour@gmail.com");
        // create product array
        ArrayList<Product> productArray = gardenCenterEmployeeUnderTest.getProductInventory();
        // create products to be added
        Product product1 = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        Product product2 = new Product(2, "chainsaw 505", "heavy duty chainsaw", "chainsaws", 68.95, 4);
        Product product3 = new Product(3, "summer seeds", "tulip seeds for summer", "seeds", 7.95, 22);
        //add products
        productArray.add(product1);
        productArray.add(product2);
        productArray.add(product3);
        // search for product that is in array
        Product productFound = gardenCenterEmployeeUnderTest.productSearch(productName);
        // check if the product was found
        assertNull(productFound);
    }
}
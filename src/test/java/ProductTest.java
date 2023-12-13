import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void testGetName() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        String expectedName = "TestName";

        // Act
        instance.setName(expectedName);
        String result = instance.getName();

        // Assert
        assertEquals(expectedName, result);
    }

    @Test
    void testSetName() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        String newName = "NewTestName";

        // Act
        instance.setName(newName);

        // Assert
        assertEquals(newName, instance.getName());
    }

    @Test
    void testGetDescription() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        String expectedDescription = "TestDescription";

        // Act
        instance.setDescription(expectedDescription);

        // Assert
        assertEquals(expectedDescription, instance.getDescription());
    }

    @Test
    void testSetDescription() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        String expectedDescription = "TestDescription";

        // Act
        instance.setDescription(expectedDescription);

        // Assert
        assertEquals(expectedDescription, instance.getDescription());
    }

    @Test
    void testGetCategory() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        String expectedCategory = "TestCategory";

        // Act
        instance.setCategory(expectedCategory);

        // Assert
        assertEquals(expectedCategory, instance.getCategory());
    }

    @Test
    void testSetCategory() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        String expectedCategory = "TestCategory";

        // Act
        instance.setCategory(expectedCategory);

        // Assert
        assertEquals(expectedCategory, instance.getCategory());
    }

    @Test
    void testGetPrice() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        double expectedPrice = 19.99;

        // Act
        instance.setPrice(expectedPrice);

        // Assert
        assertEquals(expectedPrice, instance.getPrice(), 0.001); // Use a delta for double comparison
    }

    @Test
    void testSetPrice() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        double expectedPrice = 19.99;

        // Act
        instance.setPrice(expectedPrice);

        // Assert
        assertEquals(expectedPrice, instance.getPrice(), 0.001); // Use a delta for double comparison
    }

    @Test
    void testGetQuantity() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        int expectedQuantity = 100;

        // Act
        instance.setQuantity(expectedQuantity);

        // Assert
        assertEquals(expectedQuantity, instance.getQuantity());
    }

    @Test
    void testSetQuantity() {
        // Arrange
        Product instance = new Product(1, "hose blaster 3000", "3 meter garden hose", "hoses", 25.95, 6);
        int expectedQuantity = 100;

        // Act
        instance.setQuantity(expectedQuantity);

        // Assert
        assertEquals(expectedQuantity, instance.getQuantity());
    }

}
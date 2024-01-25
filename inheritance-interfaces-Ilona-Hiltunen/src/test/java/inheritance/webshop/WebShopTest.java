package inheritance.webshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class WebShopTest {

    Vehicle fiesta = new Vehicle("My trusty old car", "Red and shiny", 700.0, "Ford", "Fiesta", 2010);
    Vehicle volvo = new Vehicle("Classic vagon", "Made in Sweden", 900.0, "Volvo", "240", 1990);
    Vehicle passat = new Vehicle("Trusty sedan", "Automatic transmission", 300.0, "Volkswagen", "Passat", 1999);

    Vehicle bicycle = new Vehicle("Bicycle", "Two wheels", 100.0, "Jopo", "Basic", 2019);

    Product coffeeMug = new Product("Coffee mug", "A mug for coffee", 5.99);
    Product tShirt = new Product("T-shirt", "A t-shirt with a logo", 19.99);

    // The object under test:
    private WebShop webShop = new WebShop();

    @Test
    void testCombineListsOfProducts() {
        List<Product> mugs = List.of(coffeeMug);
        List<Product> shirts = List.of(tShirt);
        List<Vehicle> cars = List.of(fiesta, volvo, passat);
        List<Vehicle> bikes = List.of(bicycle);

        List<Product> combined = webShop.combineListsOfProducts(mugs, shirts, cars, bikes);

        assertNotNull(combined, "null was returned");
        assertEquals(6, combined.size(), "The combined list should contain 6 products");
        assertEquals(List.of(coffeeMug, tShirt, fiesta, volvo, passat, bicycle), combined,
                "The combined list did not contain the expected products");
    }

    @Test
    void testIsVehicle() {
        // these are vehicles and should return true:
        assertTrue(webShop.isVehicle(fiesta));
        assertTrue(webShop.isVehicle(bicycle));

        // non-vehicles should return false:
        assertFalse(webShop.isVehicle(tShirt));

        // objects that are unrelated to products should return false:
        assertFalse(webShop.isVehicle("a string"));
    }

    @Test
    void testIsProduct() {
        // these are products and should return true:
        assertTrue(webShop.isProduct(coffeeMug));
        assertTrue(webShop.isProduct(tShirt));

        // these are unrelated to the Products and should return false:
        assertFalse(webShop.isProduct("a string"));
        assertFalse(webShop.isProduct(new Object()));

        // vehicles and other subclasses of Product should return false:
        assertFalse(webShop.isProduct(fiesta), "The method must only return true for Product objects");

        // the method should not be limited to current subclasses of Product:
        Product spaceship = new Spaceship("SpaceX Falcon 9", "Rocket", 62_000_000.0);
        assertFalse(webShop.isProduct(spaceship),
                "The method must only return true for Product objects, not subclasses");
    }

    /**
     * This class is used to verify that the isProduct() method is not limited to
     * the specific subclasses of Product that are defined in the exercise.
     */
    public class Spaceship extends Product {
        public Spaceship(String title, String description, double price) {
            super(title, description, price);
        }
    }
}

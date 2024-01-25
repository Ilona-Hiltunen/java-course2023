package inheritance.webshop;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class VehicleTest {

    // The object under test
    private Vehicle fiesta = new Vehicle("My trusty old car",
            "Red and shiny with little rust spots", 700.0, "Ford",
            "Fiesta", 2010);

    @Test
    void vehicleClassMustInheritProductClass() {
        assertTrue((Object) fiesta instanceof Product, "The Vehicle class must inherit the Product class");
    }

    @Test
    void methodsFromSuperClassMustReturnCorrectValues() {
        ProductTest.checkMethod(fiesta, "getTitle", "My trusty old car");
        ProductTest.checkMethod(fiesta, "getDescription", "Red and shiny with little rust spots");
        ProductTest.checkMethod(fiesta, "getPrice", 700.0);
    }

    @Test
    void manufacturerMustBePresentAndReturnTheCorrectValue() {
        ProductTest.checkMethod(fiesta, "getManufacturer", "Ford");
    }

    @Test
    void modelMustBePresentAndReturnTheCorrectValue() {
        ProductTest.checkMethod(fiesta, "getModel", "Fiesta");
    }

    @Test
    void yearMustBePresentAndReturnTheCorrectValue() {
        ProductTest.checkMethod(fiesta, "getYear", 2010);
    }

    @Test
    void toStringMustContainAllFields() {
        String str = fiesta.toString();

        assertTrue(str.contains("My trusty old car"));
        assertTrue(str.contains("Red and shiny with little rust spots"));
        assertTrue(str.contains("700"));
        assertTrue(str.contains("Ford"));
        assertTrue(str.contains("Fiesta"));
        assertTrue(str.contains("2010"));
    }
}

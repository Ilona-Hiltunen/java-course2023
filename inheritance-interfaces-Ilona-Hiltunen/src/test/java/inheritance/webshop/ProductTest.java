package inheritance.webshop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

public class ProductTest {

    // The object under test
    private final Product book = new Product("Book", "Full of exciting stories", 100.0);

    @Test
    void getTitleIsPresentAndReturnsTheTitle() throws Exception {
        checkMethod(book, "getTitle", "Book");
    }

    @Test
    void getDescriptionIsPresentAndReturnsTheDescription() throws Exception {
        checkMethod(book, "getDescription", "Full of exciting stories");
    }

    @Test
    void getPriceIsPresentAndReturnsTheDescription() throws Exception {
        checkMethod(book, "getPrice", 100.0);
    }

    @Test
    void toStringContainsAllFields() {
        String str = book.toString();

        assertTrue(str.contains("Book"));
        assertTrue(str.contains("Full of exciting stories"));
        assertTrue(str.contains("100.0"));
    }

    /**
     * This method checks that the given object has a method with the given
     * name, and that the method returns the given value.
     *
     * This approach is not typically needed in unit tests, as you almost never
     * need to check that a method exists in your own code. However, as the task
     * is to create a class with specific methods, we need some (hacky) way to
     * check that the method was created after this test was written, and that
     * it returns the correct value.
     */
    protected static void checkMethod(Object object, String methodName, Object expectedValue) {
        Optional<Method> method = ReflectionUtils.findMethod(object.getClass(), methodName);

        assertTrue(method.isPresent(),
                "The class " + object.getClass() + " does not have a " + methodName + "() method");

        try {
            assertEquals(expectedValue, method.get().invoke(object));

        } catch (IllegalAccessException | InvocationTargetException e) {
            // This could happen for example if the method is not public
            throw new RuntimeException(e);
        }
    }
}

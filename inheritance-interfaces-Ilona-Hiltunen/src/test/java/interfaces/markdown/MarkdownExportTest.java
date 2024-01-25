package interfaces.markdown;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

public class MarkdownExportTest {

    private final Pizza margherita = new Pizza("Margherita", 8.99, List.of("tomato sauce", "mozzarella", "basil"));

    @Test
    public void theInterfaceMustHaveExportMarkdownMethod() {
        assertTrue(MarkdownExport.class.isInterface(), "MarkdownExport must be an interface.");

        try {
            Method method = MarkdownExport.class.getMethod("exportMarkdown");
            Class<?> returnType = method.getReturnType();
            assertEquals(String.class, returnType, "The exportMarkdown() method must return a String.");

        } catch (NoSuchMethodException | SecurityException ex) {
            throw new RuntimeException("MarkdownExport interface must declare an exportMarkdown() method.", ex);
        }
    }

    @Test
    public void pizzaClassMustImplementMarkdownExportInterface() {
        assertTrue(margherita instanceof MarkdownExport, "Pizza class must implement MarkdownExport interface.");
    }

    @Test
    public void testExportingApizzaObjectAsMarkdown() {
        theInterfaceMustHaveExportMarkdownMethod(); // First test that the interface is correct

        String markdown = callExportMarkdown(margherita);

        assertTrue(markdown.contains("# Margherita"), "The markdown representation must contain the pizza name.");
        assertTrue(markdown.contains("mozzarella"), "The markdown representation must contain the pizza toppings.");
    }

    /*
     * Helper method for calling the exportMarkdown() method of an object.
     *
     * This method uses reflection to find the method and invoke it. This
     * approach is not typically used in unit tests, but in this exercise we need to
     * call a method that does not exist at the time of writing the tests.
     */
    protected static String callExportMarkdown(Object object) {
        Optional<Method> method = ReflectionUtils.findMethod(object.getClass(), "exportMarkdown");

        try {
            return (String) method.get().invoke(object);

        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        }
    }
}

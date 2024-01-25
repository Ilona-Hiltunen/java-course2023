package interfaces.markdown;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import inheritance.webshop.Product;

public class ProductMarkdownTest {

    private final Product coffeeMug = new Product("Coffee mug", "A mug for coffee", 5.99);

    @Test
    public void productClassMustImplementMarkdownExportInterface() {
        assertTrue(coffeeMug instanceof MarkdownExport, "Pizza class must implement MarkdownExport interface.");

        String markdown = MarkdownExportTest.callExportMarkdown(coffeeMug);

        assertTrue(markdown.contains("Coffee mug"), "The markdown representation must contain the product name.");
        assertTrue(markdown.contains("A mug for coffee"),
                "The markdown representation must contain the product description.");
    }

}

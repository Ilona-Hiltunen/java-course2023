package interfaces.markdown;

/**
 * This interface is used to add markdown export functionality to a class.
 *
 * Your taks is to declare a method called exportMarkdown() in this interface.
 * The method must return a String. Note that you are not supposed to implement
 * the method here, just declare it. Any class that implements this interface
 * will implement the method with its own implementation.
 *
 * For example, a Pizza class could later implement this interface and return a
 * markdown representation of a pizza object, for example:
 *
 *
 * # Hawaiian
 *
 * Toppings:
 * - ham
 * - pineapple
 * - mozarella
 *
 * Price: 10.90
 *
 *
 * You don't need to know Markdown syntax in this exercise. If you are
 * interested in learning Markdown, you can read more about it here:
 * https://www.markdownguide.org/
 */
public interface MarkdownExport {

    public String exportMarkdown();

}

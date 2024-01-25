package dependency_injection;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class demonstrates how to extend a class and override a method. The
 * class being extended is called PrintStream, which is a part of the Java
 * standard library. You have used the PrintStream numerous times without paying
 * too much attention to it by using the System.out object, which is an instance
 * of PrintStream. In fact, this class also uses System.out internally to print
 * data to the console.
 *
 * The PrintStream class defines methods for printing data to a stream, which
 * can be, for example, a file or the console. This subclass just uses the
 * standard output stream to make things simple.
 *
 * If you want, you can read more about the PrintStream class here:
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/PrintStream.html
 *
 * The purpose of this class is to automatically print a timestamp before the
 * actual message, so that you can see when the message was printed. This could
 * be useful in scenarios where you would want to look back at the console
 * output and see when something happened. The actual logic is implemented by
 * overriding the original println method with a new one that adds the timestamp
 * before the message.
 */
public class PrinterWithTimestamp extends PrintStream {

    /**
     * Creates a new PrinterWithTimestamp object that prints to the standard output.
     */
    public PrinterWithTimestamp() {
        /*
         * When creating instances of this class, we need to also initialize the
         * superclass by calling its constructor. The super keyword here refers to
         * the superclass, where we pass the System.out object as an argument.
         *
         * This is somewhat similar to creating an instance of the superclass with
         * new PrintStream(System.out); The created object prints its output to the
         * given PrintStream.
         */
        super(System.out);
    }

    /**
     * Prints the given message to the standard output with an added timestamp.
     */
    @Override
    public void println(String message) {
        // The timestamp is just a String formatted in the ISO date time format.
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

        // Instead of implementing the whole println method, we can just call the
        // original implementation with the super keyword. This way we don't have to
        // implement the actual printing logic ourselves, which reduces the amount of
        // code we need to write.
        super.println(timestamp + ": " + message);
    }
}

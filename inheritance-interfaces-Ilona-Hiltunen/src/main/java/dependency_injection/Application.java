package dependency_injection;

import java.io.PrintStream;
import java.util.List;

/**
 * This class is a dummy application that receives a PrintStream object in its
 * constructor. The given printStream is used to print the output of the
 * application. This class does not know where the output will be printed: it
 * could be printed to the console, to a file, or to a network socket.
 *
 * (This class also implements the Runnable interface, but that is not important
 * here.)
 */
public class Application implements Runnable {

    // The PrintStream object to which the output is printed
    private PrintStream output;

    /**
     * Creates a new Application object that prints to the given PrintStream.
     * Instead of hard-coding calls to System.out.println we want to make the
     * class more flexible. Threfore a PrintStream is added as an argument. This way
     * we can affect how the output is printed without changing the code of the
     * class.
     *
     * For example, we can pass in either the well known System.out object or
     * any other PrintStream object. In real life we could pass in a PrintStream
     * that would print the output to a file or a network socket.
     *
     * @param output the PrintStream to which the output is printed
     */
    public Application(PrintStream output) {
        this.output = output;
    }

    /**
     * Runs the application. There is nothing special here, just a simple method
     * that prints some output to the PrintStream we passed in the constructor.
     */
    @Override
    public void run() {
        output.println("Starting the application...");

        // just a dummy list to demonstrate the for-each loop
        List<String> crudOperations = List.of("create", "read", "update", "delete");

        output.println("Looping through a list...");

        for (String operation : crudOperations) {
            output.println(operation);
        }

        output.println("Closing the application...");
    }
}

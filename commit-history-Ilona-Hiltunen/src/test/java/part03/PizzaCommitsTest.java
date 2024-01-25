package part03;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaCommitsTest {

    // This multiline string contains the expected beginning of each line in the
    // sorted pizza log
    private String pizzaLog = """
            Commit 7b9f1e by PizzaLo
            Initial Commit - Pizza O
            Embarking on a cheesy jo
            Commit a3d8e7 by Topping
            Added - Pineapple Featur
            Added pineapple! For the
            Commit 4f2a1d by CheeseC
            Discussion - Cheese Dile
            Debating the most pressi
            Commit e6c5b2 by Currenc
            Added - Multi-Currency M
            Implemented currency con
            Commit 1d9g4z by Interop
            Fix IDE Compatibility Is
            VS Code and Eclipse foug
            Commit 8h5k2y by ToolTro
            Fix Tool Compatibility I
            Updated tools, they're n
            Commit m3n5p8 by JavaVer
            Fixed Java Compatibility
            Java 17 finally made pea
            Commit x1y2z3 by CheeseC
            Merge branch 'cheese-deb
            Merging the never-ending
            Commit r4s5t6 by Topping
            Fix Bug - Pineapple Limi
            Capped pineapple topping
            Commit k7l8m9 by Workflo
            Fix GitHub Actions - Act
            Rescued the failing GitH
            Commit o1p2q3 by Currenc
            Discussion - Bitcoin Pay
            Exploring Bitcoin paymen
            Commit t4u5v6 by MSWordM
            Fix Code Edit - MS Word
            Discovered someone edite
            Commit z9a8b7 by ToolTro
            Fix Tool Compatibility -
            Dependencies danced into
            Commit y6x7w8 by JavaVer
            Discussion - Java 21: Ne
            Java 21 brings new featu
            Commit s5r4t3 by CheeseC
            Merge branch 'bitcoin-pa
            Merging Bitcoin payment
            Commit d2e3f4 by FinalFi
            Final Commit - Pizza Per
            Last-minute code cleanup
            Commit b1c2d3 by PostLau
            Post-Launch Fixes - Hand
            Post-launch chaos! Scali
            Commit h7j8k9 by Celebra
            Celebration Time - Pizza
            Celebrating the successf
            Commit i4l5m6 by Feedbac
            Added - Customer Feedbac
            Implementing a feedback
            Commit n3o4p5 by Improve
            Improvements - Optimizin
            Optimizing delivery rout
            Commit w7e8r9 by Experim
            Discussion - Pizza Toppi
            Experimenting with new t
            Commit q1s2w3 by BugBust
            Fix Bug - Address Valida
            Found and fixed an addre
            Commit f5g6h7 by Expansi
            Expansion Plans - Scalin
            Planning for global pizz
            Commit u7v8w9 by Creativ
            Added - Pizza Customizat
            Allowing customers to de
            Commit r3f4g5 by SpeedyS
            Optimization - Turbochar
            Optimizing the ordering
            Commit o1l2m3 by Innovat
            Discussion - Drone Deliv
            Dreaming of drone-delive
            Commit v4w5x6 by Continu
            Continuous Improvements
            Constantly improving - t
            Commit z1x2c3 by TeamLea
            Update - One Year Annive
            Celebrating one year of
            Commit k9i8j7 by Visiona
            Vision Meeting - The Fut
            Dreaming big for the fut
            Commit b4n5m6 by EverEvo
            Evolution - Pizza, Tech,
            Evolving our pizza platf
            Commit l3e4h5 by PizzaLo
            Pizza Perfection & Beyon
            Continuing the quest for
            """;

    // To test the output of the main method, we need to capture the output stream
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /*
     * Before each test, we set the output stream to our own stream captor. After
     * each test, we set the output stream back to the original output stream.
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * This test checks that the commits from the pizza log are printed in the
     * expected order.
     *
     * Typically in unit tests, we would not test the output of the main method.
     * However, in this case, we wanted to give you the opportunity to implement the
     * logic with any classes and methods you want, so writing tests for those
     * beforehand would not be possible.
     */
    @Test
    void commitsFromPizzaLogArePrintedInCorrectOrder() throws IOException {
        // run the main method that should read the pizza log and print the commits in
        // the correct order. The method itself should not return anything.
        Main.main(new String[] {});

        // now the output stream captor should have the output from the main method
        String output = outputStreamCaptor.toString();

        // split the pizza log into lines and check that each line is in the output
        // and that the lines are in the correct order
        List<String> expectedLines = pizzaLog.lines().toList();

        for (int i = 0; i < expectedLines.size() - 1; i++) {
            String current = expectedLines.get(i);
            String next = expectedLines.get(i + 1);

            assertTrue(output.contains(current), "output should contain the line starting with: " + current);
            assertTrue(output.contains(next), "output should contain the line starting with: " + next);

            assertTrue(output.indexOf(current) < output.indexOf(next),
                    "Line '%s' should be before line '%s' in the output".formatted(current, next));
        }
    }
}

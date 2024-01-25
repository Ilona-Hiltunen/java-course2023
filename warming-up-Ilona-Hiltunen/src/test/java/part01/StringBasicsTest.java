package part01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringBasicsTest {

    // The object we are testing
    private StringBasics solution = new StringBasics();

    @Test
    void testTruncate() {
        assertEquals("He", solution.truncate("Hello", 2),
                "Text should be truncated to 2 characters");

        assertEquals("Hello", solution.truncate("Hello", 5),
                "Text is not truncated when length is equal to the text length");

        assertEquals("Hello", solution.truncate("Hello", 10),
                "Text is not truncated when length is greater than the text length");
    }

    @Test
    void testParseYesOrNo() {
        // Test that the method returns true for all variations of "yes"
        assertTrue(solution.parseYesOrNo("yes"), "yes in lower case");
        assertTrue(solution.parseYesOrNo("YES"), "yes in upper case");
        assertTrue(solution.parseYesOrNo("Yes"), "yes with first letter in upper case");

        // Test that the method returns false for all variations of "no"
        assertFalse(solution.parseYesOrNo("no"), "no in lower case");
        assertFalse(solution.parseYesOrNo("NO"), "no in upper case");
        assertFalse(solution.parseYesOrNo("No"), "no with first letter in upper case");
    }

    @Test
    void testGetFizzBuzz() {
        // Test that the method returns Fizz for all numbers divisible by 3
        assertEqualsIgnoreCase("Fizz", solution.getFizzBuzz(3));
        assertEqualsIgnoreCase("Fizz", solution.getFizzBuzz(6));
        assertEqualsIgnoreCase("Fizz", solution.getFizzBuzz(9));
        assertEqualsIgnoreCase("Fizz", solution.getFizzBuzz(12));

        // Test that the method returns Buzz for all numbers divisible by 5
        assertEqualsIgnoreCase("Buzz", solution.getFizzBuzz(5));
        assertEqualsIgnoreCase("Buzz", solution.getFizzBuzz(10));

        // Test that the method returns FizzBuzz for all numbers divisible by 3 and 5
        assertEqualsIgnoreCase("FizzBuzz", solution.getFizzBuzz(15));

        // Test that the method returns the number as a string for all other numbers
        assertEqualsIgnoreCase("1", solution.getFizzBuzz(1));
        assertEqualsIgnoreCase("2", solution.getFizzBuzz(2));
        assertEqualsIgnoreCase("4", solution.getFizzBuzz(4));
        assertEqualsIgnoreCase("7", solution.getFizzBuzz(7));
        assertEqualsIgnoreCase("8", solution.getFizzBuzz(8));
        assertEqualsIgnoreCase("11", solution.getFizzBuzz(11));
        assertEqualsIgnoreCase("13", solution.getFizzBuzz(13));
        assertEqualsIgnoreCase("14", solution.getFizzBuzz(14));

        // Finally, test that the method can handle large numbers
        assertEqualsIgnoreCase("FizzBuzz", solution.getFizzBuzz(1_500_000_000));
    }

    /**
     * This method is a helper method to compare two strings ignoring case.
     */
    private void assertEqualsIgnoreCase(String expected, String actual) {
        assertNotNull(expected, "Expected " + expected + " but was null");

        assertEquals(expected.toLowerCase(), actual.toLowerCase());
    }
}

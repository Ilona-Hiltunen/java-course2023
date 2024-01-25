package part01;

/**
 * The class contains empty methods and methods with known issues that need to
 * be fixed.
 *
 * Your task is to implement the empty methods and fix the methods with issues.
 * Use the JUnit test provided to verify that your implementation works as
 * expected. You can also write a main method to test your implementations.
 *
 * Do not change the signatures of the methods already provided. However, you
 * are free to add new methods.
 */
public class StringBasics {

    /**
     * Truncates a text to a given maximum length. If the text is longer than the
     * maximum length, the text is cut to the maximum length. If the text is shorter
     * or equal to the maximum length, the text is returned as is.
     *
     * @param text      The input text to be truncated.
     * @param maxLength The maximum length of the text.
     * @return The truncated text.
     */
    public String truncate(String text, int maxLength) {
        // TODO: Fix this method

        if (text.length() > maxLength) {
           return text.substring(0, maxLength);
        } else {
        return text;
        }
    }

    /**
     * Parses a text and returns `true` if it matches the string "yes"
     * (case-insensitive). All other inputs return `false`.
     *
     * @param text The input text to be parsed.
     * @return `true` if the text is "yes" (case-insensitive), otherwise `false`
     */
    public boolean parseYesOrNo(String text) {
        // FIXME: this seems to always return false, even when the `text` is "yes"

        if (text.equalsIgnoreCase("yes")) {
            return true;
        } else {
        return false;
        }
    }

    /**
     * Returns the FizzBuzz result for a given number.
     *
     * If the number is divisible by three, the result is "fizz." If the number is
     * divisible by five, the result is "buzz." If the number is divisible by both
     * three and five, the result is "fizzbuzz." Otherwise, the result is the number
     * as a string.
     *
     * See more at https://en.wikipedia.org/wiki/Fizz_buzz
     *
     * @param number The input number to be evaluated.
     * @return "fizz", "buzz", "fizzbuzz" or the given number as a string.
     */
    public String getFizzBuzz(int number) {

        if (number % 3 == 0 && number % 5 == 0) {
        return "fizzbuzz";
        } else if (number % 3 == 0) {
        return "fizz";
        } else if (number % 5 == 0) {
        return "buzz";
        } else {
        return Integer.toString(number);
        }

    }
}

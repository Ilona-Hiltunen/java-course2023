package part02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class OptionalValuesTest {

    // the object to be tested
    private OptionalValues solution = new OptionalValues();

    @Test
    void testAverage() {
        IntStream numbers = IntStream.of(20, 0, 20, 0);

        assertEquals(10, solution.average(numbers));
    }

    @Test
    void testAverageForEmptyStream() {
        IntStream empty = IntStream.empty();

        assertEquals(0, solution.average(empty));
    }

    @Test
    void testMaximum() {
        IntStream numbers = IntStream.of(-20, 20, 0, 20, 0);

        assertEquals(20, solution.maximum(numbers));
    }

    @Test
    void testMaximumForEmptyStream() {
        IntStream empty = IntStream.empty();

        assertEquals(0, solution.maximum(empty));
    }

    /*
     * Why do programmers prefer dark mode?
     *
     * Because light attracts bugs!
     *
     * This joke was generated by ChatGPT 3.5
     */
}

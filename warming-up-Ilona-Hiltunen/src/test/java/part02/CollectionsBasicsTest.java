package part02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CollectionsBasicsTest {

    private CollectionsBasics solution = new CollectionsBasics();

    @Test
    void testMaximum() {
        List<Integer> numbers = List.of(1, 2, 300, 4, 5);

        assertEquals(300, solution.maximum(numbers));
    }

    @Test
    void testSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertEquals(15, solution.sum(numbers));
    }

    @Test
    void testConcatenateFooBarBaz() {
        String result = solution.concatenateStrings(List.of("foo", "bar", "baz"));

        assertEquals("foobarbaz", result);
    }

    @Test
    void testConcatenateProgrammingLanguages() {
        String result = solution.concatenateStrings(List.of("Java", "Python", "TypeScript"));

        assertEquals("JavaPythonTypeScript", result);
    }

    @Test
    void testGetLengthsOfProgrammingLanguages() {
        List<String> strings = List.of("Java", "Python", "TypeScript");

        assertEquals(List.of(4, 6, 10), solution.getLengths(strings));
    }

    @Test
    void testGetLengthsOfTools() {
        List<String> strings = List.of("VS Code", "Eclipse", "Git", "Gradle", "JUnit");

        assertEquals(List.of(7, 7, 3, 6, 5), solution.getLengths(strings));
    }
}

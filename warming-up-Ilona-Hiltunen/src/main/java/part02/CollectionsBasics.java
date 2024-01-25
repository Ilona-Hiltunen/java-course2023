package part02;

import java.util.ArrayList;
import java.util.List;

/**
 * Your task is to implement the methods in this class. Use the JUnit test
 * provided to verify that your implementation works as expected. You can also
 * write a main method to test your implementations.
 *
 * Do not change the signatures of the methods already provided. However, you
 * are free to add new methods.
 */
public class CollectionsBasics {

    /**
     * Finds the maximum value in a list of integers. You can assume that the list
     * is not empty.
     *
     * @param numbers The list of integers.
     * @return The maximum value in the list.
     */
    public int maximum(List<Integer> numbers) {
        int suurin = 0;
        
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > suurin) {
            suurin = numbers.get(i);
            }
        }
        return suurin;
    }

    /**
     * Calculates the sum of all integers in a list.
     *
     * @param numbers The list of integers.
     * @return The sum of all integers in the list.
     */
    public int sum(List<Integer> numbers) {
        int summa = 0;
        
        for (int i = 0; i < numbers.size(); i++) {
        summa += numbers.get(i);
        }

        return summa;
    }

    /**
     * Concatenates (or joins) a list of strings into a single string.
     * For example, if the list contains the strings "foo", "bar" and "baz",
     * the result is "foobarbaz". You can assume that the list is not empty.
     *
     * @param strings The list of strings.
     * @return The concatenated string.
     */
    public String concatenateStrings(List<String> strings) {
        String sana = "";
        
        for (int i = 0; i < strings.size(); i++) {
        sana += strings.get(i);
        }
        return sana;
    }

    /**
     * Returns the lengths of the strings in the input list.
     * For example, if the input list contains the strings "Java", "Python" and
     * "TypeScript", the result is a list containing the numbers 4, 6 and 10.
     *
     * @param strings The list of strings.
     * @return A list containing the lengths of the strings in the input list.
     */
    public List<Integer> getLengths(List<String> strings) {

        List<Integer> lista = new ArrayList<Integer>();

        for (int i = 0; i < strings.size(); i++) {
        lista.add(strings.get(i).length());
        }

        return lista; 
    }
}

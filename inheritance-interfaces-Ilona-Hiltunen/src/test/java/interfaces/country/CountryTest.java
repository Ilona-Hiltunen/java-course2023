package interfaces.country;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CountryTest {

    // https://en.wikipedia.org/wiki/Nordic_countries, 9.8.2023
    private Country den = new Country("Denmark", 5_894_687);
    private Country fin = new Country("Finland", 5_587_442);
    private Country ice = new Country("Iceland", 354_234);
    private Country nor = new Country("Norway", 5_509_591);
    private Country swe = new Country("Sweden", 10_261_767);

    @Test
    void countryClassImplementsComparable() {
        assertTrue(den instanceof Comparable, "The Country class should implement the Comparable interface");
    }

    @Test
    void countriesAreSortedInCorrectOrder() {
        this.countryClassImplementsComparable(); // fail if not implemented

        List<Country> countries = Arrays.asList(den, fin, ice, nor, swe);
        countries.sort(null);

        assertEquals(List.of(ice, nor, fin, den, swe), countries);
    }
}

package part03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class PostalCodesTest {

    @Test
    void testReadPostalCodes() {
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();

        assertEquals("HELSINKI", postalCodes.get("00100"));
        assertEquals("KORVATUNTURI", postalCodes.get("99999"));
    }

    @Test
    void testReadingPostalCodesWithSpecialCharacters() {
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();

        assertEquals("PÖLJÄ", postalCodes.get("71820"));
    }
}

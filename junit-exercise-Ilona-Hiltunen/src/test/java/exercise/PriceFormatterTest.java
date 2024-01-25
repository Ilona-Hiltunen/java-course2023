package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import price.formatter.PriceFormatter;

/**
 * Write your tests for the PriceFormatter here. See the specification of the
 * PriceFormatter and formatPrice method in the PriceFormatter class.
 */
public class PriceFormatterTest {
    private PriceFormatter priceformatter;

    @BeforeEach
    void setUp() {
        priceformatter = new PriceFormatter();
    }

    @AfterEach
    void tearDown () {
        priceformatter = null;
    }

    @Test
    void testThousands () {
        assertEquals("1 000 €", priceformatter.formatPrice(1000));
        assertEquals("999 €", priceformatter.formatPrice(999));
        assertEquals("1 000 000 000 €", priceformatter.formatPrice(1000000000));
    }

    @Test
    void testComma () {
        assertEquals("2,50 €", priceformatter.formatPrice(2.50));
        assertEquals("0,01 €", priceformatter.formatPrice(0.01));
        assertEquals(',', priceformatter.formatPrice((int)((Math.random() * 90) + 1) / 10.1).charAt(1));
    }

    @Test
    void testDecimals () {
        assertEquals("7,54 €", priceformatter.formatPrice(7.54));
        assertEquals("8,55 €", priceformatter.formatPrice(8.54999999));
        assertEquals("6 €", priceformatter.formatPrice(6.0001));
        assertEquals("1 €", priceformatter.formatPrice(0.999999));
        assertEquals("0,99 €", priceformatter.formatPrice(0.989999));
        assertEquals("1 001,10 €", priceformatter.formatPrice(1001.0999999));
    }

    @Test
    void test€ () {
        assertEquals("1 €", priceformatter.formatPrice(1.00));
        assertEquals(" €", priceformatter.formatPrice((int)((Math.random()*9) + 1)).substring(1,3));
        assertEquals('€', priceformatter.formatPrice(2.56).charAt(5));
        assertEquals('€', priceformatter.formatPrice(1000000).charAt(10));
    }


    
    }


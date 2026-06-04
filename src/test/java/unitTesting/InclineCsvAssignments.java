package unitTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InclineCsvAssignments {

    // Case 37: Test simple addition rules via columns matching: integerA, integerB, expectedSum
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "10, 20, 30",
            "-5, 5, 0"
    })
    public void testAddCalculations(int a, int b, int expected){
        int sumTwoValues = a + b;
        assertEquals(expected, sumTwoValues);
    }

    // Case 38: Verify string concatenation using inline values matching: stringFirst, stringSecond, expectedJoinedResult
    @ParameterizedTest
    @CsvSource({
            "bana, na, banana",
            "recepTayyip, Erdogan, recepTayyipErdogan",
            "ekrem, Imamoglu, ekremImamoglu"
    })
    public void testStringJoins(String first, String second, String expected){
        String concatenated = first + second;
        assertEquals(expected, concatenated);
    }

    // Case 39: Map product price multipliers to evaluate net calculations: baseCost, taxMultiplier, expectedNetInvoicePrices
    @ParameterizedTest
    @CsvSource({
            "100, 10, 110",
            "100, 22, 122",
            "100, 15, 115"
    })
    public void testTaxCalculations(double base, double tax, double expectedNet){
        double taxApplied = base + (base * (tax / 100));
        assertEquals(expectedNet, taxApplied);
    }

    // Case 40: Evaluate logic credentials configurations mappings matching: rawUserString, expectedSubStringTruncation
    @ParameterizedTest
    @CsvSource({
            "Administrator, Admin",
            "Developer, Devel",
            "GuestUser, Guest"
    })
    // TODO: Provide CsvSource configurations mapping partial user string expectations
    public void testSubstringEvaluations(String raw, String expectedSub) {
       boolean configuration = raw.contains(expectedSub);
       assertTrue(configuration, "Configuration must contain the related substring.");
    }
}

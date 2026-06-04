package propertyBasedTesting;

import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomGeneratorAssignments {

    // Case 22: Create an Arbitrary providing odd numbers only. Prove (odd % 2 != 0).
    @Property
    void testOddNumbersOnly(@ForAll("oddNumberFactory") int odd){
        assertTrue(odd % 2 != 0, "The values must be odd not even values.");
    }

    @Provide
    Arbitrary<Integer> oddNumberFactory(){
        return Arbitraries.integers().filter(
                a -> a % 2 != 0
        );
    }
    // Case 23: Create an Arbitrary providing custom alphabetic words of exactly length 5.
    @Property
    void testFiveLetterWords(@ForAll("fiveLetterWordFactory") String word){
        assertTrue(word.length() == 5, "Words must contain five letters only.");
    }

    @Provide
    Arbitrary<String> fiveLetterWordFactory() {
        return Arbitraries.strings().ofLength(5);
    }

    // Case 24: Generate random valid prices that have exactly two decimal precision places.
    @Property
    void testMonetaryPrices(@ForAll("monetaryFactory") double price) {
            assertTrue(price >= 0.0, "Monetary values must remain positive.");
    }

    @Provide
    Arbitrary<Double> monetaryFactory(){
        return Arbitraries.doubles().
                between(0.0, 1000.0).
                ofScale(2);
    }
    // Case 25: Provide alphanumeric characters excluding special punctuation markers.
    @Property
    void testNoSpecialChars(@ForAll("alphanumericFactory") char character) {
        assertTrue(Character.isLetterOrDigit(character), "The generated character must be a letter or digit primitive.");
    }

    @Provide
    Arbitrary<Character> alphanumericFactory() {
        return Arbitraries.chars().alpha().numeric();
    }
}

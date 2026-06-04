package unitTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValueSourceAssignments {


    // Case 32: Test that all provided strings ("apple", "banana", "cherry") have a length greater than 3
    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana","cherry"})
    public void testStringLengths(String element){
        int wordLength = element.length();
        assertTrue(3 < wordLength);
    }
    // Case 33: Test that all provided integer values (10, 50, 100) are greater than 5
    @ParameterizedTest
    @ValueSource(ints = {10, 50, 100})
    public void testIntegerBoundaries(int val){
        assertTrue(5 < val);
    }
    // Case 34: Test that all provided string arrays contain characters matching an '@' domain prefix pattern
    @ParameterizedTest
    @ValueSource(strings = {"abc@hotmail.com","abc@gmail.com", "abc@outlook.com"})
    public void testEmailFormatting(String email){
        assertTrue(email.contains("@"), "An email must contain related symbol '@'.");
    }


    // Case 35: Test that double point numeric primitives (1.5, 2.75, 3.125) match positive numeric invariants
    @ParameterizedTest
    @ValueSource(doubles = {1.5, 2.75, 3.125})
    public void testPositiveDoubles(double precisionVal){
        assertTrue(0 < precisionVal);
    }

}

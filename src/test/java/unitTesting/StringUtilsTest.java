package unitTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {


    //String vs StringBuilder vs StringBuffer differences
    //Strings are immuteable which means that they're cannot be changed after declared.
    // However, StringBuffer and StringBuilder are muteable. StringBuilder causes thread-loss but faster,
    // StringBuffer has thread-safety but slower( They can be compared like TCP / UDP in networking)
    @Test
    public void testIsPalindrome(){
        String input = "radar";
        boolean result = input.equals(new StringBuilder(input).reverse().toString());
        assertTrue(result, "The string should be equal to its reverse.");
    }

    @Test
    @DisplayName("String /= StringBuilder or StringBuffer")
    public void testIsPalindrome_String_and_StringBuffer_areNotTheSame(){
        String input = "slals";
        boolean result = input.equals(new StringBuilder(input).reverse());
        assertFalse(result, input);
    }
}

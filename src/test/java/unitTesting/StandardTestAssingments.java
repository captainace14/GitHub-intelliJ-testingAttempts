package unitTesting;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardTestAssingments {
    // Case 2: Verify that an array sorting method correctly sorts [3, 1, 2] to [1, 2, 3]
    @Test
    public void testArraySorting(){
        int[] array = {3, 1, 2};
        int[] sorted = {1, 2, 3};

        Arrays.sort(array);


        assertArrayEquals(sorted, array, "The array elements must be sorted in ascending order.");

    }
    // Case 3: Verify that a basic Math.pow(2, 3) yields exactly 8.0
    @Test
    public void testPowerCalculation(){
        double powerTest = Math.pow(2, 3);
        assertEquals(8.0, powerTest);
    }
    // Case 4: Verify that a list contains an expected element after adding it
    @Test
    public void testListElementPresence(){
        List<String> frameworkList = new ArrayList<>();
        frameworkList.add("JUnit-5");

        assertTrue(frameworkList.contains("JUnit-5"), "The framework list must contain the JUnit-5 version.");

    }
    // Case 5: Verify that a system property flag string conversion works correctly
    @Test
    public void testBooleanParsing(){
        String inputFlag = "true";

        boolean parsedValue = Boolean.parseBoolean(inputFlag);
        assertTrue(parsedValue, "The string 'true' must successfully parse into a boolean.");
    }

}

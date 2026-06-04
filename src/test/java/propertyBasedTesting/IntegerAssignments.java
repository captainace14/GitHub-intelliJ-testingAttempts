package propertyBasedTesting;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Fun Fact: We can see in our compiler that we shouldn't be using jqwik with AI or AI Agent. why?
public class IntegerAssignments {

    // Case 2: Prove that any integer multiplied by zero always yields zero.

    @Property
    void testMultiplicationByZero(@ForAll int x){
        final int result = 0;
        assertEquals(result, x * 0);
    }
    // Case 3: Prove that the square of any integer is always greater than or equal to zero.
        //Why we are getting errors without specifying as long ?
        @Property
        void testSquareIsPositive(@ForAll int x){
            //why we are getting an error with Math function?
            //double squareTest = Math.sqrt(x);
            long squareSample = (long)x * (long)x;
            assertTrue(0 <= squareSample, "The square of an integer cannot be negative.");
        }

    // Case 4: Prove that for any two positive integers (a, b > 0), their product is >= both numbers.
    @Property
    void testProductOfPositiveIntegers(
            @ForAll @net.jqwik.api.constraints.IntRange(min = 1, max = 10000) int a,
            @ForAll @net.jqwik.api.constraints.IntRange(min = 1, max = 10000) int b
    ){
        long product = (long) a * (long) b;
        assertTrue(product >= a, "The product is greater than the a.");
        assertTrue(product >= b, "The product is greater than the b.");
    }
    // Case 5: Prove that an integer subtracted from itself always equals zero.
    @Property
    void testSelfSubtraction(@ForAll int x){
        long subtractedResult = (long) x - (long) x;
        assertTrue(subtractedResult == 0, "The subtracted value by itself must be equal to zero." );
    }
}

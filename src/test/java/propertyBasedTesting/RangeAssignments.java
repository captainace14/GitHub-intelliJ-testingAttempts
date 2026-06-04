package propertyBasedTesting;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RangeAssignments {

    // Case 17: Constrain a double between 0.0 and 1.0. Prove that multiplying it by itself yields a value <= original.
    @Property
    void testFractionalMultiplication(@ForAll @DoubleRange(min = 0.0, max = 1.0) double fraction) {
        double multipliedValue = fraction * fraction;
        assertTrue(multipliedValue <= fraction, "Multiplying a fraction by itself must yiled a smaller or equal scalar value.");
    }

    // Case 18: Constrain an integer to positive values (1 to 10000). Prove that x + 1 is strictly > x.
    @Property
    void testStrictIncrement(@ForAll @IntRange(min = 1, max = 10000) int x){
        int incrementedByOne = x + 1;
        assertTrue(x < incrementedByOne, "The value of x + 1 is always greater than the x.");
    }

    // Case 19: Constrain a month index integer between 1 and 12. Prove it can map to valid seasonal representations.
    @Property
    void testValidMonths(@ForAll @IntRange(min = 1, max = 12) int month) {
        assertTrue(month > 0 && month <= 12, "The generated month index must strictly respect calendar.");
    }

    // Case 20: Constrain an angle value from 0.0 to 360.0 degrees. Prove conversion to radians remains bounded.
    @Property
    void testDegreesToRadians(@ForAll @DoubleRange(min = 0.0, max = 360.0) double degrees) {
        double radians = Math.toRadians(degrees);
        assertTrue(radians >= 0.0 && radians <= (2 * Math.PI) + 0.001, "The degree must satisfy the related satisfactions of trigonometry rules." );
    }
}

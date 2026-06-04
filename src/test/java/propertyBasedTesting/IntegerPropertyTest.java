package propertyBasedTesting;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertTrue;

//My Question: Why did we get an error without specifying the a and b as (long)

public class IntegerPropertyTest {

    @Property
    void testTriangleInequalityRule(@ForAll int a, @ForAll int b){
        // Absolute sum rule: |a + b| <= |a| + |b|
        long absoluteSum = Math.abs((long)a + (long)b);
        long sumOfAbsolutes = Math.abs((long)a) + Math.abs((long)b);
        assertTrue(absoluteSum <= sumOfAbsolutes, "The absoulte sum must be <= the sum of absolutes.");
    }
}

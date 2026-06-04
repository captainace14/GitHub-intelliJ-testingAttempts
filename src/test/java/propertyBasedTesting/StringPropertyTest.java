package propertyBasedTesting;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringPropertyTest {

    @Property
    void testConcatLengthIsSumOfLengths(@ForAll String s1, @ForAll String s2){
        String combined = s1 + s2;
        assertEquals(s1.length() + s2.length(), combined.length());
    }
}

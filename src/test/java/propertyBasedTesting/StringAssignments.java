package propertyBasedTesting;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringAssignments {

    // Case 7: Prove that converting a string to uppercase twice equals converting it once.

    //Why we are getting an error for this code-block?
//    @Property
//    void testIdempotentUpperCase(@ForAll String s){
 //       boolean condition = s.toUpperCase() == s.toUpperCase().toUpperCase();
//        assertTrue(condition, "Uppercase method malfunctioning..");
  //  }

    @Property
    void testIdempotentUpperCase(@ForAll String s){
        String once = s.toUpperCase();
        String twice = s.toUpperCase().toUpperCase();
        assertEquals(once, twice, "Upper-caseing an alread upper-cased should not be changed.");
    }

    // Case 8: Prove that any string always contains itself as a substring.
    @Property
    void testContainsSelf(@ForAll String s){
        assertTrue(s.contains(s), "A string must always report that it contains itself.");
    }

    // Case 9: Prove that if a string starts with a prefix, appending data to the end doesn't change that prefix.
    @Property
    void testPrefixStability(@ForAll String s, @ForAll String suffix){
        String combinedSubject = suffix + s;
        assertTrue(combinedSubject.contains(suffix), "Appending a suffix must not invalidate the original prefix match.");
        assertTrue(combinedSubject.startsWith(suffix));
    }
    // Case 10: Prove that an empty string appended to any string results in an identical string string reference.
    @Property
    void testEmptyStringIdentity(@ForAll String s){
       String combined = s + "";
       assertTrue(s.equals(combined), "Appending an empty string must retain structural equivalence.");
       assertEquals(s, combined, "Appending an empty string must retain structural equivalence.");
    }

}

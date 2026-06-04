package propertyBasedTesting;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionAssignments {

    // Case 12: Prove that clearing a list always reduces its size metric to exactly 0.
    @Property
    void testClearListSize(@ForAll List<String> list){
        list.clear();
        assertEquals(0, list.size(), "A cleared list must have a size of zero.");
    }

    // Case 13: Prove that adding an element to a collection increases its size by exactly 1.
    @Property
    void testAddElementIncreasesSize(@ForAll List<Double> list, @ForAll double value){
        /*
        list.clear();   //my Q: do List objects contain one item as default generated? It gives an error without clearing the list from the beginning with size of 2
        list.add(value);
        assertEquals(1, list.size());*/

        int previousSize = list.size();
        list.add(value);
        assertEquals(previousSize + 1, list.size(), "Adding an item must increment the collection size by one.");

    }


    // Case 14: Prove that a list reverse operation preserves original sizes precisely.
    @Property
    void testReversePreservesSize(@ForAll List<Integer> list){
        List<Integer> reverseList = list.reversed();
        assertTrue(reverseList.size() == list.size(), "Reversing a list must never alter its total size.");
    }

    // Case 15: Prove that an element retrieved from a list via a valid index is contained within that list.
    @Property
    void testGetElementIsContained(@ForAll List<Character> list){
        if(!list.isEmpty() ){
            char subjectCharacter = list.get(0);
            assertTrue(list.contains(subjectCharacter));

        }
    }

}

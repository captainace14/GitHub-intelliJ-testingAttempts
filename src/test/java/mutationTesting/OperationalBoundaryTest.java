package mutationTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationalBoundaryTest {

    //Busines rule: drivers smust be strictly older then 17 (18 or above)
    public boolean canDrive(int age){
        return age > 17;
    }


    @Test
    void killBoundaryOperatorsMutation(){
        // If a mutator alters "age > 17" to "age >= 17", age 17 would return true.
        // We explicitly test 17 to kill that mutation!
        assertTrue(canDrive(18), "18 is allowed to drive");
        assertFalse(canDrive(17), "17 cannot be allowed to drive");
    }

}

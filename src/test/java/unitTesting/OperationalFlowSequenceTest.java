package unitTesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OperationalFlowSequenceTest {

    private int sharedSystemSequenceState = 0;

    @Test
    @Order(1)
    public void testStepOneInitialize(){
        sharedSystemSequenceState = 5000;
        assertEquals(5000, sharedSystemSequenceState);
    }

    @Test
    @Order(2)
    public void testStepTwoVerifyLeakedState(){
        //Confirms step sequence runs precisely as requested.
        //If our method orderer was creating test objects per method, it will generate
        // independent objects per methods in our test suite which would cause an error
        assertEquals(5000, sharedSystemSequenceState);
    }
}

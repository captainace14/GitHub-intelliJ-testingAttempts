package unitTesting;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// My Question: Without specifying our method orderer, even its lifecycle per class,
// our operationCounter after the test of the testStateMutation value as 10. Why??


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InstanceLifecycleAssignments {
    private int operationCounter = 0;

    @BeforeAll
    public void setup(){
        operationCounter = 10;
    }
    @Test
    @Order(1)
    public void testInitialState(){
        int wantedStartingPoint = 10;
        assertEquals(wantedStartingPoint, operationCounter);
    }

    @Test
    @Order(2)
    public void testStateMutation(){
        operationCounter += 5;
        int presentValue = 15;
        assertEquals(presentValue, operationCounter);
    }

    @Test
    @Order(3)
    public void testLeakedStateVerification(){
        int leakedPresentValue = 15;
        assertEquals(leakedPresentValue, operationCounter);
    }

    @Test
    @Order(4)
    public void testManualReset(){
        operationCounter = 0;
        assertEquals(0, operationCounter);
    }
}

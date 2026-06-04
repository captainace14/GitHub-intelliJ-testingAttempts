package unitTesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathReportingTest {
    @Test
    @DisplayName("When dividing 10 by 2, the result must precisely evaluate to 5")
    public void testDivision(){
        assertEquals(5, 10 / 2);
    }
}

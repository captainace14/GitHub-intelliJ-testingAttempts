package unitTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberValidationTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 16, 32, 104})
    public void testIsEvenNumber(int candidateNumber){
        assertEquals(0, candidateNumber % 2, "Number parameter must yield a zero remainder against modulo two.");
    }
}

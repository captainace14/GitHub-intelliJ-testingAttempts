package unitTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaseConversionTest {
    @ParameterizedTest
    @CsvSource({
            "hello, HELLO",
            "world, WORLD",
            "java, JAVA"
    })
    public void testToUpperCaseTransforms(String technicalInput, String expectedTargetOutput){
        assertEquals(expectedTargetOutput, technicalInput.toUpperCase());
    }
}

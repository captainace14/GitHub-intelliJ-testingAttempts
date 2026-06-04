package unitTesting;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileSystemDriverTest {
    private boolean isDriverMounted = false;


    @BeforeAll
    public void mountDriverInstance(){
        isDriverMounted = true;
    }

    @Test
    public void testDriverState(){
        assertTrue(isDriverMounted);
    }


}

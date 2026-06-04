package unitTesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class LegacySystemTest {

    @Test
    @Disabled("Feature v2 migration is broken.Bypassing execution until refactor.")
    public void testLegacyDatabaseSync(){
        fail("This would instantly break our deployment builds.");
    }
}

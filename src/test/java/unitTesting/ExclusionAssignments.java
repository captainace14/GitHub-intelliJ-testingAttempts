package unitTesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ExclusionAssignments {
    // Case 22: Disable this test using an explanation regarding missing access tokens
    @Disabled("Missing access tokens.")
    @Test
    public void testCloudUpload() {
        fail("Fails due to 401 Unauthorized exceptions.");
    }

    // Case 23: Disable this test using an explanation concerning flaky environments
    @Disabled("Concerning flaky environments.")
    @Test
    public void testFlakyHardwarePing() {
        fail("Fails intermittently on continuous integration pipelines.");
    }

    // Case 24: Disable this test with an explanation about deprecated components
    @Test
    @Disabled("Deprecated components")
    public void testLegacyReportEngine() {
        fail("Engine removed from engine package.");
    }

    // Case 25: A standard operational test that must run without bypass
    @Test
    public void testActiveEngine() {
        assertTrue(true); // This should execute normally
    }
}

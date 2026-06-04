package unitTesting;

import org.junit.jupiter.api.*;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GlobalResourceAssignments {
    private static Properties systemProps;

    @BeforeAll
    public static void setup(){
        systemProps = new Properties();
        systemProps.put("env", "production");
    }

    @AfterAll
    public static void clear(){
        systemProps.clear();
    }

    // Case 12: Assert "env" value is present
    @Test
    public void testEnvValuePresence(){
        boolean isContaining = systemProps.containsValue("production");
        assertTrue(isContaining, "System_Property_is_not_Containing_related_Object.");
    }

    @Test
    @DisplayName("Is_it_containing_env")
    public void testIfItContainsRelatedKey(){
        boolean isContaining = systemProps.containsKey("env");
        assertTrue(isContaining,"System_Property_is_not_Containing_related_Object.");
    }

    // Case 13: Assert "env" equals "production"
    @Test
    public void testEnvValueCorrectness(){
        assertEquals("production", systemProps.get("env"));
    }

    // Case 14: Assert non-existent key returns null
    @Test
    public void testMissingKey(){
        //Let's say that we have a non-existent value named: "keySubject"
        assertEquals(null, systemProps.get("keySubject"));

    }
    // Case 15: Assert size of map equals 1
    @Test
    public void testPropertySize(){
        int sizeOfMap = systemProps.size();
        assertEquals(1, sizeOfMap);
    }
}

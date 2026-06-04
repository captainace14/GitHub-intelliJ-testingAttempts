package unitTesting;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SystemServerTest {
    private static String serverToken;

    @BeforeAll
    public static void spinUpServer(){
        serverToken = "ACTIVE_SESSION_TOKEN_XYZ_123";
        System.out.println("Global Mock Server Started...");
    }

    @Test
    public void testConnectionHasToken(){
        assertNotNull(serverToken);
    }

    @AfterAll
    public static void shutDownServer(){
        serverToken = null;
        System.out.println("Global Mock Server Terminated...");
    }
}

package isolationTesting;

import net.jqwik.web.api.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.yeditepe.unitTesting.EmailValidator;
import org.yeditepe.unitTesting.UserService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private EmailValidator emailValidator; //This mock serves as our Stub.

    @Test
    void testCanLogin_WhenEmailIsValid_ReturnsTrue() {
        UserService userService = new UserService(emailValidator);

        when(emailValidator.isValid("abc@yeditepe.edu.tr")).thenReturn(true);

        boolean result = userService.canLogin("abc@yeditepe.edu.tr");

        assertTrue(result, "User should be able to login when email is valid.");
    }

    @Test
    void testCanLogin_WhenEmailIsInvalid_ReturnsFalse() {
        UserService userService = new UserService(emailValidator);

        when(emailValidator.isValid("invaild-email")).thenReturn(false);

        boolean result = userService.canLogin("invalid-email");

        assertFalse(result, "User should not be able to login when the email is invalid.");
    }


    @Test
    void testCanLogin_WhenEmailIsValidTwo() {
        UserService userService = new UserService(emailValidator);

        when(emailValidator.isValid("abc@outlook.com")).thenReturn(true);

        boolean result = userService.canLogin("abc@outlook.com");

        assertTrue(result);

    }
}

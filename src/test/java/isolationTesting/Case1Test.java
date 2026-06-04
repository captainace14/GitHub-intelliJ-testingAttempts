package isolationTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

interface EmailValidator {
    boolean isValid(String email);
}



class UserService {
    private final EmailValidator validator;
    public UserService(EmailValidator v) { this.validator = v; }
    public boolean canLogin(String email) { return validator.isValid(email); }
}


@ExtendWith(Extension.class)
public class Case1Test {

    @Mock
    private EmailValidator emailValidator;

    @Test
    void testValidEmailConLogin() {
        UserService userService = new UserService(emailValidator);

        //Stub: cases that we want the related hardcode like String a = "hello";
        //It allows us to test the related
        when(emailValidator.isValid("abc@outlook.com")).thenReturn(true);

        boolean result = userService.canLogin("abc@outlook.com");

        assertTrue(result);

    }
}

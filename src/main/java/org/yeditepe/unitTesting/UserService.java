package org.yeditepe.unitTesting;


public class UserService {
    private final EmailValidator validator;

    public UserService(EmailValidator validator) {
        this.validator = validator;
    }

    public boolean canLogin(String email) {
        return validator.isValid(email);
    }
}
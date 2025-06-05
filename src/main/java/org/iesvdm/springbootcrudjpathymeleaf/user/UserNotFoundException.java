package org.iesvdm.springbootcrudjpathymeleaf.user;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super(message);
    }
}

package ru.javamentor.springmvc.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class UserUsernameExistException extends DataIntegrityViolationException {
    public UserUsernameExistException(String msg) {
        super(msg);
    }
}
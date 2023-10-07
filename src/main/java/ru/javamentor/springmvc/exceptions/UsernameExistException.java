package ru.javamentor.springmvc.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class UsernameExistException extends DataIntegrityViolationException {

    public UsernameExistException(String msg) {
        super(msg);
    }
}

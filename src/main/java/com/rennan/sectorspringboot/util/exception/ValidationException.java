package com.rennan.sectorspringboot.util.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidationException extends Exception {

    private final List<ObjectError> errorList;

    public ValidationException(final List<ObjectError> errorList) {
        this.errorList = errorList;
    }

    public List<ObjectError> getErrorList() {
        return errorList;
    }
}

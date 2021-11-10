package com.rennan.sectorspringboot.view;

import com.rennan.sectorspringboot.util.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class BaseController {

    /**
     * method responsible from transform validation exception to http body response
     *
     * @param e {@link ValidationException}
     * @return {@link ResponseEntity<String>}
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<List<String>> handleValidationException(final ValidationException e) {
        List<String> messages = new ArrayList<>();
        for (final ObjectError objectError : e.getErrorList()) {
            messages.add(objectError.getCode());
        }
        return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
    }
}

package com.rennan.sectorspringboot.util;

import com.rennan.sectorspringboot.util.exception.ValidationException;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

public class ValidatorUtils {
    /**
     * Method responsable by execute validation from object following its validator
     *
     * @param object validated object.
     * @param validator validador.
     * @throws ValidationException if there are some problem at validation.
     */
    public static void validate(final Object object, final Validator validator) throws ValidationException {

        final DataBinder binder = new DataBinder(object);
        binder.setValidator(validator);
        binder.validate();

        if (binder.getBindingResult().hasErrors()) {
            throw new ValidationException(binder.getBindingResult().getAllErrors());
        }
    }
}

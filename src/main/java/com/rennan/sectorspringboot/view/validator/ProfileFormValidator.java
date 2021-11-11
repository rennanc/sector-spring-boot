package com.rennan.sectorspringboot.view.validator;

import com.rennan.sectorspringboot.view.dto.ProfileDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfileFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ProfileDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ProfileDto profileDto = (ProfileDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Field name is mandatory");
        if(profileDto.getSectorsIndexSelected().size() == 0){
            errors.reject("Field sector is mandatory");
        }
        if(!profileDto.isAgreeTerms()){
            errors.reject("It's necessary agree with terms");
        }
    }
}

package com.dmrval.hospitalapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {
    @Override
    public void initialize(NameConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext constraintValidatorContext) {
        return contactField != null && contactField.matches("[0-9]+");
    }
}

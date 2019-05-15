package com.dmrval.hospitalapp.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "Invalid Name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
package com.example.backend.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueOgrNoValidator.class })
public @interface UniqueOgrNo {
    String message() default "{backend.constraints.UniqueOgrNo.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
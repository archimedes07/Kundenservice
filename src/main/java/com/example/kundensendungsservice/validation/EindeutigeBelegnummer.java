package com.example.kundensendungsservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EindeutigeBelegnummerValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EindeutigeBelegnummer {
    String message() default "Belegnummer existiert bereits für diese Kundennummer.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

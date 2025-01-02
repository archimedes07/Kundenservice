package com.example.kundensendungsservice.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Constraint(validatedBy = EindeutigeBelegnummerValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EindeutigeBelegnummer {
    String message() default "Belegnummer existiert bereits für diese Kundennummer.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.example.kundensendungsservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AbrechnungssummeValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AbrechnungssummeRichtig {
	String message() default "Abrechnungssumme ist nicht korrekt.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

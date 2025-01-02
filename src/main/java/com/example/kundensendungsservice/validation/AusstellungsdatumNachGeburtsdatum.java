package com.example.kundensendungsservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AusstellungsdatumNachGeburtsdatumValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AusstellungsdatumNachGeburtsdatum {
	String message() default "Ausstellungsdatum darf nicht vor dem Geburtsdatum liegen.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

package com.example.kundensendungsservice.validation;

import jakarta.validation.Payload;

public @interface AusstellungsdatumVorGeburtsdatum {
	String message() default "Ausstellungsdatum darf nicht vor dem Geburtsdatum liegen.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

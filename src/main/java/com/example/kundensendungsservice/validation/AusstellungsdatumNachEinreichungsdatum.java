package com.example.kundensendungsservice.validation;

import jakarta.validation.Payload;

public @interface AusstellungsdatumNachEinreichungsdatum {
	String message() default "Ausstellungsdatum darf nicht nach dem Einreichungsdatum liegen.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

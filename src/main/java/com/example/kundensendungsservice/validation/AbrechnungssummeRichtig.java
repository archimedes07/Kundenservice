package com.example.kundensendungsservice.validation;

import jakarta.validation.Payload;

public @interface AbrechnungssummeRichtig {
	String message() default "Abrechnungssumme ist nicht korrekt.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

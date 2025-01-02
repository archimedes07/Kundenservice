package com.example.kundensendungsservice.validation;

import com.example.kundensendungsservice.domain.Sendung;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class AbrechnungssummeValidator implements ConstraintValidator<AbrechnungssummeRichtig, Sendung> {

    @Override
    public boolean isValid(Sendung sendung, ConstraintValidatorContext context) {
        if (sendung == null || sendung.getVerordnungen() == null) {
            return true;
        }
        
        BigDecimal berechneteSumme = sendung.getVerordnungen().stream()
            .flatMap(verordnung -> verordnung.getPositionen().stream())
            .map(position -> position.getEinzelpreis().multiply(BigDecimal.valueOf(position.getMenge())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);


        return sendung.getAbrechnungssumme().compareTo(berechneteSumme) == 0;
    }
}

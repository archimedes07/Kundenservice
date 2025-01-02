package com.example.kundensendungsservice.validation;

import com.example.kundensendungsservice.domain.Verordnung;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AusstellungsdatumNachGeburtsdatumValidator implements ConstraintValidator<AusstellungsdatumNachGeburtsdatum, Verordnung> {

    @Override
    public boolean isValid(Verordnung verordnung, ConstraintValidatorContext context) {
        if (verordnung == null || verordnung.getPatient() == null || verordnung.getPatient().getGeburtsdatum() == null) {
            return true;
        }

        LocalDate geburtsdatum = verordnung.getPatient().getGeburtsdatum();
        LocalDate ausstellungsdatum = verordnung.getAusstellungsdatum();

        if (ausstellungsdatum == null) {
            return true;
        }

        return !ausstellungsdatum.isBefore(geburtsdatum);
    }

}

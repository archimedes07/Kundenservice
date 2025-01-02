package com.example.kundensendungsservice.validation;

import com.example.kundensendungsservice.domain.Verordnung;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AusstellungsdatumVorGeburtsdatumValidator implements ConstraintValidator<AusstellungsdatumVorGeburtsdatum, Verordnung> {

    @Override
    public boolean isValid(Verordnung verordnung, ConstraintValidatorContext context) {
        if (verordnung == null || verordnung.getAusstellungsdatum() == null || verordnung.getPatient() == null) {
            return true; // Wenn keine Ausstellungsdatum oder Patient vorhanden ist, überspringe Validierung.
        }
        LocalDate ausstellungsdatum = verordnung.getAusstellungsdatum();
        LocalDate geburtsdatum = verordnung.getPatient().getGeburtsdatum();
        
        return !ausstellungsdatum.isBefore(geburtsdatum);
    }
}

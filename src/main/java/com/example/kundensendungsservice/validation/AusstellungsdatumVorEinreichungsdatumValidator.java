package com.example.kundensendungsservice.validation;

import com.example.kundensendungsservice.domain.Verordnung;
import com.example.kundensendungsservice.domain.Sendung;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AusstellungsdatumVorEinreichungsdatumValidator implements ConstraintValidator<AusstellungsdatumNachEinreichungsdatum, Verordnung> {

    private Sendung sendung;

    // Setter für das Sendungsobjekt
    public void setSendung(Sendung sendung) {
        this.sendung = sendung;
    }

    @Override
    public boolean isValid(Verordnung verordnung, ConstraintValidatorContext context) {
        if (verordnung == null || verordnung.getAusstellungsdatum() == null || sendung == null || sendung.getEinreichungsdatum() == null) {
            return true;
        }
        LocalDate ausstellungsdatum = verordnung.getAusstellungsdatum();
        LocalDate einreichungsdatum = sendung.getEinreichungsdatum();
        
        return !ausstellungsdatum.isAfter(einreichungsdatum);
    }
}

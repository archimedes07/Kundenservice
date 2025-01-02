package com.example.kundensendungsservice.validation;

import com.example.kundensendungsservice.domain.Sendung;
import com.example.kundensendungsservice.domain.Verordnung;
import com.example.kundensendungsservice.repository.SendungRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class EindeutigeBelegnummerValidator implements ConstraintValidator<EindeutigeBelegnummer, Sendung> {

    @Autowired
    private SendungRepository sendungRepository;

    @Override
    public boolean isValid(Sendung sendung, ConstraintValidatorContext context) {
        List<Sendung> sendungList = sendungRepository.findByKundennummer(sendung.getKundennummer());
        Set<String> belegnummernSet = new HashSet<>();

        for (Verordnung verordnung : sendung.getVerordnungen()) {
            if (belegnummernSet.contains(verordnung.getBelegnummer())) {
                return false;
            }
            belegnummernSet.add(verordnung.getBelegnummer());
        }

        for (Sendung otherSendung : sendungList) {
            if (!otherSendung.getId().equals(sendung.getId())) {
                for (Verordnung verordnung1 : otherSendung.getVerordnungen()) {
                    if (belegnummernSet.contains(verordnung1.getBelegnummer())) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}


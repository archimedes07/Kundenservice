package com.example.kundensendungsservice.service;

import com.example.kundensendungsservice.domain.Verordnung;
import com.example.kundensendungsservice.repository.VerordnungRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerordnungService {
    private final VerordnungRepository verordnungRepository;

    public VerordnungService(final VerordnungRepository verordnungRepository) {
        this.verordnungRepository = verordnungRepository;
    }

    public Optional<Verordnung> find(){
        return verordnungRepository.findByBelegnummerAndSendung_Id("BN123456789", 1L);
    }
}

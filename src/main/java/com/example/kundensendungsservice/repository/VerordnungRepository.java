package com.example.kundensendungsservice.repository;

import com.example.kundensendungsservice.domain.Verordnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerordnungRepository extends JpaRepository<Verordnung, Long> {
    Optional<Verordnung> findByBelegnummerAndSendung_Id(String belegnummer, Long sendungId);
}

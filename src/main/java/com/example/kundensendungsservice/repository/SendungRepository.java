package com.example.kundensendungsservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kundensendungsservice.domain.Sendung;

public interface SendungRepository extends JpaRepository<Sendung, Long> {

	Optional<Sendung> findBySendungsnummer(String sendungsnummer);

}

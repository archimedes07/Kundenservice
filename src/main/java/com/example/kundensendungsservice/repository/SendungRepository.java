package com.example.kundensendungsservice.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kundensendungsservice.domain.Sendung;
import org.springframework.stereotype.Repository;

@Repository
public interface SendungRepository extends JpaRepository<Sendung, Long> {
	Optional<Sendung> findBySendungsnummer(String sendungsnummer);
	List<Sendung> findByStatus(String status);
	List<Sendung> findByKundennummer(Integer kundennummer);
}

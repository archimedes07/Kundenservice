package com.example.kundensendungsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.kundensendungsservice.domain.Sendung;
import com.example.kundensendungsservice.service.SendungService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Sendung", description = "API zur Verwaltung von Sendungen")
public class SendungController {

	private final SendungService sendungService;

	public SendungController(final SendungService sendungService) {
		this.sendungService = sendungService;
	}

	@Operation(summary = "Sendung einreichen", description = "Reicht eine Sendung ein und gibt eine Sendungsnummer zurück")
	@PostMapping("/einreichen")
	public ResponseEntity<String> sendungEinreichen(@RequestBody @Valid Sendung sendung, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			StringBuilder errorMessage = new StringBuilder("Fehler bei der Validierung: ");
			bindingResult.getFieldErrors().forEach(error -> errorMessage.append(String.format("%s - %s; ", error.getField(), error.getDefaultMessage())));
			return ResponseEntity.badRequest().body(errorMessage.toString());
		}

		Sendung saved = sendungService.sendungEinreichen(sendung);
		return ResponseEntity.ok(saved.getSendungsnummer());
	}

	@Operation(summary = "Sendung abrufen", description = "Gibt die gesamte Sendung anhand der Sendungsnummer zurück")
	@GetMapping("/details/{sendungsnummer}")
	public ResponseEntity<Sendung> getSendungDetails(@PathVariable @Parameter(description = "Die Sendungsnummer der Sendung") String sendungsnummer) {
		return sendungService
				.getSendungBySendungsnummer(sendungsnummer)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@Operation(summary = "Status der Sendung abfragen", description = "Gibt den aktuellen Status der Sendung anhand der Sendungsnummer zurück")
	@GetMapping("/{sendungsnummer}")
	public ResponseEntity<String> getSendungStatus(@PathVariable @Parameter(description = "Die Sendungsnummer der Sendung") String sendungsnummer){
		return sendungService
				.getSendungBySendungsnummer(sendungsnummer)
				.map(sendung -> ResponseEntity.ok("Status der Sendung: " + sendung.getStatus()))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@Operation(summary = "Sendung stornieren", description = "Storniert eine Sendung, solange sie nicht abgerechnet wurde.")
	@PostMapping("/stornieren/{sendungsnummer}")
	public ResponseEntity<String> storniereSendung(@PathVariable String sendungsnummer) {
		try {
			sendungService.storniereSendung(sendungsnummer);
			return ResponseEntity.ok("Sendung storniert");
		} catch (IllegalStateException e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

}

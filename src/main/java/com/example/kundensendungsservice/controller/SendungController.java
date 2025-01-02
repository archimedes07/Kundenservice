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
import jakarta.validation.Valid;

@RestController
public class SendungController {

	private final SendungService sendungService;

	@Autowired
	public SendungController(final SendungService sendungService) {
		this.sendungService = sendungService;
	}

	@PostMapping("/einreichen")
	public ResponseEntity<String> sendungEinreichen(@RequestBody @Valid Sendung sendung, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			StringBuilder errorMessage = new StringBuilder("Fehler bei der Validierung: ");
			bindingResult.getFieldErrors().forEach(error -> errorMessage.append(String.format("%s - %s; ", error.getField(), error.getDefaultMessage())));
			return ResponseEntity.badRequest().body(errorMessage.toString());
		}
		sendung.setSendungsnummer(Sendung.generiereEindeutigeSendungsnummer(sendung));
		sendung.setStatus("eingereicht");
		Sendung saved = sendungService.sendungEinreichen(sendung);
		return ResponseEntity.ok(saved.getSendungsnummer());
	}

	@GetMapping("/{sendungsnummer}")
	public ResponseEntity<String> getSendungStatus(@PathVariable String sendungsnummer){
		return sendungService
				.getSendungBySendungsnummer(sendungsnummer)
				.map(sendung -> ResponseEntity.ok("Status der Sendung: "))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

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

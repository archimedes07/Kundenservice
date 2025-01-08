package com.example.kundensendungsservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.kundensendungsservice.domain.Sendung;
import com.example.kundensendungsservice.repository.SendungRepository;

@Service
public class SendungService {

	private final SendungRepository sendungRepository;

	public SendungService(final SendungRepository sendungRepository) {
		this.sendungRepository = sendungRepository;
	}

	public Optional<Sendung> getSendungBySendungsnummer(String sendungsnummer){
		return sendungRepository.findBySendungsnummer(sendungsnummer);
	}

	public Sendung sendungEinreichen(Sendung sendung){
		sendung.setSendungsnummer(Sendung.generiereEindeutigeSendungsnummer(sendung));
		sendung.getVerordnungen().forEach(verordnung -> verordnung.setSendung(sendung));
		sendung.getVerordnungen().forEach(verordnung -> verordnung.getPositionen().forEach(position -> position.setVerordnung(verordnung)));
		sendung.setStatus("eingereicht");
		return sendungRepository.save(sendung);
	}

	public void storniereSendung(final String sendungsnummer) {
		Optional<Sendung> sendungOptional = sendungRepository.findBySendungsnummer(sendungsnummer);
		if (sendungOptional.isPresent()) {
			Sendung sendung = sendungOptional.get();
			if ("ist abgerechnet".equals(sendung.getStatus())) {
				throw new IllegalStateException("Stornierung nicht möglich, Sendung ist bereits abgerechnet");
			}
			if ("storniert".equals(sendung.getStatus())) {
				throw new IllegalStateException("Stornierung nicht möglich, Sendung ist bereits storniert");
			}
			sendung.setStatus("storniert");
			sendungRepository.save(sendung);
		}
	}

	@Scheduled(fixedDelay = 10000)
	public void checkAndUpdateSendungStatus() {
		List<Sendung> sendungen = sendungRepository.findByStatus("eingereicht");

		for (Sendung sendung : sendungen) {
			sendung.setStatus("ist abgerechnet");
			sendungRepository.save(sendung);
		}
	}

}

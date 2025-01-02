package com.example.kundensendungsservice.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.example.kundensendungsservice.domain.Sendung;
import com.example.kundensendungsservice.repository.SendungRepository;

@Service
public class SendungService {

	private final SendungRepository sendungRepository;

	public SendungService(final SendungRepository sendungRepository) {
		this.sendungRepository = sendungRepository;
	}

	public Sendung sendungEinreichen(Sendung sendung){
		return sendungRepository.save(sendung);
	}

	public Optional<Sendung> getSendungBySendungsnummer(String sendungsnummer){
		return sendungRepository.findBySendungsnummer(sendungsnummer);
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

	/*@Async
	public void startStatusUpdateTimer(Sendung sendung) {
		try {
			TimeUnit.SECONDS.sleep(10);
			if (!sendung.getStatus().equals("ist abgerechnet")) {
				sendung.setStatus("ist abgerechnet");
				sendungRepository.save(sendung);
				System.out.println("Status der Sendung " + sendung.getSendungsnummer() + " auf 'ist abgerechnet' gesetzt.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 */

}

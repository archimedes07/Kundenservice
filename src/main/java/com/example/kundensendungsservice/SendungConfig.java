package com.example.kundensendungsservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.kundensendungsservice.domain.Patient;
import com.example.kundensendungsservice.domain.Position;
import com.example.kundensendungsservice.domain.Sendung;
import com.example.kundensendungsservice.domain.Verordnung;
import com.example.kundensendungsservice.repository.SendungRepository;

@Configuration
public class SendungConfig {

	/*@Bean
	CommandLineRunner commandLineRunner(SendungRepository repository){
		return args -> {
			Patient patient1 = new Patient();
			patient1.setVorname("Amir");
			patient1.setNachname("Asfour");
			patient1.setGeburtsdatum(LocalDate.of(2003, Month.JULY, 30));
			patient1.setStraße("Hans-Sachs-Straße");
			patient1.setOrt("Essen");
			patient1.setPostleitzahl("45307");
			patient1.setVersichertenstatus("versichertenstatus");
			patient1.setVersichertennummer("V123456789");
			patient1.setLaenderkennzeichenIsoA3("DEU");

			Position position1 = new Position();
			position1.setPositionsnummer("P12345");
			position1.setPositionstext("Positionstext");
			position1.setMenge(30);
			position1.setEinzelpreis(BigDecimal.valueOf(19.30));

			Sendung sendung = new Sendung();
			sendung.setAbrechnungssumme(BigDecimal.valueOf(50.57));
			sendung.setKundennummer(12345);
			sendung.setSendungsnummer(Sendung.generiereEindeutigeSendungsnummer(sendung));
			sendung.setStatus("eingereicht");

			Verordnung verordnung1 = new Verordnung();
			verordnung1.setBelegnummer("12345");
			verordnung1.setAusstellungsdatum(LocalDate.now());
			verordnung1.setKostentraegerName("AOK");
			verordnung1.setKostentraegerIk(12345);
			verordnung1.setVertragsarztnummer("12345");
			verordnung1.setBetriebsstaettennummer("1122334455");

			verordnung1.setSendung(sendung);
			verordnung1.setPatient(patient1);
			verordnung1.setPositionen(List.of(position1));
			sendung.setVerordnungen(List.of(verordnung1));
			position1.setVerordnung(verordnung1);

			repository.saveAll(List.of(sendung));
		};
	}*/

}

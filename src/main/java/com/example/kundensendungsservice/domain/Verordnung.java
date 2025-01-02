package com.example.kundensendungsservice.domain;

import java.time.LocalDate;
import java.util.List;

import com.example.kundensendungsservice.validation.AusstellungsdatumNachGeburtsdatum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@AusstellungsdatumNachGeburtsdatum
public class Verordnung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(max = 256, message = "Die Belegnummer darf maximal 256 Zeichen lang sein.")
	@NotBlank(message = "Die Belegnummer darf nicht leer sein.")
	private String belegnummer;

	@NotNull(message = "Das Ausstellungsdatum darf nicht null sein.")
	@Past(message = "Das Ausstellungsdatum muss in der Vergangenheit liegen.")
	private LocalDate ausstellungsdatum;

	@Size(max = 256, message = "Der Kostenträger-Name darf maximal 256 Zeichen lang sein.")
	@NotBlank(message = "Der Kostenträger-Name darf nicht leer sein.")
	private String kostentraegerName;

	@NotNull(message = "Das Kostenträger-IK darf nicht null sein.")
	private Integer kostentraegerIk;

	@Size(min = 9, max = 9, message = "Die Betriebsstättennummer muss genau 9 Zeichen lang sein.")
	private String betriebsstaettennummer;

	@Size(min = 9, max = 9, message = "Die Vertragsarztnummer muss genau 9 Zeichen lang sein.")
	private String vertragsarztnummer;

	@ManyToOne
	@JoinColumn(name = "sendung_id")
	private Sendung sendung;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@OneToMany(mappedBy = "verordnung", cascade = CascadeType.ALL)
	private List<Position> positionen;

	public Verordnung() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getBelegnummer() {
		return belegnummer;
	}

	public void setBelegnummer(final String belegnummer) {
		this.belegnummer = belegnummer;
	}

	public LocalDate getAusstellungsdatum() {
		return ausstellungsdatum;
	}

	public void setAusstellungsdatum(final LocalDate ausstellungsdatum) {
		this.ausstellungsdatum = ausstellungsdatum;
	}

	public String getKostentraegerName() {
		return kostentraegerName;
	}

	public void setKostentraegerName(final String kostentraegerName) {
		this.kostentraegerName = kostentraegerName;
	}

	public Integer getKostentraegerIk() {
		return kostentraegerIk;
	}

	public void setKostentraegerIk(final Integer kostentraegerIk) {
		this.kostentraegerIk = kostentraegerIk;
	}

	public String getBetriebsstaettennummer() {
		return betriebsstaettennummer;
	}

	public void setBetriebsstaettennummer(final String betriebsstaettennummer) {
		this.betriebsstaettennummer = betriebsstaettennummer;
	}

	public String getVertragsarztnummer() {
		return vertragsarztnummer;
	}

	public void setVertragsarztnummer(final String vertragsarztnummer) {
		this.vertragsarztnummer = vertragsarztnummer;
	}

	public Sendung getSendung() {
		return sendung;
	}

	public void setSendung(final Sendung sendung) {
		this.sendung = sendung;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(final Patient patient) {
		this.patient = patient;
	}

	public List<Position> getPositionen() {
		return positionen;
	}

	public void setPositionen(final List<Position> positionen) {
		this.positionen = positionen;
	}

	@Override
	public String toString() {
		return "Verordnung{" +
				"id=" + id +
				", belegnummer='" + belegnummer + '\'' +
				", ausstellungsdatum=" + ausstellungsdatum +
				", kostentraegerName='" + kostentraegerName + '\'' +
				", kostentraegerIk=" + kostentraegerIk +
				", betriebsstaettennummer='" + betriebsstaettennummer + '\'' +
				", vertragsarztnummer='" + vertragsarztnummer + '\'' +
				", sendung=" + sendung.getSendungsnummer() +
				", patient=" + patient +
				", positionen=" + positionen +
				'}';
	}
}

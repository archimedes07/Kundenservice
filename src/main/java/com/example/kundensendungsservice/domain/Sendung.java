package com.example.kundensendungsservice.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Sendung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Integer kundennummer;

	@NotNull
	private BigDecimal abrechnungssumme;

	@OneToMany(mappedBy = "sendung", cascade = CascadeType.ALL)
	private List<Verordnung> verordnungen;

	@NotNull
	private String sendungsnummer;

	private LocalDate einreichungsdatum;

	private String status;

	public Sendung() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Integer getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(final Integer kundennummer) {
		this.kundennummer = kundennummer;
	}

	public BigDecimal getAbrechnungssumme() {
		return abrechnungssumme;
	}

	public void setAbrechnungssumme(final BigDecimal abrechnungssumme) {
		this.abrechnungssumme = abrechnungssumme;
	}

	public List<Verordnung> getVerordnungen() {
		return verordnungen;
	}

	public void setVerordnungen(final List<Verordnung> verordnungen) {
		this.verordnungen = verordnungen;
	}

	public LocalDate getEinreichungsdatum() {
		return einreichungsdatum;
	}

	public void setEinreichungsdatum(final LocalDate einreichungsdatum) {
		this.einreichungsdatum = einreichungsdatum;
	}

	public String getSendungsnummer() {
		return sendungsnummer;
	}

	public void setSendungsnummer(final String sendungsnummer) {
		this.sendungsnummer = sendungsnummer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public static String generiereEindeutigeSendungsnummer(Sendung sendung){
		return UUID.randomUUID().toString();
	}
}

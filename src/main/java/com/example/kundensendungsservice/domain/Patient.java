package com.example.kundensendungsservice.domain;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Vorname darf nicht null sein.")
	@Size(max = 256, message = "Vorname darf maximal 256 Zeichen lang sein.")
	private String vorname;

	@NotNull(message = "Nachname darf nicht null sein.")
	@Size(max = 256, message = "Nachname darf maximal 256 Zeichen lang sein.")
	private String nachname;

	@NotNull(message = "Geburtsdatum darf nicht null sein.")
	private LocalDate geburtsdatum;

	@NotNull(message = "Versichertennummer darf nicht null sein.")
	@Size(min = 12, max = 12, message = "Versichertennummer muss genau 12 Zeichen lang sein.")
	private String versichertennummer;

	@NotNull(message = "Versichertenstatus darf nicht null sein.")
	@Size(min = 5, max = 5, message = "Versichertenstatus muss genau 5 Zeichen lang sein.")
	private String versichertenstatus;

	@NotNull(message = "Straße darf nicht null sein.")
	@Size(max = 256, message = "Straße darf maximal 256 Zeichen lang sein.")
	private String straße;

	@NotNull(message = "Postleitzahl darf nicht null sein.")
	@Size(max = 10, message = "Postleitzahl darf maximal 10 Zeichen lang sein.")
	private String postleitzahl;

	@NotNull(message = "Ort darf nicht null sein.")
	@Size(max = 256, message = "Ort darf maximal 256 Zeichen lang sein.")
	private String ort;

	@NotNull(message = "Länderkennzeichen darf nicht null sein.")
	@Size(min = 3, max = 3, message = "Länderkennzeichen muss genau 3 Zeichen lang sein.")
	private String laenderkennzeichen;

	public Patient() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(final String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(final String nachname) {
		this.nachname = nachname;
	}

	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(final LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getVersichertennummer() {
		return versichertennummer;
	}

	public void setVersichertennummer(final String versichertennummer) {
		this.versichertennummer = versichertennummer;
	}

	public String getVersichertenstatus() {
		return versichertenstatus;
	}

	public void setVersichertenstatus(final String versichertenstatus) {
		this.versichertenstatus = versichertenstatus;
	}

	public String getStraße() {
		return straße;
	}

	public void setStraße(final String straße) {
		this.straße = straße;
	}

	public String getPostleitzahl() {
		return postleitzahl;
	}

	public void setPostleitzahl(final String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(final String ort) {
		this.ort = ort;
	}

	public String getLaenderkennzeichen() {
		return laenderkennzeichen;
	}

	public void setLaenderkennzeichenIsoA3(final String laenderkennzeichen) {
		this.laenderkennzeichen = laenderkennzeichen;
	}
}

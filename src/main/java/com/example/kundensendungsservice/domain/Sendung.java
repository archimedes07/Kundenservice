package com.example.kundensendungsservice.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.example.kundensendungsservice.validation.AbrechnungssummeRichtig;
import com.example.kundensendungsservice.validation.EindeutigeBelegnummer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
@AbrechnungssummeRichtig
public class Sendung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Integer kundennummer;

	@NotNull
	private BigDecimal abrechnungssumme;

	@OneToMany(mappedBy = "sendung", cascade = CascadeType.ALL)
	@Valid
	private List<Verordnung> verordnungen;

	private String sendungsnummer;

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

	@Override
	public String toString() {
		return "Sendung{" +
				"id=" + id +
				", kundennummer=" + kundennummer +
				", abrechnungssumme=" + abrechnungssumme +
				", verordnungen=" + verordnungen +
				", sendungsnummer='" + sendungsnummer + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}

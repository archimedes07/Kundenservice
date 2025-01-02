package com.example.kundensendungsservice.domain;

import java.math.BigDecimal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Positionsnummer darf nicht null sein.")
	@Size(max = 10, message = "Positionsnummer darf maximal 10 Zeichen lang sein.")
	private String positionsnummer;

	@NotNull(message = "Positionstext darf nicht null sein.")
	@Size(max = 256, message = "Positionstext darf maximal 256 Zeichen lang sein.")
	private String positionstext;

	@NotNull(message = "Einzelpreis darf nicht null sein.")
	private BigDecimal einzelpreis;

	@NotNull(message = "Menge darf nicht null sein.")
	@Positive(message = "Menge muss eine positive Zahl sein.")
	private Integer menge;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "verordnung_id")
	private Verordnung verordnung;

	public Position() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getPositionsnummer() {
		return positionsnummer;
	}

	public void setPositionsnummer(final String positionsnummer) {
		this.positionsnummer = positionsnummer;
	}

	public String getPositionstext() {
		return positionstext;
	}

	public void setPositionstext(final String positionstext) {
		this.positionstext = positionstext;
	}

	public BigDecimal getEinzelpreis() {
		return einzelpreis;
	}

	public void setEinzelpreis(final BigDecimal einzelpreis) {
		this.einzelpreis = einzelpreis;
	}

	public Integer getMenge() {
		return menge;
	}

	public void setMenge(final Integer menge) {
		this.menge = menge;
	}

	public Verordnung getVerordnung() {
		return verordnung;
	}

	public void setVerordnung(final Verordnung verordnung) {
		this.verordnung = verordnung;
	}
}

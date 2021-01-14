package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the namirnica database table.
 * 
 */
@Entity
@NamedQuery(name="Namirnica.findAll", query="SELECT n FROM Namirnica n")
public class Namirnica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idnamirnica;

	private int cena;

	private int kalorije;

	private int kolicina;

	private String naziv;

	private String vrsta;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idkorisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Receptnamirnica
	@JsonIgnore
	@OneToMany(mappedBy="namirnica")
	private List<Receptnamirnica> receptnamirnicas;

	public Namirnica() {
	}

	public int getIdnamirnica() {
		return this.idnamirnica;
	}

	public void setIdnamirnica(int idnamirnica) {
		this.idnamirnica = idnamirnica;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getKalorije() {
		return this.kalorije;
	}

	public void setKalorije(int kalorije) {
		this.kalorije = kalorije;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getVrsta() {
		return this.vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Receptnamirnica> getReceptnamirnicas() {
		return this.receptnamirnicas;
	}

	public void setReceptnamirnicas(List<Receptnamirnica> receptnamirnicas) {
		this.receptnamirnicas = receptnamirnicas;
	}

	public Receptnamirnica addReceptnamirnica(Receptnamirnica receptnamirnica) {
		getReceptnamirnicas().add(receptnamirnica);
		receptnamirnica.setNamirnica(this);

		return receptnamirnica;
	}

	public Receptnamirnica removeReceptnamirnica(Receptnamirnica receptnamirnica) {
		getReceptnamirnicas().remove(receptnamirnica);
		receptnamirnica.setNamirnica(null);

		return receptnamirnica;
	}

}
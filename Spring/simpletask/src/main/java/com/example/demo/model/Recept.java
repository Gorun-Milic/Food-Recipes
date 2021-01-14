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
 * The persistent class for the recept database table.
 * 
 */
@Entity
@NamedQuery(name="Recept.findAll", query="SELECT r FROM Recept r")
public class Recept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrecept;

	private int cena;

	private int kalorije;

	private String naziv;

	private String opis;

	//bi-directional many-to-one association to Korak
	@JsonIgnore
	@OneToMany(mappedBy="recept")
	private List<Korak> koraks;

	//bi-directional many-to-one association to Priprema
	@JsonIgnore
	@OneToMany(mappedBy="recept")
	private List<Priprema> pripremas;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idkorisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Receptnamirnica
	@JsonIgnore
	@OneToMany(mappedBy="recept")
	private List<Receptnamirnica> receptnamirnicas;

	public Recept() {
	}

	public int getIdrecept() {
		return this.idrecept;
	}

	public void setIdrecept(int idrecept) {
		this.idrecept = idrecept;
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

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Korak> getKoraks() {
		return this.koraks;
	}

	public void setKoraks(List<Korak> koraks) {
		this.koraks = koraks;
	}

	public Korak addKorak(Korak korak) {
		getKoraks().add(korak);
		korak.setRecept(this);

		return korak;
	}

	public Korak removeKorak(Korak korak) {
		getKoraks().remove(korak);
		korak.setRecept(null);

		return korak;
	}

	public List<Priprema> getPripremas() {
		return this.pripremas;
	}

	public void setPripremas(List<Priprema> pripremas) {
		this.pripremas = pripremas;
	}

	public Priprema addPriprema(Priprema priprema) {
		getPripremas().add(priprema);
		priprema.setRecept(this);

		return priprema;
	}

	public Priprema removePriprema(Priprema priprema) {
		getPripremas().remove(priprema);
		priprema.setRecept(null);

		return priprema;
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
		receptnamirnica.setRecept(this);

		return receptnamirnica;
	}

	public Receptnamirnica removeReceptnamirnica(Receptnamirnica receptnamirnica) {
		getReceptnamirnicas().remove(receptnamirnica);
		receptnamirnica.setRecept(null);

		return receptnamirnica;
	}

}
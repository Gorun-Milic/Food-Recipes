package com.example.demo.dto;

public class PrijavaDTO {

	private String korisnickoime;
	private String lozinka;
	
	public PrijavaDTO(String korisnickoime, String lozinka) {
		this.korisnickoime = korisnickoime;
		this.lozinka = lozinka;
	}

	public String getKorisnickoime() {
		return korisnickoime;
	}

	public void setKorisnickoime(String korisnickoime) {
		this.korisnickoime = korisnickoime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	
	
}

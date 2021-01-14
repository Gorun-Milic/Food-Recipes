package com.example.demo.dto;

public class PretragaDTO {
	
	private int cena;
	private int kalorije;
	
	public PretragaDTO(int cena, int kalorije) {
		super();
		this.cena = cena;
		this.kalorije = kalorije;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getKalorije() {
		return kalorije;
	}

	public void setKalorije(int kalorije) {
		this.kalorije = kalorije;
	}
	
	
	
	

}

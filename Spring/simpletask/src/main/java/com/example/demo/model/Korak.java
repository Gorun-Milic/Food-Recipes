package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the korak database table.
 * 
 */
@Entity
@NamedQuery(name="Korak.findAll", query="SELECT k FROM Korak k")
public class Korak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorak;

	private String opis;

	private int paralelno;

	private int trajanje;

	//bi-directional many-to-one association to Recept
	@ManyToOne
	@JoinColumn(name="idrecept")
	private Recept recept;

	public Korak() {
	}

	public int getIdkorak() {
		return this.idkorak;
	}

	public void setIdkorak(int idkorak) {
		this.idkorak = idkorak;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getParalelno() {
		return this.paralelno;
	}

	public void setParalelno(int paralelno) {
		this.paralelno = paralelno;
	}

	public int getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public Recept getRecept() {
		return this.recept;
	}

	public void setRecept(Recept recept) {
		this.recept = recept;
	}

}
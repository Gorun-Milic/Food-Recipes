package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the receptnamirnica database table.
 * 
 */
@Entity
@NamedQuery(name="Receptnamirnica.findAll", query="SELECT r FROM Receptnamirnica r")
public class Receptnamirnica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idreceptnamirnica;

	private int kolicina;

	//bi-directional many-to-one association to Namirnica
	@ManyToOne
	@JoinColumn(name="idnamirnica")
	private Namirnica namirnica;

	//bi-directional many-to-one association to Recept
	@ManyToOne
	@JoinColumn(name="idrecept")
	private Recept recept;

	public Receptnamirnica() {
	}

	public int getIdreceptnamirnica() {
		return this.idreceptnamirnica;
	}

	public void setIdreceptnamirnica(int idreceptnamirnica) {
		this.idreceptnamirnica = idreceptnamirnica;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Namirnica getNamirnica() {
		return this.namirnica;
	}

	public void setNamirnica(Namirnica namirnica) {
		this.namirnica = namirnica;
	}

	public Recept getRecept() {
		return this.recept;
	}

	public void setRecept(Recept recept) {
		this.recept = recept;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the priprema database table.
 * 
 */
@Entity
@NamedQuery(name="Priprema.findAll", query="SELECT p FROM Priprema p")
public class Priprema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpriprema;

	@Temporal(TemporalType.DATE)
	private Date datum;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vreme;

	//bi-directional many-to-one association to Recept
	@ManyToOne
	@JoinColumn(name="idrecept")
	private Recept recept;

	public Priprema() {
	}

	public int getIdpriprema() {
		return this.idpriprema;
	}

	public void setIdpriprema(int idpriprema) {
		this.idpriprema = idpriprema;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getVreme() {
		return this.vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}

	public Recept getRecept() {
		return this.recept;
	}

	public void setRecept(Recept recept) {
		this.recept = recept;
	}

}
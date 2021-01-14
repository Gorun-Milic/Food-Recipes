package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorisnik;

	private int bmi;

	private String email;

	private int godiste;

	private String ime;

	private String korisnickoime;

	private String lozinka;

	private int masa;

	private String prezime;

	private String telefon;

	private int visina;

	//bi-directional many-to-one association to Namirnica
	@OneToMany(mappedBy="korisnik")
	private List<Namirnica> namirnicas;

	//bi-directional many-to-one association to Recept
	@OneToMany(mappedBy="korisnik")
	private List<Recept> recepts;

	public Korisnik() {
	}

	public int getIdkorisnik() {
		return this.idkorisnik;
	}

	public void setIdkorisnik(int idkorisnik) {
		this.idkorisnik = idkorisnik;
	}

	public int getBmi() {
		return this.bmi;
	}

	public void setBmi(int bmi) {
		this.bmi = bmi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGodiste() {
		return this.godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getKorisnickoime() {
		return this.korisnickoime;
	}

	public void setKorisnickoime(String korisnickoime) {
		this.korisnickoime = korisnickoime;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public int getMasa() {
		return this.masa;
	}

	public void setMasa(int masa) {
		this.masa = masa;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getVisina() {
		return this.visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public List<Namirnica> getNamirnicas() {
		return this.namirnicas;
	}

	public void setNamirnicas(List<Namirnica> namirnicas) {
		this.namirnicas = namirnicas;
	}

	public Namirnica addNamirnica(Namirnica namirnica) {
		getNamirnicas().add(namirnica);
		namirnica.setKorisnik(this);

		return namirnica;
	}

	public Namirnica removeNamirnica(Namirnica namirnica) {
		getNamirnicas().remove(namirnica);
		namirnica.setKorisnik(null);

		return namirnica;
	}

	public List<Recept> getRecepts() {
		return this.recepts;
	}

	public void setRecepts(List<Recept> recepts) {
		this.recepts = recepts;
	}

	public Recept addRecept(Recept recept) {
		getRecepts().add(recept);
		recept.setKorisnik(this);

		return recept;
	}

	public Recept removeRecept(Recept recept) {
		getRecepts().remove(recept);
		recept.setKorisnik(null);

		return recept;
	}

}
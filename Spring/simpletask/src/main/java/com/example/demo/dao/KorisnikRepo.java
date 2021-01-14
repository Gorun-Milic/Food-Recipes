package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Korisnik;

public interface KorisnikRepo extends JpaRepository<Korisnik, Integer> {
	
	@Query("from Korisnik where korisnickoime=?1 or lozinka=?2")
	public List<Korisnik> vecPostoji(String korisnickoime, String lozinka);
	
	@Query("from Korisnik where korisnickoime=?1 and lozinka=?2")
	public List<Korisnik> validacijaKorisnika(String korisnickoime, String lozinka);

}

package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Namirnica;

public interface NamirnicaRepo extends JpaRepository<Namirnica, Integer> {

	@Query("from Namirnica where idkorisnik=?1")
	public List<Namirnica> namirniceKorisnika(int idkorisnik);
	
}

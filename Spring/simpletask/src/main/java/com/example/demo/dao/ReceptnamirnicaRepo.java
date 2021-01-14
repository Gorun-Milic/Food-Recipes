package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Recept;
import com.example.demo.model.Receptnamirnica;

public interface ReceptnamirnicaRepo extends JpaRepository<Receptnamirnica, Integer> {

	@Query("from Receptnamirnica where recept=?1")
	public List<Receptnamirnica> dobaviReceptnamirnica(Recept recept);
	
}
